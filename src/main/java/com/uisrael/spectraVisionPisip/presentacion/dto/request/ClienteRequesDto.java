package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.Min;
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
	private Date fechaNacimiento;
	@Min(value = 0, message = "La edad no puede ser negativa")
	private int edad;
	private String ocupacion;
	@NotBlank
	private String celular;
	private String correo;
	private Date fechaRegistro;
	private Boolean estado;

}
