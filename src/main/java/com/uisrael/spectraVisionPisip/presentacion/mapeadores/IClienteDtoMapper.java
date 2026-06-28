package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.ClienteRequesDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.ClienteResponseDto;

@Mapper(componentModel = "spring")
public interface IClienteDtoMapper {
	
	Cliente toDomain(ClienteRequesDto dto);
	
	ClienteResponseDto toResponseDto(Cliente clientePojo);

}
