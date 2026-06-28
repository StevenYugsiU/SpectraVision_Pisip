package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cita;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.CitaRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.CitaResponseDto;

@Mapper(componentModel = "spring")
public interface ICitaDtoMapper {
	
	
	Cita toDomain(CitaRequestDto dto);
	
	CitaResponseDto toResponseDto(Cita citaPojo);

}
