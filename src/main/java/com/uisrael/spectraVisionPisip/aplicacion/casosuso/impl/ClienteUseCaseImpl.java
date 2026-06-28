package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IClienteUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IClienteRepositorio;

public class ClienteUseCaseImpl implements IClienteUseCase{

	private final IClienteRepositorio repositorio;
	
	
	public ClienteUseCaseImpl(IClienteRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Cliente guardar(Cliente nuevoCliente) {
		return repositorio.guardar(nuevoCliente);
	}

	@Override
	public Cliente buscarPorId(int idCliente) {
		return repositorio.buscarPorId(idCliente).orElseThrow(() -> new RuntimeException("No se encontro Cliente"));
	}

	@Override
	public List<Cliente> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idCliente) {
		repositorio.eliminar(idCliente);
		
	}

}
