package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IUsuarioRolUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.UsuarioRol;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRolRepositorio;

public class UsuarioRolUseCaseImpl implements IUsuarioRolUseCase {
	
	private final IUsuarioRolRepositorio repositorio;
	
	public UsuarioRolUseCaseImpl(IUsuarioRolRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	

	@Override
	public UsuarioRol guardar(UsuarioRol nuevoUsuarioRol) {
		return repositorio.guardar(nuevoUsuarioRol);
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
