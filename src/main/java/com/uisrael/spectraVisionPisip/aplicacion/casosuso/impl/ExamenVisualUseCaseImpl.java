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
	public ExamenVisual actualizar(int idExamenVisual,
			ExamenVisual examenActualizado) {

		ExamenVisual existente = buscarPorId(idExamenVisual);

		existente.setFechaExamen(examenActualizado.getFechaExamen());
		existente.setUltimoControlVisual(examenActualizado.getUltimoControlVisual());
		existente.setMotivoConsulta(examenActualizado.getMotivoConsulta());

		existente.setAvOd(examenActualizado.getAvOd());
		existente.setAvOi(examenActualizado.getAvOi());

		existente.setSphOd(examenActualizado.getSphOd());
		existente.setCylOd(examenActualizado.getCylOd());
		existente.setEjeOd(examenActualizado.getEjeOd());

		existente.setSphOi(examenActualizado.getSphOi());
		existente.setCylOi(examenActualizado.getCylOi());
		existente.setEjeOi(examenActualizado.getEjeOi());

		existente.setAddValor(examenActualizado.getAddValor());
		existente.setDnp(examenActualizado.getDnp());
		existente.setAltura(examenActualizado.getAltura());

		existente.setBiomicroscopia(examenActualizado.getBiomicroscopia());
		existente.setRecomentaciones(examenActualizado.getRecomentaciones());
		existente.setProximaConsulta(examenActualizado.getProximaConsulta());
		existente.setDiagnostico(examenActualizado.getDiagnostico());

		return repositorio.guardar(existente);
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
	
	@Override
	public List<ExamenVisual> buscarPorIdHistoria(int idHistoriaClinica) {
		return repositorio.buscarPorIdHistoria(idHistoriaClinica);
	}

}
