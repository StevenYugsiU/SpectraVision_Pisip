package com.uisrael.spectraVisionPisip.dominio.repositorio;

import java.util.List;
import java.util.Optional;


import com.uisrael.spectraVisionPisip.dominio.entidades.Rol;

public interface IRolRepositorio {
	
	Rol guardar(Rol nuevoRol);

	Optional<Rol> buscarPorId(int idRol);

	List<Rol> listarTodos();

	void eliminar(int idRol);

}
