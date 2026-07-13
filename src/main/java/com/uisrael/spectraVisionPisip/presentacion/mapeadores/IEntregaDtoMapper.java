package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Entrega;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.EntregaRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.EntregaResponseDto;

@Mapper(componentModel = "spring")
public interface IEntregaDtoMapper {

	Entrega toDomain(EntregaRequestDto dto);

	EntregaResponseDto toResponseDto(Entrega entregaPojo);
}
