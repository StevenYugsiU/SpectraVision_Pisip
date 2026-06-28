package com.uisrael.spectraVisionPisip.infraestructura.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IHistoriaClinicaUseCase;
import com.uisrael.spectraVisionPisip.aplicacion.casosuso.impl.HistoriaClinicaUseCaseImpl;
import com.uisrael.spectraVisionPisip.dominio.repositorio.IHistoriaClinicaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.adaptadores.HistoriaClinicaRepositorioImpl;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.mapeadores.IHistoriaClinicaJpaMapper;
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

}
