package com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.Certificado;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ICertificadoRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.CertificadoEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.ICertificadoJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.ICertificadoJpaRepositorio;

public class CertificadoRepositorioImpl implements ICertificadoRepositorio{
	
	private final ICertificadoJpaRepositorio jpaRepositorio;
	private final ICertificadoJpaMapper entityMapper;
	
	

	public CertificadoRepositorioImpl(ICertificadoJpaRepositorio jpaRepositorio, ICertificadoJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Certificado guardar(Certificado nuevoCertificado) {
		CertificadoEntity entity = entityMapper.toEntity(nuevoCertificado);
		CertificadoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Certificado> buscarPorId(int idCertificado) {
		return jpaRepositorio.findById(idCertificado)
				.map(entityMapper :: toDomain);
	}

	@Override
	public List<Certificado> listarTodos() {
		return jpaRepositorio.findAll()
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

	@Override
	public void eliminar(int idCertificado) {
		jpaRepositorio.deleteById(idCertificado);

	}

	@Override
	public List<Certificado> buscarPorIdExamen(int idExamen) {
		return jpaRepositorio.findByFkExamenVisualEntityIdExamen(idExamen)
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

}
