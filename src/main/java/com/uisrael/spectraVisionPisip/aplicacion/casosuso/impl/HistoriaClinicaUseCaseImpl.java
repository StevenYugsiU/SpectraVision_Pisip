package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IHistoriaClinicaUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.HistoriaClinica;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IHistoriaClinicaRepositorio;

public class HistoriaClinicaUseCaseImpl implements IHistoriaClinicaUseCase {

	private final IHistoriaClinicaRepositorio repositorio;

	public HistoriaClinicaUseCaseImpl(IHistoriaClinicaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public HistoriaClinica guardar(HistoriaClinica nuevaHistoriaClinica) {

		repositorio.buscarPorIdCliente(nuevaHistoriaClinica.getIdCliente()).ifPresent(existente -> {
			throw new RuntimeException("El cliente con id " + nuevaHistoriaClinica.getIdCliente()
					+ " ya tiene una historia clínica registrada.");
		});

		return repositorio.guardar(nuevaHistoriaClinica);
	}

	@Override
	public HistoriaClinica buscarPorId(int idHistoriaClinica) {
		return repositorio.buscarPorId(idHistoriaClinica)
				.orElseThrow(() -> new RuntimeException("No se encontro Historia Clinica"));
	}

	@Override
	public List<HistoriaClinica> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idHistoriaClinica) {
		repositorio.eliminar(idHistoriaClinica);

	}

	@Override
	public HistoriaClinica buscarPorIdCliente(int idCliente) {
		return repositorio.buscarPorIdCliente(idCliente).orElseThrow(
				() -> new RuntimeException("No se encontró una historia clínica para el cliente con id " + idCliente));
	}

	@Override
	public HistoriaClinica actualizar(int idHistoriaClinica, HistoriaClinica historiaActualizada) {

		HistoriaClinica existente = buscarPorId(idHistoriaClinica);

		existente.setAntecedentes(historiaActualizada.getAntecedentes());
		existente.setObservacionesGenerales(historiaActualizada.getObservacionesGenerales());
		existente.setEstado(historiaActualizada.getEstado());

		return repositorio.guardar(existente);
	}

}
