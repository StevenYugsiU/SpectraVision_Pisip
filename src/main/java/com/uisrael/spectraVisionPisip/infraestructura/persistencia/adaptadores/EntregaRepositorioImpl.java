package com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.Entrega;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IEntregaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.EntregaEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IEntregaJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IEntregaJpaRepositorio;

public class EntregaRepositorioImpl implements IEntregaRepositorio {

	private final IEntregaJpaRepositorio jpaRepositorio;
	private final IEntregaJpaMapper entityMapper;

	public EntregaRepositorioImpl(IEntregaJpaRepositorio jpaRepositorio, IEntregaJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Entrega guardar(Entrega nuevaEntrega) {
		EntregaEntity entity = entityMapper.toEntity(nuevaEntrega);
		EntregaEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Entrega> buscarPorId(int idEntrega) {
		return jpaRepositorio.findById(idEntrega)
				.map(entityMapper :: toDomain);
	}

	@Override
	public List<Entrega> listarTodos() {
		return jpaRepositorio.findAll()
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

	@Override
	public void eliminar(int idEntrega) {
		jpaRepositorio.deleteById(idEntrega);
	}

}
