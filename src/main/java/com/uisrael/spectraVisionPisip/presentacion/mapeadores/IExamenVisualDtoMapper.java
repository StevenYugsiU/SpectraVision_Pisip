package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.ExamenVisual;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.ExamenVisualRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.ExamenVisualResponseDto;

@Mapper(componentModel = "spring")
public interface IExamenVisualDtoMapper {
	
	ExamenVisual toDomain(ExamenVisualRequestDto dto);
	
	ExamenVisualResponseDto toResponseDto(ExamenVisual examenVisualPojo);

}
