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
@Table(name = "examenVisual")
public class ExamenVisualEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExamen;

	@ManyToOne
	@JoinColumn(name = "fk_historia_clinica")
	private HistoriaClinicaEntity fkHistoriaClinica;

	private Date fechaExamen;
	private String ultimoControlVisual;
	private String motivoConsulta;
	// Agudeza visual
	private String avOd;
	private	String avOi;
	// Ojo derecho (OD)
	private String sphOd;
	private String cylOd;
	private String ejeOd;
	// Ojo izquierdo (OI
	private String sphOi;
	private String cylOi;
	private String ejeOi;
	// Datos adicionales
	private String addValor;
	private String dnp;
	private String altura;
	// Observaciones del examen
	private String biomicroscopia;
	private String recomentaciones;
	private String proximaConsulta;
	private String diagnostico;

}
