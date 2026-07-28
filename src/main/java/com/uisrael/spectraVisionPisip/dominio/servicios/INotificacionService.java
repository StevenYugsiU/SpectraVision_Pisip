package com.uisrael.spectraVisionPisip.dominio.servicios;

import java.time.LocalDate;
import java.time.LocalTime;

public interface INotificacionService {

	void enviarConfirmacionCita(String celular, String nombreCliente, LocalDate fecha, LocalTime hora);
}
