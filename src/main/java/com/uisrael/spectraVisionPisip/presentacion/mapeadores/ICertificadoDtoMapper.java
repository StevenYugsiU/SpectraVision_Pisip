package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.Certificado;
import com.uisrael.spectraVisionPisip.dominio.entidades.ExamenVisual;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.CertificadoRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.CertificadoResponseDto;

@Mapper(componentModel = "spring", uses = IExamenVisualDtoMapper.class)
public interface ICertificadoDtoMapper {

	@Mapping(source = "idExamen", target = "fkExamenVisual")
	Certificado toDomain(CertificadoRequestDto dto);

	CertificadoResponseDto toResponseDto(Certificado certificadoPojo);

	default ExamenVisual map(int idExamen) {
		ExamenVisual referencia = new ExamenVisual();
		referencia.setIdExamen(idExamen);
		return referencia;
	}

}
