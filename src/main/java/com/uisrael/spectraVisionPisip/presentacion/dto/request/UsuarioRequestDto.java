package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioRequestDto {

	private int idUsuario;
	@NotBlank
	private String nombres;
	@NotBlank
	private String apellidos;
	@NotBlank
	private String usuario;
	private String contrasena;
	@NotBlank
	@Email
	private String correo;
	@NotNull
	private Boolean estado;
}
