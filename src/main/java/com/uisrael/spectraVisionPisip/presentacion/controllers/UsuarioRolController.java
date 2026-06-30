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

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IUsuarioRolUseCase;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.UsuarioRolRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.UsuarioRolResponseDto;
import com.uisrael.spectraVisionPisip.presentacion.mapeadores.IUsuarioRolDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/spectra/usuarioRol")

public class UsuarioRolController {
	
	private final IUsuarioRolUseCase usuarioRolUseCase;
	private final IUsuarioRolDtoMapper mapper;
	
	public UsuarioRolController(IUsuarioRolUseCase usuarioRolUseCase, IUsuarioRolDtoMapper mapper) {
		this.usuarioRolUseCase = usuarioRolUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioRolResponseDto guardar(@Valid @RequestBody UsuarioRolRequestDto requestUsuarioRol) {
		return mapper.toResponseDto(usuarioRolUseCase.guardar(mapper.toDomain(requestUsuarioRol)));
	}
	
	@GetMapping
	public List<UsuarioRolResponseDto> listarTodos() {
		return usuarioRolUseCase.listarTodos().stream()
				.map(mapper::toResponseDto).toList();
	}
	
	@DeleteMapping("/{idUsuarioRol}")
	public ResponseEntity<Void> elimnar(@PathVariable int idUsuarioRol){
		usuarioRolUseCase.eliminar(idUsuarioRol);
		return ResponseEntity.noContent().build();
	}

}
