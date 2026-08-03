package com.uisrael.spectraVisionPisip.presentacion.dto.response;

import java.util.Date;
import java.util.List;

public class HistoriaClinicaResponseDto {

	private int idHistoriaClinica;
	private ClienteResponseDto fkCliente;
	private Date fechaApertura;
	private String antecedentes;
	private String observacionesGenerales;
	private Boolean estado;
	private List<ExamenVisualResumenDto> examenesVisuales;

	public int getIdHistoriaClinica() {
		return idHistoriaClinica;
	}
	public void setIdHistoriaClinica(int idHistoriaClinica) {
		this.idHistoriaClinica = idHistoriaClinica;
	}
	public ClienteResponseDto getFkCliente() {
		return fkCliente;
	}
	public void setFkCliente(ClienteResponseDto fkCliente) {
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
	public List<ExamenVisualResumenDto> getExamenesVisuales() {
		return examenesVisuales;
	}
	public void setExamenesVisuales(List<ExamenVisualResumenDto> examenesVisuales) {
		this.examenesVisuales = examenesVisuales;
	}

}
