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
@Table(name = "examenvisual")
public class ExamenVisualEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idExamen;
	private int idHistoria;
	private Date fechaControl;
	private String ultimoControlVisual;
	private String motivoConsulta;
	private String avOd;
	private	String avOi;
	private String sphOl;
	private String cylOi;
	private String ejeOi;
	private String addValor;
	private String dnp;
	private String altura;
	private String biomicroscopia;
	private String recomentaciones;
	private String proximaConsulta;
	private String diagnostico;
	
}
