package com.spring.wsempleados.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="empleado")
public class Empleado {
	
	@Id
	@Column(name = "id_empleado")
	private long idEmpleado;
	
	@Column(name = "id_tipo_documento")
	private long idTipoDocumento;
	
	@Column(name = "documento")
	private long documento;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;

	/**
	 * @return the idEmpleado
	 */
	public long getIdEmpleado() {
		return idEmpleado;
	}

	/**
	 * @param idEmpleado the idEmpleado to set
	 */
	public void setIdEmpleado(long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

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
	 * @return the documento
	 */
	public long getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(long documento) {
		this.documento = documento;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	

}
