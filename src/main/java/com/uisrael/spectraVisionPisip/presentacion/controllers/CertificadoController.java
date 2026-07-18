package com.uisrael.spectraVisionPisip.presentacion.controllers;

import com.uisrael.spectraVisionPisip.dominio.repositorio.ICertificadoRepositorio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.uisrael.spectraVisionPisip.dominio.entidades.Certificado;
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

	@GetMapping("/{idCertificado}/pdf")
	public ResponseEntity<byte[]> descargarPdf(@PathVariable int idCertificado) {
		Certificado certificado = certificadoUseCase.buscarPorId(idCertificado);
		byte[] pdf = generarPdf(certificado);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_PDF);
		headers.setContentDisposition(ContentDisposition.attachment()
				.filename("certificado-" + certificado.getIdCertificado() + ".pdf")
				.build());

		return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
	}

	private byte[] generarPdf(Certificado certificado) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

		try (PDDocument documento = new PDDocument()) {
			PDPage pagina = new PDPage();
			documento.addPage(pagina);

			try (PDPageContentStream contenido = new PDPageContentStream(documento, pagina)) {
				contenido.beginText();
				contenido.setFont(PDType1Font.HELVETICA_BOLD, 16);
				contenido.newLineAtOffset(60, 750);
				contenido.showText("Certificado Visual - SpectraVision");
				contenido.endText();

				contenido.beginText();
				contenido.setFont(PDType1Font.HELVETICA, 12);
				contenido.newLineAtOffset(60, 700);
				contenido.showText("Numero de certificado: " + certificado.getIdCertificado());
				contenido.newLineAtOffset(0, -20);
				contenido.showText("Examen visual asociado: " + certificado.getIdExamen());
				contenido.newLineAtOffset(0, -20);
				contenido.showText("Fecha de generacion: " + formatoFecha.format(certificado.getFechaGeneracion()));
				contenido.newLineAtOffset(0, -20);
				contenido.showText("Observaciones: "
						+ (certificado.getObservaciones() != null ? certificado.getObservaciones() : "N/A"));
				contenido.endText();
			}

			ByteArrayOutputStream salida = new ByteArrayOutputStream();
			documento.save(salida);
			return salida.toByteArray();
		} catch (IOException e) {
			throw new UncheckedIOException("No se pudo generar el PDF del certificado", e);
		}
	}

}
