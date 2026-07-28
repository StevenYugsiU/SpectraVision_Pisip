package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Entrega;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.EntregaEntity;

@Mapper(componentModel = "spring", uses = IClienteJpaMapper.class)
public interface IEntregaJpaMapper {

	Entrega toDomain(EntregaEntity entity);

	EntregaEntity toEntity(Entrega entregaPojo);

}
