package com.uisrael.spectraVisionPisip.dominio.entidades;

import java.util.Date;

public class HistoriaClinica {
	
	private int idHistoriaClinica;
	private int idCliente;
	private Date fechaApertura;
	private String antecedentes;
	private String observacionesGenerales;
	private Boolean estado;
	
	
	public HistoriaClinica(int idHistoriaClinica, int idCliente, Date fechaApertura, String antecedentes,
			String observacionesGenerales, Boolean estado) {
		super();
		this.idHistoriaClinica = idHistoriaClinica;
		this.idCliente = idCliente;
		this.fechaApertura = fechaApertura;
		this.antecedentes = antecedentes;
		this.observacionesGenerales = observacionesGenerales;
		this.estado = estado;
	}


	public int getIdHistoriaClinica() {
		return idHistoriaClinica;
	}


	public void setIdHistoriaClinica(int idHistoriaClinica) {
		this.idHistoriaClinica = idHistoriaClinica;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public Date getFechaApertura() {
		return fechaApertura;
	}


	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}


	public String getAntecedentes() {
		return antecedentes;
	}


	public void setAntecedentes(String antecedentes) {
		this.antecedentes = antecedentes;
	}


	public String getObservacionesGenerales() {
		return observacionesGenerales;
	}


	public void setObservacionesGenerales(String observacionesGenerales) {
		this.observacionesGenerales = observacionesGenerales;
	}


	public Boolean getEstado() {
		return estado;
	}


	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	
	
	

	
	
}
