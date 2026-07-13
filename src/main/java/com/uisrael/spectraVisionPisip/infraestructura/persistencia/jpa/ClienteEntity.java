package com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table( name = "cliente")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	@Column(unique = true, nullable = false)
	private String cedula;
	private String nombres;
	private String apellidos;
	private Date fechaNacimiento;
	private int edad;
	private String ocupacion;
	private String celular;
	private String correo;
	private Date fechaRegistro;
	private Boolean estado;

	@OneToOne(mappedBy = "fkClienteEntity")
	private HistoriaClinicaEntity historiaClinica;

	@OneToMany(mappedBy = "fkClienteEntity")
	private List<CitaEntity> listaCita = new ArrayList<>();

	@OneToMany(mappedBy = "fkClienteEntity")
	private List<EntregaEntity> listaEntrega = new ArrayList<>();
}
