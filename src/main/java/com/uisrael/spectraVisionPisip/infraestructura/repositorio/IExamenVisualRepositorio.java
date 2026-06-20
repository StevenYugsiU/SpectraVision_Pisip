package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ExamenVisualEntity;

public interface IExamenVisualRepositorio extends JpaRepository<ExamenVisualEntity, Integer>{

}
