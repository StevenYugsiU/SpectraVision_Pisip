package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.spectraVisionPisip.dominio.entidades.Seguimiento;

public interface ISeguimientoUseCase {

	Seguimiento guardar(Seguimiento nuevoSeguimiento);

	Seguimiento buscarPorId(int idSeguimiento);

	List<Seguimiento> listarTodos();

	void eliminar(int idSeguimiento);

}
