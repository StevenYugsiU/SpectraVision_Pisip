package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;
import com.uisrael.spectraVisionPisip.dominio.entidades.HistoriaClinica;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.HistoriaClinicaRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.HistoriaClinicaResponseDto;


@Mapper(componentModel = "spring", uses = IClienteDtoMapper.class)
public interface IHistoriaClinicaDtoMapper {

	@Mapping(source = "idCliente", target = "fkCliente")
	HistoriaClinica toDomain(HistoriaClinicaRequestDto dto);

	HistoriaClinicaResponseDto toResponseDto (HistoriaClinica historiaClinicaPojo);

	default Cliente map(int idCliente) {
		Cliente referencia = new Cliente();
		referencia.setIdCliente(idCliente);
		return referencia;
	}

}
