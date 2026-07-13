package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.UsuarioRol;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.RolEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioRolEntity;

@Mapper(componentModel = "spring")
public interface IUsuarioRolJpaMapper {

	@Mapping(source = "fkUsuarioEntity.idUsuario", target = "idUsuario")
	@Mapping(source = "fkRolEntity.idRol", target = "idRol")
	UsuarioRol toDomain(UsuarioRolEntity entity);

	@Mapping(source = "idUsuario", target = "fkUsuarioEntity")
	@Mapping(source = "idRol", target = "fkRolEntity")
	UsuarioRolEntity toEntity(UsuarioRol usuarioRolPojo);

	default UsuarioEntity mapUsuario(int idUsuario) {
		UsuarioEntity referencia = new UsuarioEntity();
		referencia.setIdUsuario(idUsuario);
		return referencia;
	}

	default RolEntity mapRol(int idRol) {
		RolEntity referencia = new RolEntity();
		referencia.setIdRol(idRol);
		return referencia;
	}
}
