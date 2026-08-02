package com.uisrael.spectraVisionPisip.aplicacion.casosuso.entrada;

public interface IPasswordResetUseCase {

	void solicitarReset(String usuario);

	void restablecer(String token, String nuevaContrasena);
}
