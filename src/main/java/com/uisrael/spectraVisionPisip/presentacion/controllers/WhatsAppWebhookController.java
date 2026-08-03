package com.uisrael.spectraVisionPisip.presentacion.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ICitaUseCase;
import com.uisrael.spectraVisionPisip.dominio.excepciones.RecursoNoEncontradoException;

@RestController
@RequestMapping("/api/spectra/whatsapp")
public class WhatsAppWebhookController {

	private final ICitaUseCase citaUseCase;

	public WhatsAppWebhookController(ICitaUseCase citaUseCase) {
		this.citaUseCase = citaUseCase;
	}

	@PostMapping(value = "/webhook", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> recibirRespuesta(
			@RequestParam("From") String from,
			@RequestParam(value = "ButtonPayload", required = false) String buttonPayload,
			@RequestParam(value = "ButtonText", required = false) String buttonText,
			@RequestParam(value = "Body", required = false) String body) {

		Boolean confirmar = interpretarRespuesta(buttonPayload, buttonText, body);

		if (confirmar != null) {
			try {
				citaUseCase.responderConfirmacionWhatsApp(from, confirmar);
			} catch (RecursoNoEncontradoException ex) {
				// No hay cita pendiente para este numero: se ignora, Twilio no debe reintentar el webhook.
			}
		}

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML_VALUE)
				.body("<Response></Response>");
	}

	private Boolean interpretarRespuesta(String buttonPayload, String buttonText, String body) {
		String texto = buttonPayload != null ? buttonPayload : (buttonText != null ? buttonText : body);
		if (texto == null || texto.isBlank()) {
			return null;
		}

		String normalizado = texto.trim().toLowerCase();

		if (normalizado.startsWith("confirm") || normalizado.equals("si") || normalizado.equals("sí")
				|| normalizado.equals("1")) {
			return Boolean.TRUE;
		}
		if (normalizado.startsWith("cancel") || normalizado.equals("no") || normalizado.equals("2")) {
			return Boolean.FALSE;
		}
		return null;
	}

}
