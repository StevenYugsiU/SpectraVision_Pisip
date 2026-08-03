package com.uisrael.spectraVisionPisip.presentacion.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IAuthUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IPasswordResetUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.LoginResultado;
import com.uisrael.spectraVisionPisip.dominio.excepciones.CredencialesInvalidasException;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.LoginRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.OlvideContrasenaRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.RestablecerContrasenaRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.LoginResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/spectra/auth")
public class AuthController {

	private final IAuthUseCase authUseCase;
	private final IPasswordResetUseCase passwordResetUseCase;

	public AuthController(IAuthUseCase authUseCase, IPasswordResetUseCase passwordResetUseCase) {
		this.authUseCase = authUseCase;
		this.passwordResetUseCase = passwordResetUseCase;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {

		if (request.getUsuario() == null || request.getUsuario().isBlank()
				|| request.getContrasena() == null || request.getContrasena().isBlank()) {
			return ResponseEntity.badRequest().body(new MensajeError("Usuario y contraseña son obligatorios"));
		}

		try {
			LoginResultado resultado = authUseCase.login(request.getUsuario(), request.getContrasena());

			LoginResponseDto response = new LoginResponseDto();
			response.setIdUsuario(resultado.getUsuario().getIdUsuario());
			response.setUsuario(resultado.getUsuario().getUsuario());
			response.setNombres(resultado.getUsuario().getNombres());
			response.setApellidos(resultado.getUsuario().getApellidos());
			response.setRoles(resultado.getRoles());

			return ResponseEntity.ok(response);
		} catch (CredencialesInvalidasException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MensajeError(e.getMessage()));
		}
	}

	@PostMapping("/olvide-contrasena")
	public ResponseEntity<?> olvideContrasena(@Valid @RequestBody OlvideContrasenaRequestDto request) {
		passwordResetUseCase.solicitarReset(request.getUsuario(), request.getResetPasswordUrl());
		return ResponseEntity.ok(new MensajeError(
				"Si el usuario existe y tiene un correo registrado, se envió un enlace de recuperación."));
	}

	@PostMapping("/restablecer-contrasena")
	public ResponseEntity<?> restablecerContrasena(@Valid @RequestBody RestablecerContrasenaRequestDto request) {
		passwordResetUseCase.restablecer(request.getToken(), request.getNuevaContrasena());
		return ResponseEntity.ok(new MensajeError("Contraseña actualizada correctamente."));
	}

	private record MensajeError(String message) {
	}

}
