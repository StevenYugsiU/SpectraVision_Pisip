package com.uisrael.spectraVisionPisip.dominio.entidades;

import java.util.Date;

public class Cliente {

	private int idCliente;
	private String cedula;
	private String nombres;
	private String apellidos;
	private Date fechaNacimiento;
	private int edad;
	private String ocupacion;
	private String celular;
	private String correo;
	private Date fechaRegistro;
	private Boolean estado;



	public Cliente(int idCliente, String cedula, String nombres, String apellidos, Date fechaNacimiento, int edad,
			String ocupacion, String celular, String correo, Date fechaRegistro, Boolean estado) {
		this.idCliente = idCliente;
		setCedula(cedula);
		setNombres(nombres);
		setApellidos(apellidos);
		this.fechaNacimiento = fechaNacimiento;
		setEdad(edad);
		this.ocupacion = ocupacion;
		this.celular = celular;
		setCorreo(correo);
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
	}

	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		if (cedula == null || cedula.isBlank()) {
			throw new IllegalArgumentException("La cedula es obligatoria");
		}
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		if (nombres == null || nombres.isBlank()) {
			throw new IllegalArgumentException("Los nombres son obligatorios");
		}
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		if (apellidos == null || apellidos.isBlank()) {
			throw new IllegalArgumentException("Los apellidos son obligatorios");
		}
		this.apellidos = apellidos;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		if (edad < 0) {
			throw new IllegalArgumentException("La edad no puede ser negativa");
		}
		this.edad = edad;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		if (correo == null || !correo.contains("@")) {
			throw new IllegalArgumentException("El correo no tiene un formato valido");
		}
		this.correo = correo;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}



}
