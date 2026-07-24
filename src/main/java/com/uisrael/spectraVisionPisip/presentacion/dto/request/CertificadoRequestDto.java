package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CertificadoRequestDto {


	private int idCertificado;
	private int idExamen;
	@NotNull
	private Date fechaGeneracion;
	@NotBlank
	private String observaciones;
	

}
