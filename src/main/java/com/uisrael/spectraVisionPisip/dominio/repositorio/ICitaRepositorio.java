package com.uisrael.spectraVisionPisip.dominio.repositorio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cita;

public interface ICitaRepositorio {

	Cita guardar(Cita nuevaCita);

	Optional<Cita> buscarPorId(int idCita);

	List<Cita> listarTodos();

	void eliminar(int idCita);

	List<Cita> buscarPorIdCliente(int idCliente);

	List<Cita> buscarPorFechaYHora(LocalDate fecha, LocalTime hora);

	List<Cita> buscarPorFecha(LocalDate fecha);
}
