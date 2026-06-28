package com.uisrael.spectraVisionPisip.dominio.entidades;

public class UsuarioRol {
	private int idUsuarioRol;
	private int idUsuario;
	private int idRol;
	
	public UsuarioRol(int idUsuarioRol, int idUsuario, int idRol) {
		this.idUsuarioRol = idUsuarioRol;
		this.idUsuario = idUsuario;
		this.idRol = idRol;
	}
	
	public int getIdUsuarioRol() {
		return idUsuarioRol;
	}
	public void setIdUsuarioRol(int idUsuarioRol) {
		this.idUsuarioRol = idUsuarioRol;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	
	
}
