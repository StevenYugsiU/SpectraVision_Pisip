package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IEntregaUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;
import com.uisrael.spectraVisionPisip.dominio.entidades.Entrega;
import com.uisrael.spectraVisionPisip.dominio.excepciones.RecursoNoEncontradoException;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IClienteRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IEntregaRepositorio;
import com.uisrael.spectraVisionPisip.dominio.servicios.INotificacionService;

public class EntregaUseCaseImpl implements IEntregaUseCase {

	private final IEntregaRepositorio repositorio;
	private final IClienteRepositorio clienteRepositorio;
	private final INotificacionService notificacionService;

	public EntregaUseCaseImpl(IEntregaRepositorio repositorio, IClienteRepositorio clienteRepositorio,
			INotificacionService notificacionService) {
		this.repositorio = repositorio;
		this.clienteRepositorio = clienteRepositorio;
		this.notificacionService = notificacionService;
	}

	@Override
	public Entrega guardar(Entrega nuevaEntrega) {

		int idCliente = nuevaEntrega.getFkCliente().getIdCliente();

		Cliente cliente = clienteRepositorio.buscarPorId(idCliente)
				.orElseThrow(() -> new RecursoNoEncontradoException(
						"No se encontro el cliente con id " + idCliente));

		Entrega entregaGuardada = repositorio.guardar(nuevaEntrega);
		enviarAvisoWhatsApp(cliente);
		return entregaGuardada;
	}

	private void enviarAvisoWhatsApp(Cliente cliente) {
		try {
			String nombreCliente = cliente.getNombres() + " " + cliente.getApellidos();
			notificacionService.enviarAvisoLentesListos(cliente.getCelular(), nombreCliente);
		} catch (Exception ex) {
			// No se bloquea el registro de la entrega si falla el envio del WhatsApp.
		}
	}

	@Override
	public Entrega actualizar(int idEntrega, Entrega entregaActualizada) {

		Entrega existente = buscarPorId(idEntrega);

		existente.setFechaEntrega(entregaActualizada.getFechaEntrega());
		existente.setObservaciones(entregaActualizada.getObservaciones());
		existente.setEstado(entregaActualizada.getEstado());

		return repositorio.guardar(existente);
	}

	@Override
	public Entrega buscarPorId(int idEntrega) {
		return repositorio.buscarPorId(idEntrega).orElseThrow(() -> new RecursoNoEncontradoException("No se encontro Entrega"));
	}

	@Override
	public List<Entrega> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idEntrega) {
		repositorio.eliminar(idEntrega);
	}

	@Override
	public List<Entrega> buscarPorIdCliente(int idCliente) {
		return repositorio.buscarPorIdCliente(idCliente);
	}

}
