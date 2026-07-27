package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Seguimiento;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.SeguimientoEntity;

@Mapper(componentModel = "spring", uses = IEntregaJpaMapper.class)
public interface ISeguimientoJpaMapper {

	Seguimiento toDomain(SeguimientoEntity entity);

	SeguimientoEntity toEntity(Seguimiento seguimientoPojo);

}
