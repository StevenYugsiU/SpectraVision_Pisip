package com.uisrael.spectraVisionPisip.presentacion.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ICitaUseCase;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.CitaRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.CitaResponseDto;
import com.uisrael.spectraVisionPisip.presentacion.mapeadores.ICitaDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/spectra/cita")
public class CitaController {
	
	private final ICitaUseCase citaUseCase;
	private final ICitaDtoMapper mapper;
	
	
	public CitaController(ICitaUseCase citaUseCase, ICitaDtoMapper mapper) {
		super();
		this.citaUseCase = citaUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CitaResponseDto guardar(@Valid @RequestBody CitaRequestDto requestCita) {
		return mapper.toResponseDto(citaUseCase.guardar(mapper.toDomain(requestCita)));
	}
	
	@GetMapping
	public List<CitaResponseDto> listarTodos(){
		return citaUseCase.listarTodos().stream()
				.map(mapper ::toResponseDto).toList();
	}
	
	@DeleteMapping("/{idCita}")
	public ResponseEntity<Void> eliminar(@PathVariable int idCita){
		citaUseCase.eliminar(idCita);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{idCita}")
	public CitaResponseDto actualizar(
			@PathVariable int idCita,
			@Valid @RequestBody CitaRequestDto requestCita) {

		return mapper.toResponseDto(
				citaUseCase.actualizar(
						idCita,
						mapper.toDomain(requestCita)));
	}

	@GetMapping("/{idCita}")
	public CitaResponseDto buscarPorId(@PathVariable int idCita) {
		return mapper.toResponseDto(citaUseCase.buscarPorId(idCita));
	}

	@GetMapping("/cliente/{idCliente}")
	public List<CitaResponseDto> buscarPorIdCliente(@PathVariable int idCliente) {
		return citaUseCase.buscarPorIdCliente(idCliente).stream()
				.map(mapper::toResponseDto).toList();
	}

	@GetMapping("/fecha/{fecha}")
	public List<CitaResponseDto> buscarPorFecha(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
		return citaUseCase.buscarPorFecha(fecha).stream()
				.map(mapper::toResponseDto).toList();
	}

	@PutMapping("/{idCita}/cancelar")
	public CitaResponseDto cancelar(@PathVariable int idCita) {
		return mapper.toResponseDto(citaUseCase.cancelar(idCita));
	}

}
