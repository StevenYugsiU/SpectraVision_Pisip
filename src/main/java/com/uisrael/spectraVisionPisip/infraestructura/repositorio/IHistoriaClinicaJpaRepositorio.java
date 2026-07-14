package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.HistoriaClinicaEntity;

public interface IHistoriaClinicaJpaRepositorio extends JpaRepository <HistoriaClinicaEntity, Integer> {

	Optional<HistoriaClinicaEntity> findByFkClienteEntityIdCliente(int idCliente);
	
}
