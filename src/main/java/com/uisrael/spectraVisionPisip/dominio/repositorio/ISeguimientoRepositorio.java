package com.uisrael.spectraVisionPisip.dominio.repositorio;

import java.util.Date;
import java.util.List;
import java.util.Optional;


import com.uisrael.spectraVisionPisip.dominio.entidades.Seguimiento;

public interface ISeguimientoRepositorio {

	Seguimiento guardar(Seguimiento nuevoSeguimiento);

	Optional<Seguimiento> buscarPorId(int idSeguimiento);

	List<Seguimiento> listarTodos();

	void eliminar(int idSeguimiento);

	List<Seguimiento> buscarPorIdEntrega(int idEntrega);

	List<Seguimiento> buscarProximos(Date desde, Date hasta);
}
