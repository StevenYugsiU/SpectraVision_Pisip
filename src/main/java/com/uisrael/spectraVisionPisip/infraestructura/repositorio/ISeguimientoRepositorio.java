package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.SeguimientoEntity;

public interface ISeguimientoRepositorio extends JpaRepository<SeguimientoEntity, Integer> {

}
