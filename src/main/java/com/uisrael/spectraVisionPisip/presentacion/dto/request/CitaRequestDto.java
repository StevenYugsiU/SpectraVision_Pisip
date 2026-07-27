package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CitaRequestDto {

	private int idCita;
	@Min(value = 1, message = "Debe seleccionar un cliente")
	private int idCliente;
	@NotNull
	private LocalDate fecha;
	@NotNull
	private LocalTime hora;
	@NotBlank
	private String tipoCita;
	@NotBlank
	private String estado;

}
