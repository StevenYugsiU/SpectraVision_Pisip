package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.spectraVisionPisip.dominio.entidades.Usuario;

public interface IUsuarioUseCase {

	Usuario guardar(Usuario nuevoUsuario);

	Usuario buscarPorId(int idUsuario);

	List<Usuario> listarTodos();

	void eliminar(int idUsuario);
}
