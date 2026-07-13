package com.uisrael.spectraVisionPisip.presentacion.dto.response;

import java.util.Date;

public class SeguimientoResponseDto {

	private int idSeguimiento;
	private int idEntrega;
	private Date fechaSeguimiento;
	private String observaciones;
	private String estado;

	public int getIdSeguimiento() {
		return idSeguimiento;
	}
	public void setIdSeguimiento(int idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}
	public int getIdEntrega() {
		return idEntrega;
	}
	public void setIdEntrega(int idEntrega) {
		this.idEntrega = idEntrega;
	}
	public Date getFechaSeguimiento() {
		return fechaSeguimiento;
	}
	public void setFechaSeguimiento(Date fechaSeguimiento) {
		this.fechaSeguimiento = fechaSeguimiento;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
