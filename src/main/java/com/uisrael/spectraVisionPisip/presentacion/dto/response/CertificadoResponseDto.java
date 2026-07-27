package com.uisrael.spectraVisionPisip.presentacion.dto.response;

import java.util.Date;

public class CertificadoResponseDto {
	private int idCertificado;
	private ExamenVisualResponseDto fkExamenVisual;
	private Date fechaGeneracion;
	private String observaciones;

	public int getIdCertificado() {
		return idCertificado;
	}
	public void setIdCertificado(int idCertificado) {
		this.idCertificado = idCertificado;
	}
	public ExamenVisualResponseDto getFkExamenVisual() {
		return fkExamenVisual;
	}
	public void setFkExamenVisual(ExamenVisualResponseDto fkExamenVisual) {
		this.fkExamenVisual = fkExamenVisual;
	}
	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}
	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}



}
