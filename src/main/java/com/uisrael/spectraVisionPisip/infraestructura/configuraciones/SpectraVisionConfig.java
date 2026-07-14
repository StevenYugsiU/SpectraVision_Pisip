package com.uisrael.spectraVisionPisip.infraestructura.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ICertificadoUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ICitaUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IClienteUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IEntregaUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IExamenVisualUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IHistoriaClinicaUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IRolUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ISeguimientoUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IUsuarioRolUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.CertificadoUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.CitaUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.ClienteUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.EntregaUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.ExamenVisualUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.HistoriaClinicaUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.RolUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.SeguimientoUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.UsuarioRolUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.UsuarioUseCaseImpl;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ICertificadoRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ICitaRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IClienteRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IEntregaRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IExamenVisualRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IHistoriaClinicaRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IRolRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ISeguimientoRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IUsuarioRolRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.CertificadoRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.CitaRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.ClienteRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.EntregaRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.ExamenVisualRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.HistoriaClinicaRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.RolRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.SeguimientoRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.UsuarioRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.UsuarioRolRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.ICertificadoJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.ICitaJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IEntregaJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IExamenVisualJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IHistoriaClinicaJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.ISeguimientoJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IUsuarioRolJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.ICertificadoJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.ICitaJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IClienteJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IEntregaJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IExamenVisualJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IHistoriaClinicaJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IRolJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.ISeguimientoJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IUsuarioJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IUsuarioRolJpaRepositorio;

@Configuration
public class SpectraVisionConfig {
	
	/*HistoriaClinica*/
	@Bean
	IHistoriaClinicaRepositorio historiaClinicaRepositorio(IHistoriaClinicaJpaRepositorio jpaRepositorio, IHistoriaClinicaJpaMapper mapper) {
		return new HistoriaClinicaRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IHistoriaClinicaUseCase historiaClinicaUseCase(IHistoriaClinicaRepositorio repo, IClienteRepositorio clienteRepositorio) {
		return new HistoriaClinicaUseCaseImpl(repo, clienteRepositorio);
	}
	
	/*Rol*/
	@Bean
	IRolRepositorio rolRepositorio(IRolJpaRepositorio jpaRepositorio, IRolJpaMapper mapper) {
		return new RolRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IRolUseCase rolUseCase(IRolRepositorio repo) {
		return new RolUseCaseImpl(repo);
	}
	
	
	/*Seguimiento*/
	@Bean
	ISeguimientoRepositorio seguimientoRepositorio(ISeguimientoJpaRepositorio jpaRepositorio, ISeguimientoJpaMapper mapper) {
		return new SeguimientoRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	ISeguimientoUseCase seguimientoUseCase(ISeguimientoRepositorio repo) {
		return new SeguimientoUseCaseImpl(repo);
	}
	
	/*Usuario*/
	@Bean
	IUsuarioRepositorio usuarioRepositorio(IUsuarioJpaRepositorio jpaRepositorio, IUsuarioJpaMapper mapper) {
		return new UsuarioRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IUsuarioUseCase usuarioUseCase(IUsuarioRepositorio repo) {
		return new UsuarioUseCaseImpl(repo);
	}
	
	
	/*UsuarioRol*/
	@Bean
	IUsuarioRolRepositorio usuarioRolRepositorio(IUsuarioRolJpaRepositorio jpaRepositorio, IUsuarioRolJpaMapper mapper) {
		return new UsuarioRolRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IUsuarioRolUseCase usuarioRolUseCase(IUsuarioRolRepositorio repo) {
		return new UsuarioRolUseCaseImpl(repo);
	}
	
	
	/*Certificado*/
	@Bean
	ICertificadoRepositorio certificadoRepositorio(ICertificadoJpaRepositorio jpaRepositorio,ICertificadoJpaMapper mapper) {
		return new CertificadoRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	ICertificadoUseCase certificadoUseCase(ICertificadoRepositorio repo) {
		return new CertificadoUseCaseImpl(repo);
	}
	
	
	/*Cita*/
	@Bean
	ICitaRepositorio citaRepositorio(ICitaJpaRepositorio jpaRepositorio,ICitaJpaMapper mapper) {
		return new CitaRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	ICitaUseCase citaUseCase(ICitaRepositorio repo) {
		return new CitaUseCaseImpl(repo);
	}
	
	
	/*Cliente*/
	
	@Bean
	IClienteRepositorio clienteRepositorio(IClienteJpaRepositorio jpaRepositorio,IClienteJpaMapper mapper) {
		return new ClienteRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IClienteUseCase clienteUseCase(IClienteRepositorio repo) {
		return new ClienteUseCaseImpl(repo);
	}
	
	
	/*Examen Visual*/
	@Bean
	IExamenVisualRepositorio examenVisualRepositorio(IExamenVisualJpaRepositorio jpaRepositorio,IExamenVisualJpaMapper mapper) {
		return new ExamenVisualRepositorioImpl(jpaRepositorio, mapper);
	}
	@Bean
	IExamenVisualUseCase examenVisualUseCase(IExamenVisualRepositorio repo) {
		return new ExamenVisualUseCaseImpl(repo);
	}


	/*Entrega*/
	@Bean
	IEntregaRepositorio entregaRepositorio(IEntregaJpaRepositorio jpaRepositorio, IEntregaJpaMapper mapper) {
		return new EntregaRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IEntregaUseCase entregaUseCase(IEntregaRepositorio repo) {
		return new EntregaUseCaseImpl(repo);
	}

}
