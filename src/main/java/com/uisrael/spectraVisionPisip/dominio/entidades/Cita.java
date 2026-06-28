package com.uisrael.spectraVisionPisip.dominio.entidades;

import java.time.LocalTime;
import java.util.Date;

public class Cita {
	private int idCita;
	private int idCliente;
	private Date fecha;
	private LocalTime hora;
	private String tipoCita;
	private String estado;
	
	
	
	public Cita(int idCita, int idCliente, Date fecha, LocalTime hora, String tipoCita, String estado) {
		this.idCita = idCita;
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.hora = hora;
		this.tipoCita = tipoCita;
		this.estado = estado;
	}
	
	public int getIdCita() {
		return idCita;
	}
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getTipoCita() {
		return tipoCita;
	}
	public void setTipoCita(String tipoCita) {
		this.tipoCita = tipoCita;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
}
