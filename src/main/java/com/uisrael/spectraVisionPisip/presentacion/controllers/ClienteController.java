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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada.IClienteUseCase;
import com.uisrael.spectraVisionPisip.presentacion.dto.request.ClienteRequesDto;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.ClienteResponseDto;
import com.uisrael.spectraVisionPisip.presentacion.mapeadores.IClienteDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/spectra/cliente")
public class ClienteController {

	private final IClienteUseCase clienteUseCase;
	private final IClienteDtoMapper mapper;

	public ClienteController(IClienteUseCase clienteUseCase, IClienteDtoMapper mapper) {
		super();
		this.clienteUseCase = clienteUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponseDto guardar(@Valid @RequestBody ClienteRequesDto requestCliente) {
		return mapper.toResponseDto(clienteUseCase.guardar(mapper.toDomain(requestCliente)));
	}

	@PutMapping("/{idCliente}")
	public ClienteResponseDto actualizar(@PathVariable int idCliente,
			@Valid @RequestBody ClienteRequesDto requestCliente) {
		return mapper.toResponseDto(clienteUseCase.actualizar(idCliente, mapper.toDomain(requestCliente)));
	}

	@GetMapping
	public List<ClienteResponseDto> listarTodos(){
		return clienteUseCase.listarTodos().stream()
				.map(mapper ::toResponseDto).toList();
	}

	@GetMapping("/{idCliente}")
	public ClienteResponseDto buscarPorId(@PathVariable int idCliente) {
		return mapper.toResponseDto(clienteUseCase.buscarPorId(idCliente));
	}

	@GetMapping("/cedula/{cedula}")
	public ClienteResponseDto buscarPorCedula(@PathVariable String cedula) {
		return mapper.toResponseDto(clienteUseCase.buscarPorCedula(cedula));
	}

	@GetMapping("/nombre/{nombres}")
	public List<ClienteResponseDto> buscarPorNombre(@PathVariable String nombres) {
		return clienteUseCase.buscarPorNombre(nombres).stream()
				.map(mapper::toResponseDto).toList();
	}

	@DeleteMapping("/{idCliente}")
	public ResponseEntity<Void> eliminar(@PathVariable int idCliente ){
		clienteUseCase.eliminar(idCliente);
		return ResponseEntity.noContent().build();
	}
}
