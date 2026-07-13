package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.Entrega;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ClienteEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.EntregaEntity;

@Mapper(componentModel = "spring")
public interface IEntregaJpaMapper {

	@Mapping(source = "fkClienteEntity.idCliente", target = "idCliente")
	Entrega toDomain(EntregaEntity entity);

	@Mapping(source = "idCliente", target = "fkClienteEntity")
	EntregaEntity toEntity(Entrega entregaPojo);

	default ClienteEntity map(int idCliente) {
		ClienteEntity referencia = new ClienteEntity();
		referencia.setIdCliente(idCliente);
		return referencia;
	}
}
