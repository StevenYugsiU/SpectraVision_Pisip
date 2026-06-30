package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.UsuarioRol;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioRolEntity;

@Mapper(componentModel = "spring")
public interface IUsuarioRolJpaMapper {

		UsuarioRol toDomain(UsuarioRolEntity entity);
		
		UsuarioRolEntity toEntity(UsuarioRol usuarioRolPojo);
}
