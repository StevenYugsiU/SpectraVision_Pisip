package com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table( name = "cliente")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
