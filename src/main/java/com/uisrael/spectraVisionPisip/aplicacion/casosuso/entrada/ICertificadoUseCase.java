package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.spectraVisionPisip.dominio.entidades.Certificado;

public interface ICertificadoUseCase {
		
	
	Certificado guardar(Certificado nuevoCertificado);
	
	Certificado buscarPorId(int idCertificado);
	
	List<Certificado> listarTodos();
	
	void eliminar(int idCertificado);

}
