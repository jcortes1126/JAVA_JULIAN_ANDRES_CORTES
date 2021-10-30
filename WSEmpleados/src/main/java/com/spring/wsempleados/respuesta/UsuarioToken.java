package com.spring.wsempleados.respuesta;

public class UsuarioToken {
	
	private String nombreUsuario;
	private String token;
	/**
	 * @return the userName
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
