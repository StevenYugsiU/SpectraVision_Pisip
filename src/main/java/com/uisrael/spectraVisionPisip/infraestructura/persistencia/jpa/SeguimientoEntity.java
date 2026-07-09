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
@Table(name = "seguimiento")
public class SeguimientoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSeguimiento;

	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	private ClienteEntity fkClienteEntity;

	private Date fechaEntrega;
	private Date fechaSeguimiento;
	private String observaciones;
	private String estado;
}
