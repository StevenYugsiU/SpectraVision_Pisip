package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.HistoriaClinica;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.HistoriaClinicaEntity;


@Mapper(componentModel = "spring")
public interface IHistoriaClinicaJpaMapper {

	HistoriaClinica toDomain(HistoriaClinicaEntity entity);

	HistoriaClinicaEntity toEntity(HistoriaClinica historiaClinicaPojo);
}
