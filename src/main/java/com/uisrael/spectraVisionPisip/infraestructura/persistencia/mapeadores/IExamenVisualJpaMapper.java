package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.ExamenVisual;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ExamenVisualEntity;

@Mapper(componentModel = "spring")
public interface IExamenVisualJpaMapper {
	
	ExamenVisual toDomain(ExamenVisualEntity entity);
	
	ExamenVisualEntity toEntity(ExamenVisual examenVisualPojo);

}
