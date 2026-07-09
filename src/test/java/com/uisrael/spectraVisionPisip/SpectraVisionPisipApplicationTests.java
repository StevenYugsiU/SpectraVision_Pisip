package com.uisrael.spectraVisionPisip;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.CertificadoEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.CitaEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ClienteEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.ExamenVisualEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.HistoriaClinicaEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.RolEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.SeguimientoEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioEntity;
import com.uisrael.spectraVisionPisip.infraestructura.persistencia.jpa.UsuarioRolEntity;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.ICertificadoJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.ICitaJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IClienteJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IExamenVisualJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IHistoriaClinicaJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IRolJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.ISeguimientoJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IUsuarioJpaRepositorio;
import com.uisrael.spectraVisionPisip.infraestructura.repositorio.IUsuarioRolJpaRepositorio;

@SpringBootTest
class SpectraVisionPisipApplicationTests {

	@Autowired
	IClienteJpaRepositorio repoCliente;
	
	@Autowired
	IHistoriaClinicaJpaRepositorio repoHistoriaClinica;
	
	@Autowired
	IExamenVisualJpaRepositorio repoExamenVisual;
	
	@Autowired
	ICertificadoJpaRepositorio repoCertificado;
	
	@Autowired
	ICitaJpaRepositorio repoCita;
	
	@Autowired
	ISeguimientoJpaRepositorio repoSeguimiento;
	
	@Autowired
	IUsuarioJpaRepositorio repoUsuario;
	
	@Autowired
	IRolJpaRepositorio repoRol;
	
	@Autowired
	IUsuarioRolJpaRepositorio repoUsuarioRol;
	
	
	@Test
	void contextLoads() {
	
		
		//Cliente
		ClienteEntity cliNew = new ClienteEntity();
		cliNew.setCedula("1756163034");
		cliNew.setNombres("Cristhian Israel");
		cliNew.setApellidos("Ganchala Sosa");
		cliNew.setFechaNacimiento(new Date());
		cliNew.setEdad(25);
		cliNew.setOcupacion("Programador");
		cliNew.setCelular("0995026624");
		cliNew.setCorreo("cristhian89israel@gmail.com");
		cliNew.setFechaRegistro(new Date());
		cliNew.setEstado(true);
		repoCliente.save(cliNew);
		
		
		//Historia Clinica
		HistoriaClinicaEntity historiaNew = new HistoriaClinicaEntity();
		historiaNew.setFechaApertura(new Date());
		historiaNew.setAntecedentes("Miopia");
		historiaNew.setObservacionesGenerales("Primera historia clínica registrada en el sistema.");
		historiaNew.setEstado(true);
		repoHistoriaClinica.save(historiaNew);
		
		
		//Examen Visual
		ExamenVisualEntity examenNew = new ExamenVisualEntity();
		examenNew.setFechaExamen(new Date());
		examenNew.setUltimoControlVisual("Hace 1 año");
		examenNew.setMotivoConsulta("Vision borrosa de lejos");
		examenNew.setAvOd("20/20");
		examenNew.setAvOi("20/25");
		examenNew.setSphOd("-1.00");
		examenNew.setCylOd("-0.50");
		examenNew.setEjeOd("180");
		examenNew.setSphOi("-1.25");
		examenNew.setCylOi("-0.75");
		examenNew.setEjeOi("175");
		examenNew.setAddValor("+1.00");
		examenNew.setDnp("62");
		examenNew.setAltura("18");
		examenNew.setBiomicroscopia("Sin alteraciones");
		examenNew.setRecomentaciones("Uso permanente de lentes correctivos");
		examenNew.setProximaConsulta("2027-06-20");
		examenNew.setDiagnostico("Miopia leve bilateral");
		repoExamenVisual.save(examenNew);
		
		
		//Certificado
		CertificadoEntity certificadoNew = new CertificadoEntity();
		certificadoNew.setFechaGeneracion(new Date());
		certificadoNew.setObservaciones("Paciente apto para uso de lentes correctivos.");	
		repoCertificado.save(certificadoNew);
		
		
		//Cita
		CitaEntity citaNew = new CitaEntity();
		citaNew.setFecha(new Date());
		citaNew.setTipoCita("Examen Visual");
		citaNew.setEstado("Agendada");
		repoCita.save(citaNew);
		
		
		//Seguimiento
		SeguimientoEntity segNew = new SeguimientoEntity();
		segNew.setFechaEntrega(new Date());
		segNew.setFechaSeguimiento(new Date());
		segNew.setObservaciones("Cliente indica buena adaptación a los lentes entregados.");
		segNew.setEstado("Completado");
		repoSeguimiento.save(segNew);
		
		
		//Usuario
		UsuarioEntity usuarioNew = new UsuarioEntity();
		usuarioNew.setNombres("Dayana");
		usuarioNew.setApellidos("Cueva");
		usuarioNew.setUsuario("dcueva");
		usuarioNew.setContrasena("123456");
		usuarioNew.setEstado(true);
		repoUsuario.save(usuarioNew);
		
		
		//Rol
		RolEntity rolNew = new RolEntity();
		rolNew.setNombre("Administrador");
		rolNew.setDescripcion("Acceso completo al sistema");
		repoRol.save(rolNew);
		
		
		//Usuario Rol
		UsuarioRolEntity usuRolNew = new UsuarioRolEntity();
		repoUsuarioRol.save(usuRolNew);


		System.out.println(cliNew.getNombres() + " " + cliNew.getApellidos());
		System.out.println(historiaNew.getObservacionesGenerales());
		System.out.println(examenNew.getUltimoControlVisual());
		System.out.println(certificadoNew.getIdCertificado() + " " + certificadoNew.getObservaciones());
		System.out.println(citaNew.getTipoCita());
		System.out.println(segNew.getObservaciones());
		System.out.println(usuarioNew.getNombres() + " " + usuarioNew.getApellidos());
		System.out.println(rolNew.getNombre() + " " + rolNew.getDescripcion());
		System.out.println(usuRolNew.getIdUsuarioRol());
		
		
	}
	
	

}
