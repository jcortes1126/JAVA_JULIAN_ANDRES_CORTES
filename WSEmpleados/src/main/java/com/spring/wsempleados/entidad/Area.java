package com.spring.wsempleados.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Clase Area para representar la tabla de la Base de datos
 * @author: Julián Andrés Cortés García
 * @version: 29/10/2021
 */
@Data
@Entity
@Table(name="area")
public class Area {
	
	@Id
	@Column(name = "id_area")
	private long idArea;
	
	@Column(name = "nombre_area")
	private String nombreArea;

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

	/**
	 * @return the nombreArea
	 */
	public String getNombreArea() {
		return nombreArea;
	}

	/**
	 * @param nombreArea the nombreArea to set
	 */
	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}
	
	

}
