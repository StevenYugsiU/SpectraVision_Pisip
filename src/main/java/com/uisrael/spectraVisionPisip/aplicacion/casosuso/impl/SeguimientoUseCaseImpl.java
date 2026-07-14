package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ISeguimientoUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Seguimiento;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ISeguimientoRepositorio;

public class SeguimientoUseCaseImpl implements ISeguimientoUseCase {
	
	private final ISeguimientoRepositorio repositorio;
	
	
	public SeguimientoUseCaseImpl(ISeguimientoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	
	@Override
	public Seguimiento guardar(Seguimiento nuevoSeguimiento) {
		return repositorio.guardar(nuevoSeguimiento);
	}

	@Override
	public Seguimiento actualizar(int idSeguimiento, Seguimiento seguimientoActualizado) {

		Seguimiento existente = buscarPorId(idSeguimiento);

		existente.setFechaSeguimiento(seguimientoActualizado.getFechaSeguimiento());
		existente.setObservaciones(seguimientoActualizado.getObservaciones());
		existente.setEstado(seguimientoActualizado.getEstado());

		return repositorio.guardar(existente);
	}

	@Override
	public Seguimiento buscarPorId(int idSeguimiento) {
		return repositorio.buscarPorId(idSeguimiento).orElseThrow(() -> new RuntimeException("No se encontro Rol"));
	}

	@Override
	public List<Seguimiento> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idSeguimiento) {
		repositorio.eliminar(idSeguimiento);

	}

	@Override
	public List<Seguimiento> buscarPorIdEntrega(int idEntrega) {
		return repositorio.buscarPorIdEntrega(idEntrega);
	}

}
