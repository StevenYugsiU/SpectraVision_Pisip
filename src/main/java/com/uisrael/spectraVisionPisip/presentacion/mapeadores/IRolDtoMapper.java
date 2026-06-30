package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Rol;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.RolRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.RolResponseDto;

@Mapper(componentModel = "spring")
public interface IRolDtoMapper {
	
	Rol toDomain(RolRequestDto dto);
	
	RolResponseDto toResponseDto (Rol rolPojo);

}
