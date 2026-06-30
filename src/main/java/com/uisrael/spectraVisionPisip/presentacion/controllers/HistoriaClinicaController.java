package com.uisrael.spectraVisionPisip.presentacion.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IHistoriaClinicaUseCase;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.HistoriaClinicaRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.HistoriaClinicaResponseDto;
import com.uisrael.spectraVisionPisip.presentacion.mapeadores.IHistoriaClinicaDtoMapper;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/spectra/hClinica")

public class HistoriaClinicaController {

	private final IHistoriaClinicaUseCase historiaClinicaUseCase;
	private final IHistoriaClinicaDtoMapper mapper;
	
	
	public HistoriaClinicaController(IHistoriaClinicaUseCase historiaClinicaUseCase, IHistoriaClinicaDtoMapper mapper) {
		super();
		this.historiaClinicaUseCase = historiaClinicaUseCase;
		this.mapper = mapper;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HistoriaClinicaResponseDto guardar(@Valid @RequestBody HistoriaClinicaRequestDto requestHistoriaClinica) {
		return mapper.toResponseDto(historiaClinicaUseCase.guardar(mapper.toDomain(requestHistoriaClinica)));
	}
	
	@GetMapping
	public List<HistoriaClinicaResponseDto> listarTodos() {
		return historiaClinicaUseCase.listarTodos().stream()
				.map(mapper::toResponseDto).toList();
	}
	
	@DeleteMapping("/{idHistoriaClinica}")
	public ResponseEntity<Void> elimnar(@PathVariable int idHistoriaClinica){
		historiaClinicaUseCase.eliminar(idHistoriaClinica);
		return ResponseEntity.noContent().build();
	}
	
	
}
