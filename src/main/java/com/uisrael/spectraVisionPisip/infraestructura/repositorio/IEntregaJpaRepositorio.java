package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.EntregaEntity;

public interface IEntregaJpaRepositorio extends JpaRepository<EntregaEntity, Integer> {

	List<EntregaEntity> findByFkClienteEntityIdCliente(int idCliente);

}
