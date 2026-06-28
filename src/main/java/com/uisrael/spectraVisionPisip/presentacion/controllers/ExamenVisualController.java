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

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IExamenVisualUseCase;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.ExamenVisualRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.ExamenVisualResponseDto;
import com.uisrael.spectraVisionPisip.presentacion.mapeadores.IExamenVisualDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/spectra/examenVisual")

public class ExamenVisualController {
	
	private final IExamenVisualUseCase examenVisualUseCase;
	private final IExamenVisualDtoMapper mapper;
	
	public ExamenVisualController(IExamenVisualUseCase examenVisualUseCase, IExamenVisualDtoMapper mapper) {
		super();
		this.examenVisualUseCase = examenVisualUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ExamenVisualResponseDto guardar(@Valid @RequestBody ExamenVisualRequestDto requestExamenVisual) {
		return mapper.toResponseDto(examenVisualUseCase.guardar(mapper.toDomain(requestExamenVisual)));
	}
	
	@GetMapping
	public List<ExamenVisualResponseDto> listarTodos(){
		return examenVisualUseCase.listarTodos().stream()
				.map(mapper ::toResponseDto).toList();
	}
	
	@DeleteMapping("/{idExamenVisual}")
	public ResponseEntity<Void> eliminar(@PathVariable int idExamenVisual){
		examenVisualUseCase.eliminar(idExamenVisual);
		return ResponseEntity.noContent().build();
	}
	

}
