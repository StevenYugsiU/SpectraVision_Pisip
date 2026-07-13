package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClienteRequesDto {

	private int idCliente;
	@NotBlank
	private String cedula;
	@NotBlank
	private String nombres;
	@NotBlank
	private String apellidos;
	@NotNull
	private Date fechaNacimiento;
	private int edad;
	@NotBlank
	private String ocupacion;
	@NotBlank
	private String celular;
	@NotBlank
	private String correo;
	@NotNull
	private Date fechaRegistro;
	@NotNull
	private Boolean estado;

}
