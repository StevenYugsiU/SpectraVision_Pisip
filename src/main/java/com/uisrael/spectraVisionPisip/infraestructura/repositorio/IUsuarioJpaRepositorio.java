package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioEntity;

public interface IUsuarioJpaRepositorio extends JpaRepository<UsuarioEntity, Integer> {

}
