package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data

public class UsuarioRolRequestDto {

	private int idUsuarioRol;
	@Min(value = 1, message = "Debe seleccionar un usuario")
	private int idUsuario;
	@Min(value = 1, message = "Debe seleccionar un rol")
	private int idRol;
}
