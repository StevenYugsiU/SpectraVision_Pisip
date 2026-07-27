package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.spectraVisionPisip.dominio.entidades.Usuario;

public class LoginResultado {

	private final Usuario usuario;
	private final List<String> roles;

	public LoginResultado(Usuario usuario, List<String> roles) {
		this.usuario = usuario;
		this.roles = roles;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public List<String> getRoles() {
		return roles;
	}

}
