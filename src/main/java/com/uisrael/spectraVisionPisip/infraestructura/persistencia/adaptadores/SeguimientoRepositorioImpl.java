package com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.Seguimiento;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ISeguimientoRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.SeguimientoEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.ISeguimientoJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.ISeguimientoJpaRepositorio;

public class SeguimientoRepositorioImpl implements ISeguimientoRepositorio{
	
	private final ISeguimientoJpaRepositorio jpaRepositorio;
	private final ISeguimientoJpaMapper entityMapper;
	
	public SeguimientoRepositorioImpl(ISeguimientoJpaRepositorio jpaRepositorio, ISeguimientoJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Seguimiento guardar(Seguimiento nuevoSeguimiento) {
		SeguimientoEntity entity = entityMapper.toEntity(nuevoSeguimiento);
		SeguimientoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Seguimiento> buscarPorId(int idSeguimiento) {
		return jpaRepositorio.findById(idSeguimiento)
				.map(entityMapper :: toDomain);
	}

	@Override
	public List<Seguimiento> listarTodos() {
		return jpaRepositorio.findAll()
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

	@Override
	public void eliminar(int idSeguimiento) {
		jpaRepositorio.deleteById(idSeguimiento);

	}

	@Override
	public List<Seguimiento> buscarPorIdEntrega(int idEntrega) {
		return jpaRepositorio.findByFkEntregaEntityIdEntrega(idEntrega)
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

}
