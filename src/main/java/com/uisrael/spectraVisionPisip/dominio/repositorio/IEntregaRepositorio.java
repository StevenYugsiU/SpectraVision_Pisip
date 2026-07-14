package com.uisrael.spectraVisionPisip.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.Entrega;

public interface IEntregaRepositorio {

	Entrega guardar(Entrega nuevaEntrega);

	Optional<Entrega> buscarPorId(int idEntrega);

	List<Entrega> listarTodos();

	void eliminar(int idEntrega);

	List<Entrega> buscarPorIdCliente(int idCliente);

}
