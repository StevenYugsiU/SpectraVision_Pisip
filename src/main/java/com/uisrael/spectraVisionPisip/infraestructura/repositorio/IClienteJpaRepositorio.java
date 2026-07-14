package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ClienteEntity;

public interface IClienteJpaRepositorio extends JpaRepository<ClienteEntity, Integer> {

	Optional<ClienteEntity> findByCedula(String cedula);

	List<ClienteEntity> findByNombresContainingIgnoreCaseOrApellidosContainingIgnoreCase(String nombres, String apellidos);

}
