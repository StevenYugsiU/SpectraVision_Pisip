package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IPasswordResetUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.PasswordResetToken;
import com.uisrael.spectraVisionPisip.dominio.entidades.Usuario;
import com.uisrael.spectraVisionPisip.dominio.excepciones.RecursoNoEncontradoException;
import com.uisrael.spectraVisionPisip.dominio.excepciones.ReglaNegocioException;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IPasswordResetTokenRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRepositorio;

public class PasswordResetUseCaseImpl implements IPasswordResetUseCase {

	private static final int EXPIRACION_MINUTOS = 30;

	private final IUsuarioRepositorio usuarioRepositorio;
	private final IPasswordResetTokenRepositorio tokenRepositorio;
	private final PasswordEncoder passwordEncoder;
	private final JavaMailSender mailSender;
	private final String frontendResetUrl;

	public PasswordResetUseCaseImpl(IUsuarioRepositorio usuarioRepositorio,
			IPasswordResetTokenRepositorio tokenRepositorio, PasswordEncoder passwordEncoder,
			JavaMailSender mailSender, String frontendResetUrl) {
		this.usuarioRepositorio = usuarioRepositorio;
		this.tokenRepositorio = tokenRepositorio;
		this.passwordEncoder = passwordEncoder;
		this.mailSender = mailSender;
		this.frontendResetUrl = frontendResetUrl;
	}

	@Override
	public void solicitarReset(String usuario) {
		usuarioRepositorio.buscarPorUsuario(usuario)
				.filter(encontrado -> encontrado.getCorreo() != null && !encontrado.getCorreo().isBlank())
				.ifPresent(this::generarYEnviarToken);
		// Si el usuario no existe o no tiene correo registrado, no se informa nada
		// al llamador para evitar enumeracion de usuarios validos.
	}

	private void generarYEnviarToken(Usuario encontrado) {
		PasswordResetToken resetToken = new PasswordResetToken();
		resetToken.setToken(UUID.randomUUID().toString());
		resetToken.setIdUsuario(encontrado.getIdUsuario());
		resetToken.setFechaExpiracion(Instant.now().plus(EXPIRACION_MINUTOS, ChronoUnit.MINUTES));
		resetToken.setUsado(false);
		tokenRepositorio.guardar(resetToken);

		enviarCorreoRecuperacion(encontrado, resetToken.getToken());
	}

	private void enviarCorreoRecuperacion(Usuario usuario, String token) {
		SimpleMailMessage mensaje = new SimpleMailMessage();
		mensaje.setTo(usuario.getCorreo());
		mensaje.setSubject("Recuperación de contraseña - SpectraVision");
		mensaje.setText("Hola " + usuario.getNombres() + ",\n\n"
				+ "Recibimos una solicitud para restablecer tu contraseña. Ingresa al siguiente enlace "
				+ "(valido por " + EXPIRACION_MINUTOS + " minutos):\n\n"
				+ frontendResetUrl + "?token=" + token + "\n\n"
				+ "Si no solicitaste este cambio, puedes ignorar este mensaje.");
		mailSender.send(mensaje);
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
