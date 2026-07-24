package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ExamenVisualRequestDto {

	private int idExamen;
	private int idHistoria;
	@NotNull
	private Date fechaExamen;
	@NotBlank
	private String ultimoControlVisual;
	@NotBlank
	private String motivoConsulta;
	@NotBlank
	private String avOd;
	@NotBlank
	private	String avOi;
	@NotBlank
	private String sphOd;
	@NotBlank
	private String cylOd;
	@NotBlank
	private String ejeOd;
	@NotBlank
	private String sphOi;
	@NotBlank
	private String cylOi;
	@NotBlank
	private String ejeOi;
	@NotBlank
	private String addValor;
	@NotBlank
	private String dnp;
	@NotBlank
	private String altura;
	@NotBlank
	private String biomicroscopia;
	@NotBlank
	private String recomentaciones;
	@NotBlank
	private String proximaConsulta;
	@NotBlank
	private String diagnostico;

}
