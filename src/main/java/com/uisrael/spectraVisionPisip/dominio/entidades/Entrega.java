package com.uisrael.spectraVisionPisip.dominio.entidades;

import java.util.Date;

public class Entrega {

	private int idEntrega;
	private Cliente fkCliente;
	private Date fechaEntrega;
	private String observaciones;
	private String estado;

	public Entrega() {
	}

	public Entrega(int idEntrega, Cliente fkCliente, Date fechaEntrega, String observaciones, String estado) {
		this.idEntrega = idEntrega;
		this.fkCliente = fkCliente;
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
	public Cliente getFkCliente() {
		return fkCliente;
	}
	public void setFkCliente(Cliente fkCliente) {
		this.fkCliente = fkCliente;
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
