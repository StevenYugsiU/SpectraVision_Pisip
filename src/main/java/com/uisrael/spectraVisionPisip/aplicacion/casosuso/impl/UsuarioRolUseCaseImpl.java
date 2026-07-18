package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IUsuarioRolUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.UsuarioRol;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IRolRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRolRepositorio;

public class UsuarioRolUseCaseImpl implements IUsuarioRolUseCase {

	private final IUsuarioRolRepositorio repositorio;
	private final IUsuarioRepositorio usuarioRepositorio;
	private final IRolRepositorio rolRepositorio;

	public UsuarioRolUseCaseImpl(IUsuarioRolRepositorio repositorio, IUsuarioRepositorio usuarioRepositorio,
			IRolRepositorio rolRepositorio) {
		this.repositorio = repositorio;
		this.usuarioRepositorio = usuarioRepositorio;
		this.rolRepositorio = rolRepositorio;
	}


	@Override
	public UsuarioRol guardar(UsuarioRol nuevoUsuarioRol) {

		usuarioRepositorio.buscarPorId(nuevoUsuarioRol.getIdUsuario())
				.orElseThrow(() -> new RuntimeException(
						"No se encontro el usuario con id " + nuevoUsuarioRol.getIdUsuario()));

		rolRepositorio.buscarPorId(nuevoUsuarioRol.getIdRol())
				.orElseThrow(() -> new RuntimeException("No se encontro el rol con id " + nuevoUsuarioRol.getIdRol()));

		return repositorio.guardar(nuevoUsuarioRol);
	}

	@Override
	public UsuarioRol actualizar(int idUsuarioRol, UsuarioRol usuarioRolActualizado) {

		UsuarioRol existente = buscarPorId(idUsuarioRol);

		rolRepositorio.buscarPorId(usuarioRolActualizado.getIdRol())
				.orElseThrow(() -> new RuntimeException(
						"No se encontro el rol con id " + usuarioRolActualizado.getIdRol()));

		existente.setIdRol(usuarioRolActualizado.getIdRol());

		return repositorio.guardar(existente);
	}

	@Override
	public UsuarioRol buscarPorId(int idUsuarioRol) {
		return repositorio.buscarPorId(idUsuarioRol).orElseThrow(() -> new RuntimeException("No se encontro UsuarioRol"));

	}

	@Override
	public List<UsuarioRol> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idUsuarioRol) {
		repositorio.eliminar(idUsuarioRol);
	}

}
