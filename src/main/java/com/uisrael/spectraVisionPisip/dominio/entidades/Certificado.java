package com.uisrael.spectraVisionPisip.dominio.entidades;

import java.util.Date;

public class Certificado {

	private int idCertificado;
	private int idExamen;
	private Date fechaGeneracion;
	private String observaciones;
	
	
	
	public Certificado(int idCertificado, int idExamen, Date fechaGeneracion, String observaciones) {
		this.idCertificado = idCertificado;
		this.idExamen = idExamen;
		this.fechaGeneracion = fechaGeneracion;
		this.observaciones = observaciones;
	}
	
	public int getIdCertificado() {
		return idCertificado;
	}
	public void setIdCertificado(int idCertificado) {
		this.idCertificado = idCertificado;
	}
	public int getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(int idExamen) {
		this.idExamen = idExamen;
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
