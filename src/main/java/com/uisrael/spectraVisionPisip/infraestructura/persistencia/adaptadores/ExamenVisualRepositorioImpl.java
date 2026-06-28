package com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.ExamenVisual;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IExamenVisualRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ExamenVisualEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IExamenVisualJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IExamenVisualJpaRepositorio;

public class ExamenVisualRepositorioImpl implements IExamenVisualRepositorio{

	private final IExamenVisualJpaRepositorio jpaRepositorio;
	private final IExamenVisualJpaMapper entityMapper;
	
	
	public ExamenVisualRepositorioImpl(IExamenVisualJpaRepositorio jpaRepositorio,
			IExamenVisualJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public ExamenVisual guardar(ExamenVisual nuevoExamenVisual) {
		ExamenVisualEntity entity = entityMapper.toEntity(nuevoExamenVisual);
		ExamenVisualEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<ExamenVisual> buscarPorId(int idExamenVisual) {
		return jpaRepositorio.findById(idExamenVisual)
				.map(entityMapper :: toDomain);
	}

	@Override
	public List<ExamenVisual> listarTodos() {
		return jpaRepositorio.findAll()
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

	@Override
	public void eliminar(int idExamenVisual) {
		jpaRepositorio.deleteById(idExamenVisual);
		
	}

}
