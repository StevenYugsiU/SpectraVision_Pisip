package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class CertificadoRequestDto {


	private int idCertificado;
	@Min(value = 1, message = "Debe seleccionar un examen visual")
	private int idExamen;
	private Date fechaGeneracion;
	@NotBlank
	private String observaciones;


}
