package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ICertificadoUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Certificado;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ICertificadoRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IExamenVisualRepositorio;

public class CertificadoUseCaseImpl implements ICertificadoUseCase{

	private final ICertificadoRepositorio repositorio;
	private final IExamenVisualRepositorio examenVisualRepositorio;


	public CertificadoUseCaseImpl(ICertificadoRepositorio repositorio, IExamenVisualRepositorio examenVisualRepositorio) {
		this.repositorio = repositorio;
		this.examenVisualRepositorio = examenVisualRepositorio;
	}

	@Override
	public Certificado guardar(Certificado nuevoCertificado) {

		examenVisualRepositorio.buscarPorId(nuevoCertificado.getIdExamen())
				.orElseThrow(() -> new RuntimeException(
						"No se encontro el examen visual con id " + nuevoCertificado.getIdExamen()));

		return repositorio.guardar(nuevoCertificado);
	}

	@Override
	public Certificado actualizar(int idCertificado, Certificado certificadoActualizado) {

		Certificado existente = buscarPorId(idCertificado);

		existente.setFechaGeneracion(certificadoActualizado.getFechaGeneracion());
		existente.setObservaciones(certificadoActualizado.getObservaciones());

		return repositorio.guardar(existente);
	}

	@Override
	public Certificado buscarPorId(int idCertificado) {
		return repositorio.buscarPorId(idCertificado).orElseThrow(() -> new RuntimeException("No se encontro Historia Certificado"));
	}

	@Override
	public List<Certificado> listarTodos() {
		return repositorio.listarTodos();

	}

	@Override
	public void eliminar(int idCertificado) {
		repositorio.eliminar(idCertificado);

	}

	@Override
	public List<Certificado> buscarPorIdExamen(int idExamen) {
		return repositorio.buscarPorIdExamen(idExamen);
	}

}
