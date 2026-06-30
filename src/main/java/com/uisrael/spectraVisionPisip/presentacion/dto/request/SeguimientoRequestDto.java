package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class SeguimientoRequestDto {
	
	private int idSeguimiento;
	private int idCliente;
	@NotBlank
	private Date fechaEntrega;
	@NotBlank
	private Date fechaSeguimiento;
	@NotBlank
	private String observaciones;
	@NotBlank
	private String estado;

}
