package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cita;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.CitaEntity;

@Mapper(componentModel = "spring")
public interface ICitaJpaMapper {
	
	Cita toDomain(CitaEntity entity);
	
	CitaEntity toEntity(Cita citaPojo);

}
