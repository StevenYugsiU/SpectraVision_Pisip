package com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.HistoriaClinica;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IHistoriaClinicaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.HistoriaClinicaEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IHistoriaClinicaJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IHistoriaClinicaJpaRepositorio;



public class HistoriaClinicaRepositorioImpl implements IHistoriaClinicaRepositorio {
	
	private final IHistoriaClinicaJpaRepositorio jpaRepositorio;
	private final IHistoriaClinicaJpaMapper entityMapper;
	
	public HistoriaClinicaRepositorioImpl(IHistoriaClinicaJpaRepositorio jpaRepositorio,
			IHistoriaClinicaJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	
	@Override
	public HistoriaClinica guardar(HistoriaClinica nuevaHistoriaClinica) {
		HistoriaClinicaEntity entity = entityMapper.toEntity(nuevaHistoriaClinica);
		HistoriaClinicaEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<HistoriaClinica> buscarPorId(int idHistoriaClinica) {
		return jpaRepositorio.findById(idHistoriaClinica)
				.map(entityMapper :: toDomain);
	}

	@Override
	public List<HistoriaClinica> listarTodos() {
		return jpaRepositorio.findAll()
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

	@Override
	public void eliminar(int idHistoriaClinica) {
		jpaRepositorio.deleteById(idHistoriaClinica);
		
	}

}
