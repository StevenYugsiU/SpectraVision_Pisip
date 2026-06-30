package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Rol;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.RolEntity;

@Mapper(componentModel = "spring")
public interface IRolJpaMapper {

	Rol toDomain(RolEntity entity);
	
	RolEntity toEntity(Rol rolPojo);
}
