package com.spring.wsempleados.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * Clase TipoDocumento para representar la tabla de la Base de datos
 * @author: Julián Andrés Cortés García
 * @version: 29/10/2021
 */
@Data
@Entity
@Table(name="tipo_documento")
public class TipoDocumento {
	
	@Id
	@Column(name = "id_tipo_documento")
	private long idTipoDocumento;
	
	@Column(name = "descripcion_tipo_documento")
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
