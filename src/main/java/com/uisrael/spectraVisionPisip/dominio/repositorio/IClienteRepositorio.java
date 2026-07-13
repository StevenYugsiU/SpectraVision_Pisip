package com.uisrael.spectraVisionPisip.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;

public interface IClienteRepositorio {

	Cliente guardar(Cliente nuevoCliente);

	Optional<Cliente> buscarPorId(int idCliente);

	Optional<Cliente> buscarPorCedula(String cedula);

	List<Cliente> buscarPorNombre(String nombre);

	List<Cliente> listarTodos();

	void eliminar(int idCliente);

}
