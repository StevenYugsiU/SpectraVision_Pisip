package com.uisrael.spectraVisionPisip.infraestructura.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ICertificadoUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ICitaUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IClienteUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IExamenVisualUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IHistoriaClinicaUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.CertificadoUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.CitaUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.ClienteUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.ExamenVisualUseCaseImpl;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.HistoriaClinicaUseCaseImpl;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ICertificadoRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.ICitaRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IClienteRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IExamenVisualRepositorio;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IHistoriaClinicaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.CertificadoRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.CitaRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.ClienteRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.ExamenVisualRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.HistoriaClinicaRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.ICertificadoJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.ICitaJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IExamenVisualJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IHistoriaClinicaJpaMapper;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.ICertificadoJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.ICitaJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IClienteJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IExamenVisualJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IHistoriaClinicaJpaRepositorio;

@Configuration
public class SpectraVisionConfig {
	
	/*HistoriaClinica*/
	@Bean
	IHistoriaClinicaRepositorio historiaClinicaRepositorio(IHistoriaClinicaJpaRepositorio jpaRepositorio, IHistoriaClinicaJpaMapper mapper) {
		return new HistoriaClinicaRepositorioImpl(jpaRepositorio, mapper);
	}
	
	@Bean
	IHistoriaClinicaUseCase historiaClinicaUseCase(IHistoriaClinicaRepositorio repo) {
		return new HistoriaClinicaUseCaseImpl(repo);
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
	
	

}
