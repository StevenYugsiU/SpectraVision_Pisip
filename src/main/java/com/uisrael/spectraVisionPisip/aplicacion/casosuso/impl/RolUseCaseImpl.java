package com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IRolUseCase;
import com.uisrael.spectraVisionPisip.dominio.entidades.Rol;
import com.uisrael.spectraVisionPisip.dominio.excepciones.RecursoNoEncontradoException;
import com.uisrael.spectraVisionPisip.dominio.excepciones.ReglaNegocioException;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IRolRepositorio;

public class RolUseCaseImpl implements IRolUseCase {

	private final IRolRepositorio repositorio;


	public RolUseCaseImpl(IRolRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Rol guardar(Rol nuevoRol) {
		repositorio.buscarPorNombre(nuevoRol.getNombre()).ifPresent(existente -> {
			throw new ReglaNegocioException("Ya existe un rol registrado con el nombre " + nuevoRol.getNombre());
		});
		return repositorio.guardar(nuevoRol);
	}

	@Override
	public Rol actualizar(int idRol, Rol rolActualizado) {
		Rol existente = buscarPorId(idRol);

		repositorio.buscarPorNombre(rolActualizado.getNombre()).ifPresent(otro -> {
		    if (otro.getIdRol() != idRol) {
		        throw new ReglaNegocioException(
		                "Ya existe otro rol registrado con el nombre " + rolActualizado.getNombre());
		    }
		});
		existente.setNombre(rolActualizado.getNombre());
		existente.setDescripcion(rolActualizado.getDescripcion());

		return repositorio.guardar(existente);
	}

	@Override
	public Rol buscarPorId(int idRol) {
		return repositorio.buscarPorId(idRol).orElseThrow(() -> new RecursoNoEncontradoException("No se encontro Rol"));
	}

	@Override
	public List<Rol> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idRol) {
		repositorio.eliminar(idRol);

	}


}
