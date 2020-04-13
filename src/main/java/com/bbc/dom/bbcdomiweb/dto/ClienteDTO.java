package com.bbc.dom.bbcdomiweb.dto;

public class ClienteDTO {

	private String token;
	private String userID;
	private String nombre;
	private String cedulaRif;
	private String correo;
	private String ultimaConexion;
	private String nroAbank;
	private String telefono;
	private String plataformDeSesion;
	private String canalDeSesion;
	private String codigoSubaplicacion;
	private String userUuid;
	
	
	public ClienteDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedulaRif() {
		return cedulaRif;
	}

	public void setCedulaRif(String cedulaRif) {
		this.cedulaRif = cedulaRif;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUltimaConexion() {
		return ultimaConexion;
	}

	public void setUltimaConexion(String ultimaConexion) {
		this.ultimaConexion = ultimaConexion;
	}

	public String getNroAbank() {
		return nroAbank;
	}

	public void setNroAbank(String nroAbank) {
		this.nroAbank = nroAbank;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPlataformDeSesion() {
		return plataformDeSesion;
	}

	public void setPlataformDeSesion(String plataformDeSesion) {
		this.plataformDeSesion = plataformDeSesion;
	}

	public String getCanalDeSesion() {
		return canalDeSesion;
	}

	public void setCanalDeSesion(String canalDeSesion) {
		this.canalDeSesion = canalDeSesion;
	}

	public String getCodigoSubaplicacion() {
		return codigoSubaplicacion;
	}

	public void setCodigoSubaplicacion(String codigoSubaplicacion) {
		this.codigoSubaplicacion = codigoSubaplicacion;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

}
