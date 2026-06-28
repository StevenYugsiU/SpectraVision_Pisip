package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
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
	@NotBlank
	private Date fechaNacimiento;
	@NotBlank
	private int edad;
	@NotBlank
	private String ocupacion;
	@NotBlank
	private String celular;
	@NotBlank
	private String correo;
	@NotBlank
	private Date fechaRegistro;
	@NotBlank
	private Boolean estado;

}
