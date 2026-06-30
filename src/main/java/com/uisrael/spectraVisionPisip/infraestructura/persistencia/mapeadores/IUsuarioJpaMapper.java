package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Usuario;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface IUsuarioJpaMapper {

	Usuario toDomain(UsuarioEntity entity);
	UsuarioEntity toEntity(Usuario usuarioPojo);
}
