package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.UsuarioRol;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.UsuarioRolRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.UsuarioRolResponseDto;

@Mapper(componentModel = "spring")
public interface IUsuarioRolDtoMapper {

	UsuarioRol toDomain(UsuarioRolRequestDto dto);
	
	UsuarioRolResponseDto toResponseDto (UsuarioRol usuarioRolPojo);
}
