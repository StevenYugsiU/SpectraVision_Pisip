package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.spectraVisionPisip.dominio.entidades.Certificado;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.CertificadoEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ExamenVisualEntity;

@Mapper(componentModel = "spring")
public interface ICertificadoJpaMapper {

	@Mapping(source = "fkExamenVisualEntity.idExamen", target = "idExamen")
	Certificado toDomain(CertificadoEntity entity);

	@Mapping(source = "idExamen", target = "fkExamenVisualEntity")
	CertificadoEntity toEntity(Certificado certificadoPojo);

	default ExamenVisualEntity map(int idExamen) {
		ExamenVisualEntity referencia = new ExamenVisualEntity();
		referencia.setIdExamen(idExamen);
		return referencia;
	}
}
