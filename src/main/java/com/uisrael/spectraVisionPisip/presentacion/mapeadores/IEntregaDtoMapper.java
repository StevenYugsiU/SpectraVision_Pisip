package com.uisrael.spectraVisionPisip.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;
import com.uisrael.spectraVisionPisip.dominio.entidades.Entrega;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.EntregaRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.EntregaResponseDto;

@Mapper(componentModel = "spring", uses = IClienteDtoMapper.class)
public interface IEntregaDtoMapper {

	@Mapping(source = "idCliente", target = "fkCliente")
	Entrega toDomain(EntregaRequestDto dto);

	EntregaResponseDto toResponseDto(Entrega entregaPojo);

	default Cliente map(int idCliente) {
		Cliente referencia = new Cliente();
		referencia.setIdCliente(idCliente);
		return referencia;
	}
}
