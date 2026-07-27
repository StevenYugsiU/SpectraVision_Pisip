package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IAuthUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.LoginResultado;
import com.uisrael.spectraVisionPisip.dominio.entidades.Usuario;
import com.uisrael.spectraVisionPisip.dominio.excepciones.CredencialesInvalidasException;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IRolRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRolRepositorio;

public class AuthUseCaseImpl implements IAuthUseCase {

	private static final String MENSAJE_CREDENCIALES_INVALIDAS = "Usuario o contraseña incorrectos";

	private final IUsuarioRepositorio usuarioRepositorio;
	private final IUsuarioRolRepositorio usuarioRolRepositorio;
	private final IRolRepositorio rolRepositorio;
	private final PasswordEncoder passwordEncoder;

	public AuthUseCaseImpl(IUsuarioRepositorio usuarioRepositorio, IUsuarioRolRepositorio usuarioRolRepositorio,
			IRolRepositorio rolRepositorio, PasswordEncoder passwordEncoder) {
		this.usuarioRepositorio = usuarioRepositorio;
		this.usuarioRolRepositorio = usuarioRolRepositorio;
		this.rolRepositorio = rolRepositorio;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public LoginResultado login(String usuario, String contrasena) {

		Usuario encontrado = usuarioRepositorio.buscarPorUsuario(usuario)
				.orElseThrow(() -> new CredencialesInvalidasException(MENSAJE_CREDENCIALES_INVALIDAS));

		if (!passwordEncoder.matches(contrasena, encontrado.getContrasena())) {
			throw new CredencialesInvalidasException(MENSAJE_CREDENCIALES_INVALIDAS);
		}

		if (!Boolean.TRUE.equals(encontrado.getEstado())) {
			throw new CredencialesInvalidasException("El usuario se encuentra inactivo");
		}

		List<String> roles = usuarioRolRepositorio.buscarPorIdUsuario(encontrado.getIdUsuario()).stream()
				.map(usuarioRol -> rolRepositorio.buscarPorId(usuarioRol.getIdRol())
						.map(rol -> rol.getNombre())
						.orElse(null))
				.filter(Objects::nonNull)
				.toList();

		return new LoginResultado(encontrado, roles);
	}

}
