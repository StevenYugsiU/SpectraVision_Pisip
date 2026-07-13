package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.Seguimiento;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.EntregaEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.SeguimientoEntity;

@Mapper(componentModel = "spring")
public interface ISeguimientoJpaMapper {

	@Mapping(source = "fkEntregaEntity.idEntrega", target = "idEntrega")
	Seguimiento toDomain(SeguimientoEntity entity);

	@Mapping(source = "idEntrega", target = "fkEntregaEntity")
	SeguimientoEntity toEntity(Seguimiento seguimientoPojo);

	default EntregaEntity map(int idEntrega) {
		EntregaEntity referencia = new EntregaEntity();
		referencia.setIdEntrega(idEntrega);
		return referencia;
	}
}
