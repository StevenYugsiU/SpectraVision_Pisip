package com.uisrael.spectraVisionPisip.infraestructura.notificaciones;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.uisrael.spectraVisionPisip.dominio.servicios.INotificacionService;

public class TwilioNotificacionServiceImpl implements INotificacionService {

	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm");

	private final String numeroOrigen;

	public TwilioNotificacionServiceImpl(String accountSid, String authToken, String numeroOrigen) {
		Twilio.init(accountSid, authToken);
		this.numeroOrigen = numeroOrigen;
	}

	@Override
	public void enviarConfirmacionCita(String celular, String nombreCliente, LocalDate fecha, LocalTime hora) {
		String mensaje = "Hola " + nombreCliente + ", se ha programado una cita en nuestro consultorio "
				+ "SpectraVision para el día " + fecha.format(FORMATO_FECHA) + " a las " + hora.format(FORMATO_HORA)
				+ ". Responde CONFIRMAR o CANCELAR para gestionar tu cita.";

		enviarMensaje(celular, mensaje);
	}

	@Override
	public void enviarAvisoLentesListos(String celular, String nombreCliente) {
		String mensaje = "Hola " + nombreCliente + ", sus lentes ya se encuentran en nuestro consultorio. "
				+ "Puede acercarse a retirarlos desde el día de hoy.";

		enviarMensaje(celular, mensaje);
	}

	private void enviarMensaje(String celular, String mensaje) {
		String numeroDestino = formatearNumeroWhatsApp(celular);
		if (numeroDestino == null) {
			return;
		}

		Message.creator(new PhoneNumber(numeroDestino), new PhoneNumber(numeroOrigen), mensaje).create();
	}

	private String formatearNumeroWhatsApp(String celular) {
		if (celular == null || celular.isBlank()) {
			return null;
		}
		String soloDigitos = celular.replaceAll("[^0-9]", "");
		
		if (soloDigitos.startsWith("0")) {
			soloDigitos = "593" + soloDigitos.substring(1);
		} else if (!soloDigitos.startsWith("593")) {
			soloDigitos = "593" + soloDigitos;
		}
		return "whatsapp:+" + soloDigitos;
	}

}
