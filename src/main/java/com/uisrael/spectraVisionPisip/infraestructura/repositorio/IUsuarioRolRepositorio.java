package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioRolEntity;

public interface IUsuarioRolRepositorio extends JpaRepository<UsuarioRolEntity, Integer> {

}
