package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ISeguimientoUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Seguimiento;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IEntregaRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ISeguimientoRepositorio;

public class SeguimientoUseCaseImpl implements ISeguimientoUseCase {

	private final ISeguimientoRepositorio repositorio;
	private final IEntregaRepositorio entregaRepositorio;


	public SeguimientoUseCaseImpl(ISeguimientoRepositorio repositorio, IEntregaRepositorio entregaRepositorio) {
		this.repositorio = repositorio;
		this.entregaRepositorio = entregaRepositorio;
	}


	@Override
	public Seguimiento guardar(Seguimiento nuevoSeguimiento) {

		entregaRepositorio.buscarPorId(nuevoSeguimiento.getIdEntrega())
				.orElseThrow(() -> new RuntimeException(
						"No se encontro la entrega con id " + nuevoSeguimiento.getIdEntrega()));

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

	@Override
	public List<Seguimiento> buscarAlertasPendientes(int diasProximidad) {
		Date desde = Date.from(Instant.now());
		Date hasta = Date.from(Instant.now().plus(diasProximidad, ChronoUnit.DAYS));
		return repositorio.buscarProximos(desde, hasta);
	}

}
