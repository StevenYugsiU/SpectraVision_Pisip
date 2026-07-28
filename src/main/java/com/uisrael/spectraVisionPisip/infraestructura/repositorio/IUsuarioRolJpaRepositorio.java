package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioRolEntity;

public interface IUsuarioRolJpaRepositorio extends JpaRepository<UsuarioRolEntity, Integer> {

	List<UsuarioRolEntity> findByFkUsuarioEntityIdUsuario(int idUsuario);

}
