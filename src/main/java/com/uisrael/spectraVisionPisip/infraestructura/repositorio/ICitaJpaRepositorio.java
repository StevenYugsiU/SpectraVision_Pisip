package com.uisrael.spectraVisionPisip.infraestructura.repositorio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.CitaEntity;

public interface ICitaJpaRepositorio extends JpaRepository<CitaEntity, Integer>{

	List<CitaEntity> findByFkClienteIdCliente(int idCliente);

	List<CitaEntity> findByFechaAndHora(LocalDate fecha, LocalTime hora);

	List<CitaEntity> findByFechaOrderByHoraAsc(LocalDate fecha);

	List<CitaEntity> findByEstadoOrderByFechaAscHoraAsc(String estado);

}
