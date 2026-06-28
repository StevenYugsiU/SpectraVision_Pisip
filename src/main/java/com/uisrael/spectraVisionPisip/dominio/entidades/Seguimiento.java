package com.uisrael.spectraVisionPisip.dominio.entidades;

import java.util.Date;

public class Seguimiento {
	private int idSeguimiento;
	private int idCliente;
	private Date fechaEntrega;
	private Date fechaSeguimiento;
	private String observaciones;
	private String estado;
	
	public Seguimiento(int idSeguimiento, int idCliente, Date fechaEntrega, Date fechaSeguimiento, String observaciones,
			String estado) {
		this.idSeguimiento = idSeguimiento;
		this.idCliente = idCliente;
		this.fechaEntrega = fechaEntrega;
		this.fechaSeguimiento = fechaSeguimiento;
		this.observaciones = observaciones;
		this.estado = estado;
	}
	
	
	public int getIdSeguimiento() {
		return idSeguimiento;
	}
	public void setIdSeguimiento(int idSeguimiento) {
		this.idSeguimiento = idSeguimiento;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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
