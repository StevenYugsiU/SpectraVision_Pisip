package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.Entrega;
import com.uisrael.spectraVisionPisip.dominio.entidades.Seguimiento;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.SeguimientoRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.SeguimientoResponseDto;

@Mapper(componentModel = "spring", uses = IEntregaDtoMapper.class)
public interface ISeguimientoDtoMapper {

	@Mapping(source = "idEntrega", target = "fkEntrega")
	Seguimiento toDomain(SeguimientoRequestDto dto);

	SeguimientoResponseDto toResponseDto (Seguimiento seguiminetoPojo);

	default Entrega map(int idEntrega) {
		Entrega referencia = new Entrega();
		referencia.setIdEntrega(idEntrega);
		return referencia;
	}
}
