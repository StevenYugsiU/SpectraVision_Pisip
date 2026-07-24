package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Usuario;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRepositorio;

public class UsuarioUseCaseImpl implements IUsuarioUseCase {
	
	private final IUsuarioRepositorio repositorio;
	

	public UsuarioUseCaseImpl(IUsuarioRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Usuario guardar(Usuario nuevoUsuario) {

		repositorio.buscarPorUsuario(nuevoUsuario.getUsuario()).ifPresent(existente -> {
			throw new RuntimeException("Ya existe un usuario registrado con el nombre de usuario "
					+ nuevoUsuario.getUsuario());
		});

		return repositorio.guardar(nuevoUsuario);
	}

	@Override
	public Usuario actualizar(int idUsuario, Usuario usuarioActualizado) {

		Usuario existente = buscarPorId(idUsuario);

		repositorio.buscarPorUsuario(usuarioActualizado.getUsuario()).ifPresent(otro -> {
			if (otro.getIdUsuario() != idUsuario) {
				throw new RuntimeException(
						"Ya existe otro usuario registrado con el nombre de usuario " + usuarioActualizado.getUsuario());
			}
		});

		existente.setNombres(usuarioActualizado.getNombres());
		existente.setApellidos(usuarioActualizado.getApellidos());
		existente.setUsuario(usuarioActualizado.getUsuario());
		existente.setContrasena(usuarioActualizado.getContrasena());
		existente.setEstado(usuarioActualizado.getEstado());

		return repositorio.guardar(existente);
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		return repositorio.buscarPorId(idUsuario).orElseThrow(() -> new RuntimeException("No se encontro Usuario"));
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
