package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Usuario;
import com.uisrael.spectraVisionPisip.dominio.excepciones.RecursoNoEncontradoException;
import com.uisrael.spectraVisionPisip.dominio.excepciones.ReglaNegocioException;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRepositorio;

public class UsuarioUseCaseImpl implements IUsuarioUseCase {

	private final IUsuarioRepositorio repositorio;
	private final PasswordEncoder passwordEncoder;


	public UsuarioUseCaseImpl(IUsuarioRepositorio repositorio, PasswordEncoder passwordEncoder) {
		this.repositorio = repositorio;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Usuario guardar(Usuario nuevoUsuario) {

		if (nuevoUsuario.getContrasena() == null || nuevoUsuario.getContrasena().isBlank()) {
			throw new IllegalArgumentException("La contraseña es obligatoria");
		}

		repositorio.buscarPorUsuario(nuevoUsuario.getUsuario()).ifPresent(existente -> {
			throw new ReglaNegocioException("Ya existe un usuario registrado con el nombre de usuario "
					+ nuevoUsuario.getUsuario());
		});

		repositorio.buscarPorCorreo(nuevoUsuario.getCorreo()).ifPresent(existente -> {
			throw new ReglaNegocioException("Ya existe un usuario registrado con el correo "
					+ nuevoUsuario.getCorreo());
		});

		nuevoUsuario.setContrasena(passwordEncoder.encode(nuevoUsuario.getContrasena()));
		nuevoUsuario.setEstado(true);

		return repositorio.guardar(nuevoUsuario);
	}

	@Override
	public Usuario actualizar(int idUsuario, Usuario usuarioActualizado) {

		Usuario existente = buscarPorId(idUsuario);

		repositorio.buscarPorUsuario(usuarioActualizado.getUsuario()).ifPresent(otro -> {
			if (otro.getIdUsuario() != idUsuario) {
				throw new ReglaNegocioException(
						"Ya existe otro usuario registrado con el nombre de usuario " + usuarioActualizado.getUsuario());
			}
		});

		repositorio.buscarPorCorreo(usuarioActualizado.getCorreo()).ifPresent(otro -> {
			if (otro.getIdUsuario() != idUsuario) {
				throw new ReglaNegocioException(
						"Ya existe otro usuario registrado con el correo " + usuarioActualizado.getCorreo());
			}
		});

		existente.setNombres(usuarioActualizado.getNombres());
		existente.setApellidos(usuarioActualizado.getApellidos());
		existente.setUsuario(usuarioActualizado.getUsuario());
		existente.setCorreo(usuarioActualizado.getCorreo());
		if (usuarioActualizado.getContrasena() != null && !usuarioActualizado.getContrasena().isBlank()) {
			existente.setContrasena(passwordEncoder.encode(usuarioActualizado.getContrasena()));
		}
		existente.setEstado(usuarioActualizado.getEstado());

		return repositorio.guardar(existente);
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		return repositorio.buscarPorId(idUsuario).orElseThrow(() -> new RecursoNoEncontradoException("No se encontro Usuario"));
	}

	@Override
	public List<Usuario> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idUsuario) {
		repositorio.eliminar(idUsuario);

	}

}
