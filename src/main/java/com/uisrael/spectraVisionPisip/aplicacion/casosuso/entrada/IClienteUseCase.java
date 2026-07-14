package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;

public interface IClienteUseCase {

	Cliente guardar(Cliente nuevoCliente);

	Cliente actualizar(int idCliente, Cliente clienteActualizado);

	Cliente buscarPorId(int idCliente);

	Cliente buscarPorCedula(String cedula);

	List<Cliente> buscarPorNombre(String nombres);

	List<Cliente> listarTodos();

	void eliminar(int idCliente);

}
