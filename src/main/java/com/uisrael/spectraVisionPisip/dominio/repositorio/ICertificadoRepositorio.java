package com.uisrael.spectraVisionPisip.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.Certificado;

public interface ICertificadoRepositorio {
	
	Certificado guardar(Certificado nuevoCertificado);
	
	Optional<Certificado> buscarPorId(int idCertificado);
	
	List<Certificado> listarTodos();

	void eliminar(int idCertificado);

	List<Certificado> buscarPorIdExamen(int idExamen);

}
