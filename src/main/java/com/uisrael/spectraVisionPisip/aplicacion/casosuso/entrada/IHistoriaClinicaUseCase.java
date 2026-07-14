package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

import java.util.List;


import com.uisrael.spectraVisionPisip.dominio.entidades.HistoriaClinica;

public interface IHistoriaClinicaUseCase {

	HistoriaClinica guardar (HistoriaClinica nuevaHistoriaClinica);
	
	HistoriaClinica buscarPorId(int idHistoriaClinica);
	
	List<HistoriaClinica> listarTodos();
	
	void eliminar (int idHistoriaClinica);
	
	HistoriaClinica buscarPorIdCliente(int idCliente);
	
	HistoriaClinica actualizar(int idHistoriaClinica,HistoriaClinica historiaActualizada);
}
