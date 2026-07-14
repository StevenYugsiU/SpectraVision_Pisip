package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.spectraVisionPisip.dominio.entidades.Entrega;

public interface IEntregaUseCase {

	Entrega guardar(Entrega nuevaEntrega);

	Entrega actualizar(int idEntrega, Entrega entregaActualizada);

	Entrega buscarPorId(int idEntrega);

	List<Entrega> listarTodos();

	void eliminar(int idEntrega);

	List<Entrega> buscarPorIdCliente(int idCliente);

}
