package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.spectraVisionPisip.dominio.entidades.Seguimiento;

public interface ISeguimientoUseCase {

	Seguimiento guardar(Seguimiento nuevoSeguimiento);

	Seguimiento actualizar(int idSeguimiento, Seguimiento seguimientoActualizado);

	Seguimiento buscarPorId(int idSeguimiento);

	List<Seguimiento> listarTodos();

	void eliminar(int idSeguimiento);

	List<Seguimiento> buscarPorIdEntrega(int idEntrega);

	List<Seguimiento> buscarAlertasPendientes(int diasProximidad);

}
