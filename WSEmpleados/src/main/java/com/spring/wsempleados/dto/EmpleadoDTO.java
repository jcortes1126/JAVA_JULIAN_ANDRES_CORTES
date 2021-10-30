package com.spring.wsempleados.dto;

/**
 * Clase DTO para manipulación de la entidad Empleado
 * @author: Julián Andrés Cortés García
 * @version: 29/10/2021
 */
public class EmpleadoDTO {
	
	private long idEmpleado;
	private long idTipoDocumento;
	private long documento;
	private String nombres;
	private String apellidos;
	private long idSubArea;
	
	
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
	 * @return the tipoDocumento
	 */
	public long getIdTipoDocumento() {
		return idTipoDocumento;
	}
	/**
	 * @param tipoDocumento the tipoDocumento to set
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
	/**
	 * @return the idSubArea
	 */
	public long getIdSubArea() {
		return idSubArea;
	}
	/**
	 * @param idSubArea the idSubArea to set
	 */
	public void setIdSubArea(long idSubArea) {
		this.idSubArea = idSubArea;
	}
	
	

}
