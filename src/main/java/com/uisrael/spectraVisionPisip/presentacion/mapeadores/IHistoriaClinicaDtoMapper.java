package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.HistoriaClinica;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.HistoriaClinicaRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.HistoriaClinicaResponseDto;


@Mapper(componentModel = "spring")
public interface IHistoriaClinicaDtoMapper {

	HistoriaClinica toDomain(HistoriaClinicaRequestDto dto);
	
	HistoriaClinicaResponseDto toResponseDto (HistoriaClinica historiaClinicaPojo);
	
}
