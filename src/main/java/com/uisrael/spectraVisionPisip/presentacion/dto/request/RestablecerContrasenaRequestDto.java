package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RestablecerContrasenaRequestDto {

	@NotBlank
	private String token;

	@NotBlank
	@Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
	private String nuevaContrasena;
}
