package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IHistoriaClinicaUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.HistoriaClinica;
import com.uisrael.spectraVisionPisip.dominio.excepciones.RecursoNoEncontradoException;
import com.uisrael.spectraVisionPisip.dominio.excepciones.ReglaNegocioException;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IClienteRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IExamenVisualRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IHistoriaClinicaRepositorio;

public class HistoriaClinicaUseCaseImpl implements IHistoriaClinicaUseCase {

	private final IHistoriaClinicaRepositorio repositorio;
	private final IClienteRepositorio clienteRepositorio;
	private final IExamenVisualRepositorio examenVisualRepositorio;

	public HistoriaClinicaUseCaseImpl(IHistoriaClinicaRepositorio repositorio, IClienteRepositorio clienteRepositorio,
			IExamenVisualRepositorio examenVisualRepositorio) {
		this.repositorio = repositorio;
		this.clienteRepositorio = clienteRepositorio;
		this.examenVisualRepositorio = examenVisualRepositorio;
	}

	private HistoriaClinica conExamenes(HistoriaClinica historia) {
		historia.setExamenesVisuales(examenVisualRepositorio.buscarPorIdHistoria(historia.getIdHistoriaClinica()));
		return historia;
	}

	@Override
	public HistoriaClinica guardar(HistoriaClinica nuevaHistoriaClinica) {

		int idCliente = nuevaHistoriaClinica.getFkCliente().getIdCliente();

		clienteRepositorio.buscarPorId(idCliente)
				.orElseThrow(() -> new RecursoNoEncontradoException(
						"No se encontro el cliente con id " + idCliente));

		repositorio.buscarPorIdCliente(idCliente).ifPresent(existente -> {
			throw new ReglaNegocioException("El cliente con id " + idCliente
					+ " ya tiene una historia clínica registrada.");
		});

		return conExamenes(repositorio.guardar(nuevaHistoriaClinica));
	}

	@Override
	public HistoriaClinica buscarPorId(int idHistoriaClinica) {
		HistoriaClinica encontrada = repositorio.buscarPorId(idHistoriaClinica)
				.orElseThrow(() -> new RecursoNoEncontradoException("No se encontro Historia Clinica"));
		return conExamenes(encontrada);
	}

	@Override
	public List<HistoriaClinica> listarTodos() {
		return repositorio.listarTodos().stream()
				.map(this::conExamenes)
				.toList();
	}

	@Override
	public void eliminar(int idHistoriaClinica) {
		repositorio.eliminar(idHistoriaClinica);

	}

	@Override
	public HistoriaClinica buscarPorIdCliente(int idCliente) {
		HistoriaClinica encontrada = repositorio.buscarPorIdCliente(idCliente).orElseThrow(
				() -> new RecursoNoEncontradoException("No se encontró una historia clínica para el cliente con id " + idCliente));
		return conExamenes(encontrada);
	}

	@Override
	public HistoriaClinica actualizar(int idHistoriaClinica, HistoriaClinica historiaActualizada) {

		HistoriaClinica existente = repositorio.buscarPorId(idHistoriaClinica)
				.orElseThrow(() -> new RecursoNoEncontradoException("No se encontro Historia Clinica"));

		existente.setAntecedentes(historiaActualizada.getAntecedentes());
		existente.setObservacionesGenerales(historiaActualizada.getObservacionesGenerales());
		existente.setEstado(historiaActualizada.getEstado());

		return conExamenes(repositorio.guardar(existente));
	}

}
