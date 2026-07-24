package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

import java.util.Date;
import java.util.List;


import com.uisrael.spectraVisionPisip.dominio.entidades.Cita;

public interface ICitaUseCase {

	Cita guardar(Cita nuevaCita);

	Cita actualizar(int idCita, Cita citaActualizada);

	Cita buscarPorId(int idCita);

	List<Cita> listarTodos();

	void eliminar(int idCita);

	List<Cita> buscarPorIdCliente(int idCliente);

	List<Cita> buscarPorFecha(Date fecha);

	Cita cancelar(int idCita);

}
