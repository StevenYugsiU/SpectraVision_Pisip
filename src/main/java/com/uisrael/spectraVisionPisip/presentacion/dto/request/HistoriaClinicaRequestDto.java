package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class HistoriaClinicaRequestDto {

	private int idHistoriaClinica;
	@NotBlank
	private int idCliente;
	@NotBlank
	private Date fechaApertura;
	@NotBlank
	private String antecedentes;
	@NotBlank
	private String observacionesGenerales;
	@NotBlank
	private Boolean estado;
}
