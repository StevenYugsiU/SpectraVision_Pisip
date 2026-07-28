package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.ExamenVisual;
import com.uisrael.spectraVisionPisip.dominio.entidades.HistoriaClinica;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.ExamenVisualRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.ExamenVisualResponseDto;

@Mapper(componentModel = "spring", uses = IHistoriaClinicaDtoMapper.class)
public interface IExamenVisualDtoMapper {

	@Mapping(source = "idHistoria", target = "fkHistoriaClinica")
	ExamenVisual toDomain(ExamenVisualRequestDto dto);

	ExamenVisualResponseDto toResponseDto(ExamenVisual examenVisualPojo);

	default HistoriaClinica map(int idHistoria) {
		HistoriaClinica referencia = new HistoriaClinica();
		referencia.setIdHistoriaClinica(idHistoria);
		return referencia;
	}

}
