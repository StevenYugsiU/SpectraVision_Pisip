package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.RolEntity;

public interface IRolJpaRepositorio extends JpaRepository<RolEntity, Integer>{

	Optional<RolEntity> findByNombre(String nombre);

}
