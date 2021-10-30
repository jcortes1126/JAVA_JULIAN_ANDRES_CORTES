package com.spring.wsempleados.dto;

/**
 * Clase DTO para manipulación de la entidad Subarea
 * @author: Julián Andrés Cortés García
 * @version: 29/10/2021
 */
public class SubareaDTO {
	
	private long idSubarea;
	
	private String nombreSubarea;
	
	private long idArea;

	/**
	 * @return the idSubarea
	 */
	public long getIdSubarea() {
		return idSubarea;
	}

	/**
	 * @param idSubarea the idSubarea to set
	 */
	public void setIdSubarea(long idSubarea) {
		this.idSubarea = idSubarea;
	}

	/**
	 * @return the nombreSubarea
	 */
	public String getNombreSubarea() {
		return nombreSubarea;
	}

	/**
	 * @param nombreSubarea the nombreSubarea to set
	 */
	public void setNombreSubarea(String nombreSubarea) {
		this.nombreSubarea = nombreSubarea;
	}

	/**
	 * @return the idArea
	 */
	public long getIdArea() {
		return idArea;
	}

	/**
	 * @param idArea the idArea to set
	 */
	public void setIdArea(long idArea) {
		this.idArea = idArea;
	}


}
