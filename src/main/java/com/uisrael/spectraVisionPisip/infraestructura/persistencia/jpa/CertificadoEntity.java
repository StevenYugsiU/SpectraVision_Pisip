package com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table( name = "certificado")
public class CertificadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCertificado;

	@ManyToOne
	@JoinColumn(name = "fk_examen_visual")
	private ExamenVisualEntity fkExamenVisualEntity;

	private Date fechaGeneracion;
	private String observaciones;
	
	
	
}
