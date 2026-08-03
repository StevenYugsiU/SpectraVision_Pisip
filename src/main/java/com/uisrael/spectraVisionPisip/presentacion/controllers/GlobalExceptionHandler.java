package com.uisrael.spectraVisionPisip.presentacion.controllers;

import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.uisrael.spectraVisionPisip.dominio.excepciones.CredencialesInvalidasException;
import com.uisrael.spectraVisionPisip.dominio.excepciones.RecursoNoEncontradoException;
import com.uisrael.spectraVisionPisip.dominio.excepciones.ReglaNegocioException;
import com.uisrael.spectraVisionPisip.presentacion.dto.response.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RecursoNoEncontradoException.class)
	public ResponseEntity<ErrorResponseDto> manejarNoEncontrado(RecursoNoEncontradoException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(ex.getMessage()));
	}

	@ExceptionHandler(ReglaNegocioException.class)
	public ResponseEntity<ErrorResponseDto> manejarReglaNegocio(ReglaNegocioException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponseDto(ex.getMessage()));
	}

	@ExceptionHandler(CredencialesInvalidasException.class)
	public ResponseEntity<ErrorResponseDto> manejarCredencialesInvalidas(CredencialesInvalidasException ex) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponseDto(ex.getMessage()));
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponseDto> manejarArgumentoInvalido(IllegalArgumentException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(ex.getMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> manejarValidacion(MethodArgumentNotValidException ex) {
		String mensaje = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> error.getField() + ": " + error.getDefaultMessage())
				.collect(Collectors.joining("; "));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(mensaje));
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponseDto> manejarIntegridad(DataIntegrityViolationException ex) {
		String sqlState = obtenerSqlState(ex);
		String mensaje;
		if ("23505".equals(sqlState)) {
			mensaje = "Ya existe un registro con esos mismos datos.";
		} else if ("23503".equals(sqlState)) {
			mensaje = "No se puede completar la operación porque este registro está siendo usado por otro.";
		} else if ("23502".equals(sqlState)) {
			mensaje = "Falta completar un dato obligatorio.";
		} else {
			mensaje = "No se pudo guardar la información. Verifique los datos ingresados.";
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponseDto(mensaje));
	}

	private String obtenerSqlState(Throwable ex) {
		Throwable causa = ex;
		while (causa != null) {
			if (causa instanceof java.sql.SQLException sqlEx) {
				return sqlEx.getSQLState();
			}
			causa = causa.getCause();
		}
		return null;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> manejarError(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorResponseDto("Ocurrió un error inesperado. Intente nuevamente."));
	}

}
