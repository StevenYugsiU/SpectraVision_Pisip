package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ICitaUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Cita;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ICitaRepositorio;

public class CitaUseCaseImpl implements ICitaUseCase{
	
	private final ICitaRepositorio repositorio;
	
	

	public CitaUseCaseImpl(ICitaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Cita guardar(Cita nuevaCita) {
		return repositorio.guardar(nuevaCita);
	}

	@Override
	public Cita buscarPorId(int idCita) {
		return repositorio.buscarPorId(idCita).orElseThrow(() -> new RuntimeException("No se encontro Cita Medica"));
	}

	@Override
	public List<Cita> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idCita) {
		repositorio.eliminar(idCita);
		
	}
	
	

}
