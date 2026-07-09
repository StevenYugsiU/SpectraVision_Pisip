package com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	private String nombres;
	private String apellidos;
	private String usuario;
	private String contrasena;
	private Boolean estado;

	@OneToMany(mappedBy = "fkUsuarioEntity")
	private List<UsuarioRolEntity> listaUsuarioRol = new ArrayList<>();
}
