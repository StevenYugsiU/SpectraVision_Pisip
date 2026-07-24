package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.time.LocalTime;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CitaRequestDto {

	private int idCita;
	private int idCliente;
	@NotNull
	private Date fecha;
	@NotNull
	private LocalTime hora;
	@NotBlank
	private String tipoCita;
	@NotBlank
	private String estado;

}
