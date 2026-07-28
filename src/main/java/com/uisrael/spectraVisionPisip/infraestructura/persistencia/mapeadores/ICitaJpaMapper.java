package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cita;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.CitaEntity;

@Mapper(componentModel = "spring", uses = IClienteJpaMapper.class)
public interface ICitaJpaMapper {

    @Mapping(
        expression = "java(entity.getFkCliente().getNombres() + \" \" + entity.getFkCliente().getApellidos())",
        target = "nombreCliente"
    )
    Cita toDomain(CitaEntity entity);

    CitaEntity toEntity(Cita citaPojo);
}