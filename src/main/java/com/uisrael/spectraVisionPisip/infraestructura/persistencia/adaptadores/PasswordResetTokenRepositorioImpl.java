package com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores;

import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.PasswordResetToken;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IPasswordResetTokenRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.PasswordResetTokenEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IPasswordResetTokenJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IPasswordResetTokenJpaRepositorio;

public class PasswordResetTokenRepositorioImpl implements IPasswordResetTokenRepositorio {

	private final IPasswordResetTokenJpaRepositorio jpaRepositorio;
	private final IPasswordResetTokenJpaMapper entityMapper;

	public PasswordResetTokenRepositorioImpl(IPasswordResetTokenJpaRepositorio jpaRepositorio,
			IPasswordResetTokenJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public PasswordResetToken guardar(PasswordResetToken passwordResetToken) {
		PasswordResetTokenEntity entity = entityMapper.toEntity(passwordResetToken);
		PasswordResetTokenEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<PasswordResetToken> buscarPorToken(String token) {
		return jpaRepositorio.findByToken(token).map(entityMapper::toDomain);
	}

}
