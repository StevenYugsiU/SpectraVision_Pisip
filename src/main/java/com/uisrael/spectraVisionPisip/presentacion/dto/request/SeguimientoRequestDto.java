package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class SeguimientoRequestDto {

	private int idSeguimiento;
	@Min(value = 1, message = "Debe seleccionar una entrega")
	private int idEntrega;
	private Date fechaSeguimiento;
	@NotBlank
	private String observaciones;
	@NotBlank
	private String estado;

}
