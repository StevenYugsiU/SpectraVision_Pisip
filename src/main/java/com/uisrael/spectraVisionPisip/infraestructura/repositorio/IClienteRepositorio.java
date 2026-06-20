package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ClienteEntity;

public interface IClienteRepositorio extends JpaRepository<ClienteEntity, Integer> {

}
