package com.uisrael.spectraVisionPisip.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.HistoriaClinica;


public interface IHistoriaClinicaRepositorio {

	HistoriaClinica guardar(HistoriaClinica nuevaHistoriaClinica);

	Optional<HistoriaClinica> buscarPorId(int idHistoriaClinica);

	List<HistoriaClinica> listarTodos();

	void eliminar(int idHistoriaClinica);
	
	Optional<HistoriaClinica> buscarPorIdCliente(int idCliente);

}
