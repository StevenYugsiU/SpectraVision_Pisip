package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IExamenVisualUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.ExamenVisual;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IExamenVisualRepositorio;

public class ExamenVisualUseCaseImpl implements IExamenVisualUseCase{

	private final IExamenVisualRepositorio repositorio;
	
	
	public ExamenVisualUseCaseImpl(IExamenVisualRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public ExamenVisual guardar(ExamenVisual nuevoExamenVisual) {
		return repositorio.guardar(nuevoExamenVisual);
	}

	@Override
	public ExamenVisual buscarPorId(int idExamenVisual) {
		return repositorio.buscarPorId(idExamenVisual).orElseThrow(() -> new RuntimeException("No se encontro Examen Visual"));
	}

	@Override
	public List<ExamenVisual> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idExamenVisual) {
		repositorio.eliminar(idExamenVisual);
		
	}

}
