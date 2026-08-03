package com.uisrael.spectraVisionPisip.infraestructura.notificaciones;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.uisrael.spectraVisionPisip.dominio.servicios.IEmailService;

public class EmailServiceImpl implements IEmailService {

	private final JavaMailSender mailSender;

	public EmailServiceImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
		SimpleMailMessage mensaje = new SimpleMailMessage();
		mensaje.setTo(destinatario);
		mensaje.setSubject(asunto);
		mensaje.setText(cuerpo);
		mailSender.send(mensaje);
	}

}
