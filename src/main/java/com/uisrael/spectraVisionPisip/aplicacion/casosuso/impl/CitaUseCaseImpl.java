package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ICitaUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Cita;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ICitaRepositorio;

public class CitaUseCaseImpl implements ICitaUseCase{

	private final ICitaRepositorio repositorio;



	public CitaUseCaseImpl(ICitaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Cita guardar(Cita nuevaCita) {

		validarDisponibilidad(nuevaCita.getFecha(), nuevaCita.getHora(), nuevaCita.getIdCita());

		return repositorio.guardar(nuevaCita);
	}

	@Override
	public Cita actualizar(int idCita, Cita citaActualizada) {

		Cita existente = buscarPorId(idCita);

		validarDisponibilidad(citaActualizada.getFecha(), citaActualizada.getHora(), idCita);

		existente.setFecha(citaActualizada.getFecha());
		existente.setHora(citaActualizada.getHora());
		existente.setTipoCita(citaActualizada.getTipoCita());
		existente.setEstado(citaActualizada.getEstado());

		return repositorio.guardar(existente);
	}

	private void validarDisponibilidad(Date fecha, LocalTime hora, int idCitaExcluir) {
		repositorio.buscarPorFechaYHora(fecha, hora).stream()
				.filter(cita -> cita.getIdCita() != idCitaExcluir)
				.filter(cita -> !"Cancelada".equalsIgnoreCase(cita.getEstado()))
				.findAny()
				.ifPresent(cita -> {
					throw new RuntimeException("El horario seleccionado ya se encuentra ocupado");
				});
	}

	@Override
	public Cita cancelar(int idCita) {
		Cita existente = buscarPorId(idCita);
		existente.setEstado("Cancelada");
		return repositorio.guardar(existente);
	}

	@Override
	public Cita buscarPorId(int idCita) {
		return repositorio.buscarPorId(idCita).orElseThrow(() -> new RuntimeException("No se encontro Cita Medica"));
	}

	@Override
	public List<Cita> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idCita) {
		repositorio.eliminar(idCita);

	}

	@Override
	public List<Cita> buscarPorIdCliente(int idCliente) {
		return repositorio.buscarPorIdCliente(idCliente);
	}

	@Override
	public List<Cita> buscarPorFecha(Date fecha) {
		return repositorio.buscarPorFecha(fecha);
	}

}
