package com.uisrael.spectraVisionPisip.dominio.entidades;

import java.util.Date;

public class Seguimiento {
	private int idSeguimiento;
	private Entrega fkEntrega;
	private Date fechaSeguimiento;
	private String observaciones;
	private String estado;

	public Seguimiento(int idSeguimiento, Entrega fkEntrega, Date fechaSeguimiento, String observaciones,
			String estado) {
		this.idSeguimiento = idSeguimiento;
		this.fkEntrega = fkEntrega;
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
	public Entrega getFkEntrega() {
		return fkEntrega;
	}
	public void setFkEntrega(Entrega fkEntrega) {
		this.fkEntrega = fkEntrega;
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
