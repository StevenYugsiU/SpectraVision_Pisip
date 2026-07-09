package com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarioRol")
public class UsuarioRolEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuarioRol;

	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	private UsuarioEntity fkUsuarioEntity;

	@ManyToOne
	@JoinColumn(name = "fk_rol")
	private RolEntity fkRolEntity;

}
