package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Usuario;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.UsuarioRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.UsuarioResponseDto;

@Mapper(componentModel = "spring")
public interface IUsuarioDtoMapper {

	
	Usuario toDomain(UsuarioRequestDto dto);
	
	UsuarioResponseDto toResponseDto (Usuario usuarioPojo);
}
