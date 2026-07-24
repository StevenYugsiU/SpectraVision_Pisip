package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ExamenVisualEntity;

public interface IExamenVisualJpaRepositorio extends JpaRepository<ExamenVisualEntity, Integer>{

	List<ExamenVisualEntity> findByFkHistoriaClinicaEntityIdHistoriaClinicaOrderByFechaExamenAsc(int idHistoriaClinica);
}
