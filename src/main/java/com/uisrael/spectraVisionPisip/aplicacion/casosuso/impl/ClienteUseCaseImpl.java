package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IClienteUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IClienteRepositorio;

public class ClienteUseCaseImpl implements IClienteUseCase{

	private final IClienteRepositorio repositorio;


	public ClienteUseCaseImpl(IClienteRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Cliente guardar(Cliente nuevoCliente) {
		repositorio.buscarPorCedula(nuevoCliente.getCedula()).ifPresent(existente -> {
			throw new RuntimeException("Ya existe un cliente registrado con la cedula " + nuevoCliente.getCedula());
		});
		return repositorio.guardar(nuevoCliente);
	}

	@Override
	public Cliente actualizar(int idCliente, Cliente clienteActualizado) {
		Cliente existente = buscarPorId(idCliente);

		repositorio.buscarPorCedula(clienteActualizado.getCedula()).ifPresent(otro -> {
			if (otro.getIdCliente() != idCliente) {
				throw new RuntimeException(
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
				.orElseThrow(() -> new RuntimeException("No se encontro el cliente con id " + idCliente));
	}

	@Override
	public Cliente buscarPorCedula(String cedula) {
		return repositorio.buscarPorCedula(cedula)
				.orElseThrow(() -> new RuntimeException("No se encontro el cliente con cedula " + cedula));
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
		repositorio.eliminar(idCliente);

	}

}
