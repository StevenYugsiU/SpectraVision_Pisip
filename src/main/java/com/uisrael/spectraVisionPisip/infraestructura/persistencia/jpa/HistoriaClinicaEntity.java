package com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "HistoriaClinica")

public class HistoriaClinicaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHistoria;
	private int idCliente;
	private Date fechaApertura;
	private String antecedentes;
	private String observacionesGenerales;
	private Boolean estado;

}
