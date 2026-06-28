package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.spectraVisionPisip.dominio.entidades.ExamenVisual;

public interface IExamenVisualUseCase {

	ExamenVisual guardar(ExamenVisual nuevoExamenVisual);

	ExamenVisual buscarPorId(int idExamenVisual);

	List<ExamenVisual> listarTodos();

	void eliminar(int idExamenVisual);

}
