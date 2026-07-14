package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class HistoriaClinicaRequestDto {

	private int idHistoriaClinica;
	private int idCliente;
	@NotNull
	private Date fechaApertura;
	@NotBlank
	private String antecedentes;
	private String observacionesGenerales;
	@NotNull
	private Boolean estado;
}
