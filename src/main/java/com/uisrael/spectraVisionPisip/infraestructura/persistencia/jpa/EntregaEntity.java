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
@Table(name = "entrega")
public class EntregaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEntrega;

	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	private ClienteEntity fkClienteEntity;

	private Date fechaEntrega;
	private String observaciones;
	private String estado;

	@OneToMany(mappedBy = "fkEntregaEntity")
	private List<SeguimientoEntity> listaSeguimiento = new ArrayList<>();

}
