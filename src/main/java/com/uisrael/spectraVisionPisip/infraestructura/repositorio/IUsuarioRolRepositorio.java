package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioEntity;

public interface IUsuarioRolRepositorio extends JpaRepository<UsuarioEntity, Integer> {

}
