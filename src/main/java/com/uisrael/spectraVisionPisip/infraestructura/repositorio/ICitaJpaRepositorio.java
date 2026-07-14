package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.CitaEntity;

public interface ICitaJpaRepositorio extends JpaRepository<CitaEntity, Integer>{

	List<CitaEntity> findByFkClienteEntityIdCliente(int idCliente);

}
