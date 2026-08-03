package com.uisrael.spectraVisionPisip.dominio.repositorio;

import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.PasswordResetToken;

public interface IPasswordResetTokenRepositorio {

	PasswordResetToken guardar(PasswordResetToken passwordResetToken);

	Optional<PasswordResetToken> buscarPorToken(String token);
}
