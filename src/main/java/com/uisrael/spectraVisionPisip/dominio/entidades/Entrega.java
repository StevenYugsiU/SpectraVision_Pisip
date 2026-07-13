package com.uisrael.spectraVisionPisip.dominio.entidades;

import java.util.Date;

public class Entrega {

	private int idEntrega;
	private int idCliente;
	private Date fechaEntrega;
	private String observaciones;
	private String estado;

	public Entrega(int idEntrega, int idCliente, Date fechaEntrega, String observaciones, String estado) {
		this.idEntrega = idEntrega;
		this.idCliente = idCliente;
		this.fechaEntrega = fechaEntrega;
		this.observaciones = observaciones;
		this.estado = estado;
	}

	public int getIdEntrega() {
		return idEntrega;
	}
	public void setIdEntrega(int idEntrega) {
		this.idEntrega = idEntrega;
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
