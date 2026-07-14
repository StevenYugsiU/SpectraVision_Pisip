package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.SeguimientoEntity;

public interface ISeguimientoJpaRepositorio extends JpaRepository<SeguimientoEntity, Integer> {

	List<SeguimientoEntity> findByFkEntregaEntityIdEntrega(int idEntrega);

}
