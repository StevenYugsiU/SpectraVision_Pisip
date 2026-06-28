package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.time.LocalTime;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CitaRequestDto {
	
	private int idCita;
	@NotBlank
	private int idCliente;
	@NotBlank
	private Date fecha;
	@NotBlank
	private LocalTime hora;
	@NotBlank
	private String tipoCita;
	@NotBlank
	private String estado;

}
