package com.uisrael.spectraVisionPisip.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.UsuarioRol;

public interface IUsuarioRolRepositorio {

	UsuarioRol guardar(UsuarioRol nuevoUsuarioRol);

	Optional<UsuarioRol> buscarPorId(int idUsuarioRol);

	List<UsuarioRol> listarTodos();

	void eliminar(int idUsuarioRol);
}
