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

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.UsuarioRequestDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.UsuarioResponseDto;
import com.uisrael.spectraVisionPisip.presentacion.mapeadores.IUsuarioDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/spectra/usuario")

public class UsuarioController {
	
	private final IUsuarioUseCase usuarioUseCase;
	private final IUsuarioDtoMapper mapper;
	
	public UsuarioController(IUsuarioUseCase usuarioUseCase, IUsuarioDtoMapper mapper) {
		this.usuarioUseCase = usuarioUseCase;
		this.mapper = mapper;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponseDto guardar(@Valid @RequestBody UsuarioRequestDto requestUsuario) {
		return mapper.toResponseDto(usuarioUseCase.guardar(mapper.toDomain(requestUsuario)));
	}
	
	@GetMapping
	public List<UsuarioResponseDto> listarTodos() {
		return usuarioUseCase.listarTodos().stream()
				.map(mapper::toResponseDto).toList();
	}
	
	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<Void> elimnar(@PathVariable int idUsuario){
		usuarioUseCase.eliminar(idUsuario);
		return ResponseEntity.noContent().build();
	}
	

}
