package com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cita;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ICitaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.CitaEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.ICitaJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.ICitaJpaRepositorio;

public class CitaRepositorioImpl implements ICitaRepositorio{
	
	private final ICitaJpaRepositorio jpaRepositorio;
	private final ICitaJpaMapper entityMapper;
	
	

	public CitaRepositorioImpl(ICitaJpaRepositorio jpaRepositorio, ICitaJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Cita guardar(Cita nuevaCita) {
		CitaEntity entity = entityMapper.toEntity(nuevaCita);
		CitaEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Cita> buscarPorId(int idCita) {
		return jpaRepositorio.findById(idCita)
				.map(entityMapper :: toDomain);
	}

	@Override
	public List<Cita> listarTodos() {
		return jpaRepositorio.findAll()
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

	@Override
	public void eliminar(int idCita) {
		jpaRepositorio.deleteById(idCita);

	}

	@Override
	public List<Cita> buscarPorIdCliente(int idCliente) {
		return jpaRepositorio.findByFkClienteEntityIdCliente(idCliente)
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

	@Override
	public List<Cita> buscarPorFechaYHora(Date fecha, LocalTime hora) {
		return jpaRepositorio.findByFechaAndHora(fecha, hora)
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

	@Override
	public List<Cita> buscarPorFecha(Date fecha) {
		return jpaRepositorio.findByFechaOrderByHoraAsc(fecha)
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

}
