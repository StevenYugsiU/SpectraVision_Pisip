package com.uisrael.spectraVisionPisip.dominio.entidades;

import java.util.Date;

public class Certificado {

	private int idCertificado;
	private ExamenVisual fkExamenVisual;
	private Date fechaGeneracion;
	private String observaciones;

	public Certificado() {
	}

	public Certificado(int idCertificado, ExamenVisual fkExamenVisual, Date fechaGeneracion, String observaciones) {
		this.idCertificado = idCertificado;
		this.fkExamenVisual = fkExamenVisual;
		this.fechaGeneracion = fechaGeneracion;
		this.observaciones = observaciones;
	}

	public int getIdCertificado() {
		return idCertificado;
	}
	public void setIdCertificado(int idCertificado) {
		this.idCertificado = idCertificado;
	}
	public ExamenVisual getFkExamenVisual() {
		return fkExamenVisual;
	}
	public void setFkExamenVisual(ExamenVisual fkExamenVisual) {
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
