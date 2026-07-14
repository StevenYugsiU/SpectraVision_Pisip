package com.uisrael.spectraVisionPisip.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.ExamenVisual;

public interface IExamenVisualRepositorio {

	ExamenVisual guardar(ExamenVisual nuevoExamenVisual);
	
	Optional<ExamenVisual> buscarPorId(int idExamenVisual);
	
	List<ExamenVisual> listarTodos();
	
	void eliminar(int idExamenVisual);
	
	List<ExamenVisual> buscarPorIdHistoria(int idHistoriaClinica);
}
