package com.spring.wsempleados.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="subarea")
public class Subarea {
	
	@Id
	@Column(name = "id_subarea")
	private long idSubarea;
	
	@Column(name = "nombre_subarea")
	private String nombreSubarea;
	
	@Column(name = "id_area")
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
