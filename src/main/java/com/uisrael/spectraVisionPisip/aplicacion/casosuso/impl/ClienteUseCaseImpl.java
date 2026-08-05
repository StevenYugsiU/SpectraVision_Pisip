package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.Date;
import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IClienteUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;
import com.uisrael.spectraVisionPisip.dominio.excepciones.RecursoNoEncontradoException;
import com.uisrael.spectraVisionPisip.dominio.excepciones.ReglaNegocioException;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ICitaRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IClienteRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IEntregaRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IHistoriaClinicaRepositorio;

public class ClienteUseCaseImpl implements IClienteUseCase{

	private static final String ESTADO_CANCELADA = "Cancelada";
	private static final String ESTADO_ENTREGADO = "Entregado";

	private final IClienteRepositorio repositorio;
	private final IHistoriaClinicaRepositorio historiaClinicaRepositorio;
	private final ICitaRepositorio citaRepositorio;
	private final IEntregaRepositorio entregaRepositorio;


	public ClienteUseCaseImpl(IClienteRepositorio repositorio, IHistoriaClinicaRepositorio historiaClinicaRepositorio,
			ICitaRepositorio citaRepositorio, IEntregaRepositorio entregaRepositorio) {
		super();
		this.repositorio = repositorio;
		this.historiaClinicaRepositorio = historiaClinicaRepositorio;
		this.citaRepositorio = citaRepositorio;
		this.entregaRepositorio = entregaRepositorio;
	}

	@Override
	public Cliente guardar(Cliente nuevoCliente) {
		repositorio.buscarPorCedula(nuevoCliente.getCedula()).ifPresent(existente -> {
			throw new ReglaNegocioException("Ya existe un cliente registrado con la cedula " + nuevoCliente.getCedula());
		});

		nuevoCliente.setFechaRegistro(new Date());
		nuevoCliente.setEstado(true);

		return repositorio.guardar(nuevoCliente);
	}

	@Override
	public Cliente actualizar(int idCliente, Cliente clienteActualizado) {
		Cliente existente = buscarPorId(idCliente);

		repositorio.buscarPorCedula(clienteActualizado.getCedula()).ifPresent(otro -> {
			if (otro.getIdCliente() != idCliente) {
				throw new ReglaNegocioException(
						"Ya existe otro cliente registrado con la cedula " + clienteActualizado.getCedula());
			}
		});

		existente.setCedula(clienteActualizado.getCedula());
		existente.setNombres(clienteActualizado.getNombres());
		existente.setApellidos(clienteActualizado.getApellidos());
		existente.setFechaNacimiento(clienteActualizado.getFechaNacimiento());
		existente.setEdad(clienteActualizado.getEdad());
		existente.setOcupacion(clienteActualizado.getOcupacion());
		existente.setCelular(clienteActualizado.getCelular());
		existente.setCorreo(clienteActualizado.getCorreo());
		existente.setEstado(clienteActualizado.getEstado());

		return repositorio.guardar(existente);
	}

	@Override
	public Cliente buscarPorId(int idCliente) {
		return repositorio.buscarPorId(idCliente)
				.orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el cliente con id " + idCliente));
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		return repositorio.buscarPorCedula(cedula)
				.orElseThrow(() -> new RecursoNoEncontradoException("No se encontro el cliente con cedula " + cedula));
	}

	@Override
	public List<Cliente> buscarPorNombre(String nombres) {
		return repositorio.buscarPorNombre(nombres);
	}

	@Override
	public List<Cliente> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idCliente) {
		Cliente cliente = buscarPorId(idCliente);
		cliente.setEstado(false);
		repositorio.guardar(cliente);

		historiaClinicaRepositorio.buscarPorIdCliente(idCliente).ifPresent(historia -> {
			historia.setEstado(false);
			historiaClinicaRepositorio.guardar(historia);
		});

		citaRepositorio.buscarPorIdCliente(idCliente).stream()
				.filter(cita -> !ESTADO_CANCELADA.equalsIgnoreCase(cita.getEstado()))
				.forEach(cita -> {
					cita.setEstado(ESTADO_CANCELADA);
					citaRepositorio.guardar(cita);
				});

		entregaRepositorio.buscarPorIdCliente(idCliente).stream()
				.filter(entrega -> !ESTADO_CANCELADA.equalsIgnoreCase(entrega.getEstado())
						&& !ESTADO_ENTREGADO.equalsIgnoreCase(entrega.getEstado()))
				.forEach(entrega -> {
					entrega.setEstado(ESTADO_CANCELADA);
					entregaRepositorio.guardar(entrega);
				});
	}

}
