package com.uisrael.spectraVisionPisip.dominio.servicios;

public interface IEmailService {

	void enviarCorreo(String destinatario, String asunto, String cuerpo);
}
