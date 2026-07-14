package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IEntregaUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Entrega;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IEntregaRepositorio;

public class EntregaUseCaseImpl implements IEntregaUseCase {

	private final IEntregaRepositorio repositorio;

	public EntregaUseCaseImpl(IEntregaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Entrega guardar(Entrega nuevaEntrega) {
		return repositorio.guardar(nuevaEntrega);
	}

	@Override
	public Entrega actualizar(int idEntrega, Entrega entregaActualizada) {

		Entrega existente = buscarPorId(idEntrega);

		existente.setFechaEntrega(entregaActualizada.getFechaEntrega());
		existente.setObservaciones(entregaActualizada.getObservaciones());
		existente.setEstado(entregaActualizada.getEstado());

		return repositorio.guardar(existente);
	}

	@Override
	public Entrega buscarPorId(int idEntrega) {
		return repositorio.buscarPorId(idEntrega).orElseThrow(() -> new RuntimeException("No se encontro Entrega"));
	}

	@Override
	public List<Entrega> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idEntrega) {
		repositorio.eliminar(idEntrega);
	}

	@Override
	public List<Entrega> buscarPorIdCliente(int idCliente) {
		return repositorio.buscarPorIdCliente(idCliente);
	}

}
