package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.spectraVisionPisip.dominio.entidades.ExamenVisual;

public interface IExamenVisualUseCase {

	ExamenVisual guardar(ExamenVisual nuevoExamenVisual);
	
	ExamenVisual actualizar(int idExamenVisual,ExamenVisual examenActualizado);

	ExamenVisual buscarPorId(int idExamenVisual);

	List<ExamenVisual> listarTodos();

	void eliminar(int idExamenVisual);
	
	List<ExamenVisual> buscarPorIdHistoria(int idHistoriaClinica);

}
