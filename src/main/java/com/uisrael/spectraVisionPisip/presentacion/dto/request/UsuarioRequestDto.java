package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;

public class UsuarioRequestDto {

	private int idUsuario;
	@NotBlank
	private String nombres;
	@NotBlank
	private String apellidos;
	@NotBlank
	private String usuario;
	@NotBlank
	private String contrasena;
	@NotBlank
	private Boolean estado;
}
