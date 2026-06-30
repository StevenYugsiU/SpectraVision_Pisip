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
		return repositorio.guardar(nuevoUsuario);
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
