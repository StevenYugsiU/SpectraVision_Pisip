package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cita;
import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.CitaRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.CitaResponseDto;

@Mapper(componentModel = "spring", uses = IClienteDtoMapper.class)
public interface ICitaDtoMapper {

	@Mapping(source = "idCliente", target = "fkCliente")
	@Mapping(target = "nombreCliente", ignore = true)
	Cita toDomain(CitaRequestDto dto);

	CitaResponseDto toResponseDto(Cita citaPojo);

	default Cliente map(int idCliente) {
		Cliente referencia = new Cliente();
		referencia.setIdCliente(idCliente);
		return referencia;
	}

}
