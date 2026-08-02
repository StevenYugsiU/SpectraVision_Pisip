package com.uisrael.spectraVisionPisip.dominio.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoriaClinica {

	private int idHistoriaClinica;
	private Cliente fkCliente;
	private Date fechaApertura;
	private String antecedentes;
	private String observacionesGenerales;
	private Boolean estado;
	private List<ExamenVisual> examenesVisuales = new ArrayList<>();

	public HistoriaClinica() {
	}

	public HistoriaClinica(int idHistoriaClinica, Cliente fkCliente, Date fechaApertura, String antecedentes,
			String observacionesGenerales, Boolean estado) {
		this.idHistoriaClinica = idHistoriaClinica;
		this.fkCliente = fkCliente;
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


	public Cliente getFkCliente() {
		return fkCliente;
	}


	public void setFkCliente(Cliente fkCliente) {
		this.fkCliente = fkCliente;
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

	public List<ExamenVisual> getExamenesVisuales() {
		return examenesVisuales;
	}

	public void setExamenesVisuales(List<ExamenVisual> examenesVisuales) {
		this.examenesVisuales = examenesVisuales;
	}

}
