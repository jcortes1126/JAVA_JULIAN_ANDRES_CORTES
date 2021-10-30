package com.spring.wsempleados.dto;

/**
 * Clase DTO para manipulación de la entidad TipoDocumento
 * @author: Julián Andrés Cortés García
 * @version: 29/10/2021
 */
public class TipoDocumentoDTO {
	
	private long idTipoDocumento;
	
	private String nombreTipoDocumento;

	/**
	 * @return the idTipoDocumento
	 */
	public long getIdTipoDocumento() {
		return idTipoDocumento;
	}

	/**
	 * @param idTipoDocumento the idTipoDocumento to set
	 */
	public void setIdTipoDocumento(long idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	/**
	 * @return the nombreTipoDocumento
	 */
	public String getNombreTipoDocumento() {
		return nombreTipoDocumento;
	}

	/**
	 * @param nombreTipoDocumento the nombreTipoDocumento to set
	 */
	public void setNombreTipoDocumento(String nombreTipoDocumento) {
		this.nombreTipoDocumento = nombreTipoDocumento;
	}

	
}
