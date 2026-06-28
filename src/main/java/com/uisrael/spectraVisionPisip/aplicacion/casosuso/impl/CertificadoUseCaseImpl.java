package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ICertificadoUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Certificado;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ICertificadoRepositorio;

public class CertificadoUseCaseImpl implements ICertificadoUseCase{

	private final ICertificadoRepositorio repositorio;
	
	
	public CertificadoUseCaseImpl(ICertificadoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Certificado guardar(Certificado nuevoCertificado) {
		return repositorio.guardar(nuevoCertificado);
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

}
