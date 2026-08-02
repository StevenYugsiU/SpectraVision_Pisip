package com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.spectraVisionPisip.dominio.entidades.PasswordResetToken;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.PasswordResetTokenEntity;

@Mapper(componentModel = "spring")
public interface IPasswordResetTokenJpaMapper {

	PasswordResetToken toDomain(PasswordResetTokenEntity entity);

	PasswordResetTokenEntity toEntity(PasswordResetToken passwordResetToken);
}
