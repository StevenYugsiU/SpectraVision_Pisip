package com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.Usuario;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IUsuarioJpaRepositorio;

public class UsuarioRepositorioImpl implements IUsuarioRepositorio{
	
	private final IUsuarioJpaRepositorio jpaRepositorio;
	private final IUsuarioJpaMapper entityMapper;
	
	
	public UsuarioRepositorioImpl(IUsuarioJpaRepositorio jpaRepositorio, IUsuarioJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Usuario guardar(Usuario nuevoUsuario) {
		UsuarioEntity entity = entityMapper.toEntity(nuevoUsuario);
		UsuarioEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Usuario> buscarPorId(int idUsuario) {
		return jpaRepositorio.findById(idUsuario)
				.map(entityMapper :: toDomain);
	}

	@Override
	public List<Usuario> listarTodos() {
		return jpaRepositorio.findAll()
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

	@Override
	public void eliminar(int idUsuario) {
		jpaRepositorio.deleteById(idUsuario);
		
	}

}
