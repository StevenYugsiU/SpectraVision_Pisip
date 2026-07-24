package com.uisrael.spectraVisionPisip.presentacion.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PutMapping("/{idSeguimiento}")
	public SeguimientoResponseDto actualizar(
			@PathVariable int idSeguimiento,
			@Valid @RequestBody SeguimientoRequestDto requestSeguimiento) {

		return mapper.toResponseDto(
				seguimientoUseCase.actualizar(
						idSeguimiento,
						mapper.toDomain(requestSeguimiento)));
	}

	@GetMapping("/{idSeguimiento}")
	public SeguimientoResponseDto buscarPorId(@PathVariable int idSeguimiento) {
		return mapper.toResponseDto(seguimientoUseCase.buscarPorId(idSeguimiento));
	}

	@GetMapping("/entrega/{idEntrega}")
	public List<SeguimientoResponseDto> buscarPorIdEntrega(@PathVariable int idEntrega) {
		return seguimientoUseCase.buscarPorIdEntrega(idEntrega).stream()
				.map(mapper::toResponseDto).toList();
	}

	@GetMapping("/alertas")
	public List<SeguimientoResponseDto> buscarAlertasPendientes(@RequestParam(defaultValue = "3") int dias) {
		return seguimientoUseCase.buscarAlertasPendientes(dias).stream()
				.map(mapper::toResponseDto).toList();
	}

}
