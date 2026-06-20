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
@Table(name = "seguimiento")
public class SeguimientoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSeguimiento;
	private int idCliente;
	private Date fechaEntrega;
	private Date fechaSeguimiento;
	private String observaciones;
	private String estado;
}
