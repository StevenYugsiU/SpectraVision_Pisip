package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IRolUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Rol;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IRolRepositorio;

public class RolUseCaseImpl implements IRolUseCase {
	
	private final IRolRepositorio repositorio;
	

	public RolUseCaseImpl(IRolRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Rol guardar(Rol nuevoRol) {
		return repositorio.guardar(nuevoRol);
	}

	@Override
	public Rol buscarPorId(int idRol) {
		return repositorio.buscarPorId(idRol).orElseThrow(() -> new RuntimeException("No se encontro Rol"));
	}

	@Override
	public List<Rol> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idRol) {
		repositorio.eliminar(idRol);
		
	}
	

}
