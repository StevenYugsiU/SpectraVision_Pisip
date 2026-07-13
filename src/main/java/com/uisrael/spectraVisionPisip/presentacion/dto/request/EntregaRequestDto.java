package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EntregaRequestDto {

	private int idEntrega;
	private int idCliente;
	@NotNull
	private Date fechaEntrega;
	@NotBlank
	private String observaciones;
	@NotBlank
	private String estado;

}
