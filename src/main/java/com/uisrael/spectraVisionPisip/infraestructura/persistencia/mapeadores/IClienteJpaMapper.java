package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ClienteEntity;

@Mapper(componentModel = "spring")
public interface IClienteJpaMapper {

	Cliente toDomain(ClienteEntity entity);
	
	ClienteEntity toEntity(Cliente clientePojo);
	
}
