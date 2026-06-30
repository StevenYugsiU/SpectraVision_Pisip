package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Seguimiento;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.SeguimientoRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.SeguimientoResponseDto;

@Mapper(componentModel = "spring")
public interface ISeguimientoDtoMapper {

	Seguimiento toDomain(SeguimientoRequestDto dto);
	
	SeguimientoResponseDto toResponseDto (Seguimiento seguiminetoPojo);
}
