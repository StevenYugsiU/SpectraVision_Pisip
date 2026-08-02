package com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "password_reset_token")
public class PasswordResetTokenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPasswordResetToken;

	@Column(unique = true, nullable = false)
	private String token;

	@Column(name = "fk_usuario", nullable = false)
	private int idUsuario;

	@Column(nullable = false)
	private Instant fechaExpiracion;

	@Column(nullable = false)
	private Boolean usado;

}
