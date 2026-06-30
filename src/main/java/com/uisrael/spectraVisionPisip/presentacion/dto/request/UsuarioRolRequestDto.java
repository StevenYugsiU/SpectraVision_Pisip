package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class UsuarioRolRequestDto {

	private int idUsuarioRol;
	private int idUsuario;
	@NotBlank
	private int idRol;
}
