package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cita;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.CitaEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ClienteEntity;

@Mapper(componentModel = "spring")
public interface ICitaJpaMapper {

	@Mapping(source = "fkClienteEntity.idCliente", target = "idCliente")
	Cita toDomain(CitaEntity entity);

	@Mapping(source = "idCliente", target = "fkClienteEntity")
	CitaEntity toEntity(Cita citaPojo);

	default ClienteEntity map(int idCliente) {
		ClienteEntity referencia = new ClienteEntity();
		referencia.setIdCliente(idCliente);
		return referencia;
	}

}
