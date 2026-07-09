package com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa;

import java.time.LocalTime;
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
@Table(name = "cita")
public class CitaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCita;

	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	private ClienteEntity fkClienteEntity;

	private Date fecha;
	private LocalTime hora;
	private String tipoCita;
	private String estado;

}
