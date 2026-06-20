package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.HistoriaClinicaEntity;

public interface IHistoriaClinicaRepositorio extends JpaRepository<HistoriaClinicaEntity, Integer> {

}
