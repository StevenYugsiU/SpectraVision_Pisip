package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.PasswordResetTokenEntity;

public interface IPasswordResetTokenJpaRepositorio extends JpaRepository<PasswordResetTokenEntity, Integer> {

	Optional<PasswordResetTokenEntity> findByToken(String token);
}
