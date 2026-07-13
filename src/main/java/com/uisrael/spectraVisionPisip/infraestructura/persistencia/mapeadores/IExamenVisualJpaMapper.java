package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.ExamenVisual;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ExamenVisualEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.HistoriaClinicaEntity;

@Mapper(componentModel = "spring")
public interface IExamenVisualJpaMapper {

	@Mapping(source = "fkHistoriaClinicaEntity.idHistoriaClinica", target = "idHistoria")
	ExamenVisual toDomain(ExamenVisualEntity entity);

	@Mapping(source = "idHistoria", target = "fkHistoriaClinicaEntity")
	ExamenVisualEntity toEntity(ExamenVisual examenVisualPojo);

	default HistoriaClinicaEntity map(int idHistoria) {
		HistoriaClinicaEntity referencia = new HistoriaClinicaEntity();
		referencia.setIdHistoriaClinica(idHistoria);
		return referencia;
	}

}
