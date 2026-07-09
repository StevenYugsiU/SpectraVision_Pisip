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

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ISeguimientoUseCase;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.SeguimientoRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.SeguimientoResponseDto;
import com.uisrael.spectraVisionPisip.presentacion.mapeadores.ISeguimientoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/spectra/seguimiento")

public class SeguimientoController {
	
	private final ISeguimientoUseCase seguimientoUseCase;
	private final ISeguimientoDtoMapper mapper;
	
	public SeguimientoController(ISeguimientoUseCase seguimientoUseCase, ISeguimientoDtoMapper mapper) {
		this.seguimientoUseCase = seguimientoUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SeguimientoResponseDto guardar(@Valid @RequestBody SeguimientoRequestDto requestSeguimiento) {
		return mapper.toResponseDto(seguimientoUseCase.guardar(mapper.toDomain(requestSeguimiento)));
	}
	
	@GetMapping
	public List<SeguimientoResponseDto> listarTodos() {
		return seguimientoUseCase.listarTodos().stream()
				.map(mapper::toResponseDto).toList();
	}
	
	@DeleteMapping("/{idSeguimiento}")
	public ResponseEntity<Void> elimnar(@PathVariable int idSeguimiento){
		seguimientoUseCase.eliminar(idSeguimiento);
		return ResponseEntity.noContent().build();
	}

}
