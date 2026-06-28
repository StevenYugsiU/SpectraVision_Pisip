package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IHistoriaClinicaUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.HistoriaClinica;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IHistoriaClinicaRepositorio;

public class HistoriaClinicaUseCaseImpl implements IHistoriaClinicaUseCase{
	
	private final IHistoriaClinicaRepositorio repositorio;

	public HistoriaClinicaUseCaseImpl(IHistoriaClinicaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public HistoriaClinica guardar(HistoriaClinica nuevaHistoriaClinica) {
		return repositorio.guardar(nuevaHistoriaClinica);
	}

	@Override
	public HistoriaClinica buscarPorId(int idHistoriaClinica) {
		return repositorio.buscarPorId(idHistoriaClinica).orElseThrow(() -> new RuntimeException("No se encontro Historia Clinica"));
	}

	@Override
	public List<HistoriaClinica> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idHistoriaClinica) {
		repositorio.eliminar(idHistoriaClinica);
		
	}
	
	

	
}
