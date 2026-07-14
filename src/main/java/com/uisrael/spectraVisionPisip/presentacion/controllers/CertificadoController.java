package com.uisrael.spectraVisionPisip.presentacion.controllers;

import com.uisrael.spectraVisionPisip.dominio.repositorio.ICertificadoRepositorio;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.ICertificadoUseCase;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.CertificadoRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.CertificadoResponseDto;
import com.uisrael.spectraVisionPisip.presentacion.mapeadores.ICertificadoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/spectra/certificado")
public class CertificadoController {
	
	private final ICertificadoUseCase certificadoUseCase;
	private final ICertificadoDtoMapper mapper;
	
	public CertificadoController(ICertificadoUseCase certificadoUseCase, ICertificadoDtoMapper mapper, ICertificadoRepositorio certificadoRepositorio) {
		super();
		this.certificadoUseCase = certificadoUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CertificadoResponseDto guardado(@Valid @RequestBody CertificadoRequestDto requestCertificado) {
		return mapper.toResponseDto(certificadoUseCase.guardar(mapper.toDomain(requestCertificado)));
	}
	
	@GetMapping
	public List<CertificadoResponseDto> listarTodos() {
		return certificadoUseCase.listarTodos().stream()
				.map(mapper ::toResponseDto).toList();
	}
	
	@DeleteMapping("/{idCertificado}")
	public ResponseEntity<Void> eliminar(@PathVariable int idCertificado){
		certificadoUseCase.eliminar(idCertificado);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{idCertificado}")
	public CertificadoResponseDto actualizar(
			@PathVariable int idCertificado,
			@Valid @RequestBody CertificadoRequestDto requestCertificado) {

		return mapper.toResponseDto(
				certificadoUseCase.actualizar(
						idCertificado,
						mapper.toDomain(requestCertificado)));
	}

	@GetMapping("/{idCertificado}")
	public CertificadoResponseDto buscarPorId(@PathVariable int idCertificado) {
		return mapper.toResponseDto(certificadoUseCase.buscarPorId(idCertificado));
	}

	@GetMapping("/examen/{idExamen}")
	public List<CertificadoResponseDto> buscarPorIdExamen(@PathVariable int idExamen) {
		return certificadoUseCase.buscarPorIdExamen(idExamen).stream()
				.map(mapper::toResponseDto).toList();
	}

}
