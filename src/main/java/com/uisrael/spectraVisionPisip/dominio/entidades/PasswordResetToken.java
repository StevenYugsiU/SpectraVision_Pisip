package com.uisrael.spectraVisionPisip.dominio.entidades;

import java.time.Instant;

public class PasswordResetToken {

	private int idPasswordResetToken;
	private String token;
	private int idUsuario;
	private Instant fechaExpiracion;
	private Boolean usado;

	public int getIdPasswordResetToken() {
		return idPasswordResetToken;
	}
	public void setIdPasswordResetToken(int idPasswordResetToken) {
		this.idPasswordResetToken = idPasswordResetToken;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Instant getFechaExpiracion() {
		return fechaExpiracion;
	}
	public void setFechaExpiracion(Instant fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	public Boolean getUsado() {
		return usado;
	}
	public void setUsado(Boolean usado) {
		this.usado = usado;
	}

}
