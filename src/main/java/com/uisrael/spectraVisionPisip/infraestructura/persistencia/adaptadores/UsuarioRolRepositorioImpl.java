package com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.UsuarioRol;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRolRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioRolEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IUsuarioRolJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IUsuarioRolJpaRepositorio;

public class UsuarioRolRepositorioImpl implements IUsuarioRolRepositorio{
	
	private final IUsuarioRolJpaRepositorio jpaRepositorio;
	private final IUsuarioRolJpaMapper entityMapper;
	
	
	public UsuarioRolRepositorioImpl(IUsuarioRolJpaRepositorio jpaRepositorio, IUsuarioRolJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public UsuarioRol guardar(UsuarioRol nuevoUsuarioRol) {
		UsuarioRolEntity entity = entityMapper.toEntity(nuevoUsuarioRol);
		UsuarioRolEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}
	
	@Override
	public Optional<UsuarioRol> buscarPorId(int idUsuarioRol) {
		return jpaRepositorio.findById(idUsuarioRol)
				.map(entityMapper :: toDomain);
	}
	
	@Override
	public List<UsuarioRol> listarTodos() {
		return jpaRepositorio.findAll()
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}
	
	@Override
	public void eliminar(int idUsuarioRol) {
		jpaRepositorio.deleteById(idUsuarioRol);
		
	}

	

}
