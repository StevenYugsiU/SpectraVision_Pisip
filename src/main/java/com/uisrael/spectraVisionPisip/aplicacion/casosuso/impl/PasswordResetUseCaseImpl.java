package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IPasswordResetUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.PasswordResetToken;
import com.uisrael.spectraVisionPisip.dominio.entidades.Usuario;
import com.uisrael.spectraVisionPisip.dominio.excepciones.RecursoNoEncontradoException;
import com.uisrael.spectraVisionPisip.dominio.excepciones.ReglaNegocioException;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IPasswordResetTokenRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRepositorio;
import com.uisrael.spectraVisionPisip.dominio.servicios.IEmailService;

public class PasswordResetUseCaseImpl implements IPasswordResetUseCase {

	private static final int EXPIRACION_MINUTOS = 30;

	private final IUsuarioRepositorio usuarioRepositorio;
	private final IPasswordResetTokenRepositorio tokenRepositorio;
	private final PasswordEncoder passwordEncoder;
	private final IEmailService emailService;

	public PasswordResetUseCaseImpl(IUsuarioRepositorio usuarioRepositorio,
			IPasswordResetTokenRepositorio tokenRepositorio, PasswordEncoder passwordEncoder,
			IEmailService emailService) {
		this.usuarioRepositorio = usuarioRepositorio;
		this.tokenRepositorio = tokenRepositorio;
		this.passwordEncoder = passwordEncoder;
		this.emailService = emailService;
	}

	@Override
	public void solicitarReset(String usuario, String resetPasswordUrl) {
		usuarioRepositorio.buscarPorUsuario(usuario)
				.filter(encontrado -> encontrado.getCorreo() != null && !encontrado.getCorreo().isBlank())
				.ifPresent(encontrado -> generarYEnviarToken(encontrado, resetPasswordUrl));
	}

	private void generarYEnviarToken(Usuario encontrado, String resetPasswordUrl) {
		PasswordResetToken resetToken = new PasswordResetToken();
		resetToken.setToken(UUID.randomUUID().toString());
		resetToken.setIdUsuario(encontrado.getIdUsuario());
		resetToken.setFechaExpiracion(Instant.now().plus(EXPIRACION_MINUTOS, ChronoUnit.MINUTES));
		resetToken.setUsado(false);
		tokenRepositorio.guardar(resetToken);

		enviarCorreoRecuperacion(encontrado, resetToken.getToken(), resetPasswordUrl);
	}

	private void enviarCorreoRecuperacion(Usuario usuario, String token, String resetPasswordUrl) {
		String cuerpo = "Hola " + usuario.getNombres() + ",\n\n"
				+ "Recibimos una solicitud para restablecer tu contraseña. Ingresa al siguiente enlace "
				+ "(valido por " + EXPIRACION_MINUTOS + " minutos):\n\n"
				+ resetPasswordUrl + "?token=" + token + "\n\n"
				+ "Si no solicitaste este cambio, puedes ignorar este mensaje.";
		emailService.enviarCorreo(usuario.getCorreo(), "Recuperación de contraseña - SpectraVision", cuerpo);
	}

	@Override
	public void restablecer(String token, String nuevaContrasena) {
		PasswordResetToken resetToken = tokenRepositorio.buscarPorToken(token)
				.orElseThrow(() -> new RecursoNoEncontradoException("El enlace de recuperación no es válido"));

		if (Boolean.TRUE.equals(resetToken.getUsado())) {
			throw new ReglaNegocioException("El enlace de recuperación ya fue utilizado");
		}

		if (resetToken.getFechaExpiracion().isBefore(Instant.now())) {
			throw new ReglaNegocioException("El enlace de recuperación ha expirado");
		}

		Usuario usuario = usuarioRepositorio.buscarPorId(resetToken.getIdUsuario())
				.orElseThrow(() -> new RecursoNoEncontradoException("No se encontró el usuario asociado al enlace"));

		usuario.setContrasena(passwordEncoder.encode(nuevaContrasena));
		usuarioRepositorio.guardar(usuario);

		resetToken.setUsado(true);
		tokenRepositorio.guardar(resetToken);
	}

}
