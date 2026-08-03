package com.uisrael.spectraVisionPisip.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OlvideContrasenaRequestDto {

	@NotBlank
	private String usuario;

	@NotBlank
	private String resetPasswordUrl;
}
