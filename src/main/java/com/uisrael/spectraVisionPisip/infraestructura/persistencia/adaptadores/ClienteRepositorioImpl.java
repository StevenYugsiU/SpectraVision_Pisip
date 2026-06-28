package com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.spectraVisionPisip.dominio.entidades.Cliente;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IClienteRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ClienteEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IClienteJpaRepositorio;

public class ClienteRepositorioImpl implements IClienteRepositorio{

	private final IClienteJpaRepositorio jpaRepositorio;
	private final IClienteJpaMapper entityMapper;
	
	
	public ClienteRepositorioImpl(IClienteJpaRepositorio jpaRepositorio, IClienteJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Cliente guardar(Cliente nuevoCliente) {
		ClienteEntity entity = entityMapper.toEntity(nuevoCliente);
		ClienteEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Cliente> buscarPorId(int idCliente) {
		return jpaRepositorio.findById(idCliente)
				.map(entityMapper :: toDomain);
	}

	@Override
	public List<Cliente> listarTodos() {
		return jpaRepositorio.findAll()
				.stream()
				.map(entityMapper :: toDomain)
				.toList();
	}

	@Override
	public void eliminar(int idCliente) {
		jpaRepositorio.deleteById(idCliente);
		
	}

}
