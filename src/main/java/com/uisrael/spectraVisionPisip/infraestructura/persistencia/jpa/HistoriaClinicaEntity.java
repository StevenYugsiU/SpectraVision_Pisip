package com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "historiaClinica")

public class HistoriaClinicaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHistoriaClinica;
	private Date fechaApertura;
	private String antecedentes;
	private String observacionesGenerales;
	private Boolean estado;

	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	private ClienteEntity fkClienteEntity;

	@OneToMany(mappedBy = "fkHistoriaClinicaEntity")
	private List<ExamenVisualEntity> listaExamenVisual = new ArrayList<>();

}
