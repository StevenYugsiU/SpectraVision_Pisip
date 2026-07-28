package com.uisrael.spectraVisionPisip.presentacion.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaResponseDto {

	private int idCita;
	private ClienteResponseDto fkCliente;
	private LocalDate fecha;
	private LocalTime hora;
	private String tipoCita;
	private String estado;

	public int getIdCita() {
		return idCita;
	}
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	public ClienteResponseDto getFkCliente() {
		return fkCliente;
	}
	public void setFkCliente(ClienteResponseDto fkCliente) {
		this.fkCliente = fkCliente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
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
