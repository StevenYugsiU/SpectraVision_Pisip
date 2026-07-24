package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.spectraVisionPisip.dominio.entidades.UsuarioRol;

public interface IUsuarioRolUseCase {

	UsuarioRol guardar(UsuarioRol nuevoUsuarioRol);

	UsuarioRol actualizar(int idUsuarioRol, UsuarioRol usuarioRolActualizado);

	UsuarioRol buscarPorId(int idUsuarioRol);

	List<UsuarioRol> listarTodos();

	void eliminar(int idUsuarioRol);
}
