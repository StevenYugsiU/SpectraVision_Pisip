package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.Certificado;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.CertificadoEntity;

@Mapper(componentModel = "spring")
public interface ICertificadoJpaMapper {

	Certificado toDomain(CertificadoEntity entity);
	
	CertificadoEntity toEntity(Certificado certificadoPojo);
}
