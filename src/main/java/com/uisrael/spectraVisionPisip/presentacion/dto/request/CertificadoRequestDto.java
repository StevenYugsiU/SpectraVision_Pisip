package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class CertificadoRequestDto {
	

	private int idCertificado;
	@NotBlank
	private int idExamen;
	@NotBlank
	private Date fechaGeneracion;
	@NotBlank
	private String observaciones;
	

}
