package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Certificado;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.CertificadoRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.CertificadoResponseDto;

@Mapper(componentModel = "spring")
public interface ICertificadoDtoMapper {
	
	Certificado toDomain(CertificadoRequestDto dto);
	
	CertificadoResponseDto toResponseDto(Certificado certificadoPojo);

}
