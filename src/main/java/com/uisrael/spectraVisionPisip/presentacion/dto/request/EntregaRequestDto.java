package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EntregaRequestDto {

	private int idEntrega;
	@Min(value = 1, message = "Debe seleccionar un cliente")
	private int idCliente;
	private Date fechaEntrega;
	@NotBlank
	private String observaciones;
	private String estado;

}
