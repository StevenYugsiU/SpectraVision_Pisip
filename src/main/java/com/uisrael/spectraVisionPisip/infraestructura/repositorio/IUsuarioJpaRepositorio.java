package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioEntity;

public interface IUsuarioJpaRepositorio extends JpaRepository<UsuarioEntity, Integer> {

	Optional<UsuarioEntity> findByUsuario(String usuario);

}
