package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.EntregaEntity;

public interface IEntregaJpaRepositorio extends JpaRepository<EntregaEntity, Integer> {

}
