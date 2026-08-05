package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ICitaUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Cita;
import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;
import com.uisrael.spectraVisionPisip.dominio.excepciones.RecursoNoEncontradoException;
import com.uisrael.spectraVisionPisip.dominio.excepciones.ReglaNegocioException;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ICitaRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IClienteRepositorio;
import com.uisrael.spectraVisionPisip.dominio.servicios.INotificacionService;

public class CitaUseCaseImpl implements ICitaUseCase{

	private static final String ESTADO_PENDIENTE = "Pendiente";

	private final ICitaRepositorio repositorio;
	private final IClienteRepositorio clienteRepositorio;
	private final INotificacionService notificacionService;



	public CitaUseCaseImpl(ICitaRepositorio repositorio, IClienteRepositorio clienteRepositorio,
			INotificacionService notificacionService) {
		this.repositorio = repositorio;
		this.clienteRepositorio = clienteRepositorio;
		this.notificacionService = notificacionService;
	}

	@Override
	public Cita guardar(Cita nuevaCita) {

		validarDisponibilidad(nuevaCita.getFecha(), nuevaCita.getHora(), nuevaCita.getIdCita());

		nuevaCita.setEstado(ESTADO_PENDIENTE);

		Cita citaGuardada = repositorio.guardar(nuevaCita);
		enviarConfirmacionWhatsApp(citaGuardada);
		return citaGuardada;
	}

	private void enviarConfirmacionWhatsApp(Cita cita) {
		try {
			Cliente cliente = clienteRepositorio.buscarPorId(cita.getFkCliente().getIdCliente())
					.orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el cliente"));
			String nombreCliente = cliente.getNombres() + " " + cliente.getApellidos();
			notificacionService.enviarConfirmacionCita(cliente.getCelular(), nombreCliente, cita.getFecha(), cita.getHora());
		} catch (Exception ex) {
			// No se bloquea el agendamiento de la cita si falla el envio del WhatsApp.
		}
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

	private void validarDisponibilidad(LocalDate fecha, LocalTime hora, int idCitaExcluir) {
		repositorio.buscarPorFechaYHora(fecha, hora).stream()
				.filter(cita -> cita.getIdCita() != idCitaExcluir)
				.filter(cita -> !"Cancelada".equalsIgnoreCase(cita.getEstado()))
				.findAny()
				.ifPresent(cita -> {
					throw new ReglaNegocioException("El horario seleccionado ya se encuentra ocupado");
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
		return repositorio.buscarPorId(idCita).orElseThrow(() -> new RecursoNoEncontradoException("No se encontro Cita Medica"));
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
	public List<Cita> buscarPorFecha(LocalDate fecha) {
		return repositorio.buscarPorFecha(fecha);
	}

	@Override
	public Cita responderConfirmacionWhatsApp(String numeroWhatsApp, boolean confirmar) {
		String telefonoNormalizado = normalizarTelefono(numeroWhatsApp);

		Cita citaEncontrada = repositorio.buscarPendientesOrdenadasPorFecha().stream()
				.filter(cita -> telefonoNormalizado.equals(normalizarTelefono(cita.getFkCliente().getCelular())))
				.findFirst()
				.orElseThrow(() -> new RecursoNoEncontradoException(
						"No se encontro una cita pendiente para el numero " + numeroWhatsApp));

		citaEncontrada.setEstado(confirmar ? "Confirmada" : "Cancelada");
		return repositorio.guardar(citaEncontrada);
	}

	private String normalizarTelefono(String telefono) {
		if (telefono == null) {
			return "";
		}
		String soloDigitos = telefono.replaceAll("[^0-9]", "");
		if (soloDigitos.length() > 9) {
			soloDigitos = soloDigitos.substring(soloDigitos.length() - 9);
		}
		return soloDigitos;
	}

}
