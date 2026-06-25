package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.CertificadoEntity;

public interface ICertificadoJpaRepositorio  extends JpaRepository<CertificadoEntity, Integer>{

}
