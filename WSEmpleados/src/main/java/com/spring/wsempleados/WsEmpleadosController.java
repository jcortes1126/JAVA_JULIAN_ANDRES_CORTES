package com.spring.wsempleados;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.wsempleados.dto.AreaDTO;
import com.spring.wsempleados.dto.EmpleadoDTO;
import com.spring.wsempleados.dto.SubareaDTO;
import com.spring.wsempleados.dto.TipoDocumentoDTO;
import com.spring.wsempleados.respuesta.RespuestaWs;
import com.spring.wsempleados.service.IAreaService;
import com.spring.wsempleados.service.IEmpleadoService;
import com.spring.wsempleados.service.ISubareaService;
import com.spring.wsempleados.service.ITipoDocumentoService;

/**
 * Esta clase es responsable de controlar todas las solicitud del API REST entrante, preparar un modelo y devolver la vista que se muestra como respuesta
 * @author: Julián Andrés Cortés García
 * @version: 29/10/2021
 */

@CrossOrigin("*")
@RestController
@RequestMapping("WsEmpleados")
public class WsEmpleadosController {
	
	@Autowired
	private IAreaService areaService;
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private ISubareaService subareaService;
	
	@Autowired
	private ITipoDocumentoService tipoDocumentoService;
	
	/**
     * Método grabarEmpleado, encargado de enviar al Servicio los datos del empleado para el registro del empleado en la tabla Empleado 
     * @param EmpleadoDTO
     * @return RespuestaWs
     */
	@RequestMapping(value="/grabarEmpleado", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaWs> grabarEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
		
		RespuestaWs respuestaWs = new RespuestaWs();
		
		empleadoService.save(empleadoDTO);
		
		respuestaWs.setCodigoRespuesta("1");
		respuestaWs.setRespuesta("Empleado grabado");	
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(respuestaWs);
		
	}
	
	/**
     * Método actualizarEmpleado, encargado de enviar al Servicio los datos del empleado para actualizar el registro del empleado en la tabla Empleado 
     * @param EmpleadoDTO
     * @return RespuestaWs
     */
	@RequestMapping(value="/actualizarEmpleado", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaWs> actualizarEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
		
		RespuestaWs respuestaWs = new RespuestaWs();
		
		empleadoService.update(empleadoDTO);
		
		respuestaWs.setCodigoRespuesta("1");
		respuestaWs.setRespuesta("Empleado actualizado");	
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(respuestaWs);
		
	}
	
	/**
     * Método listarEmpleados, encargado de enviar al Servicio los parametros del tamaño de la paginación con la que se requiere obtener una lista de empleados de la tabla Empleados 
     * @param int que identifica la posición de la pagina que se quiere consultar.
     * @param int que identifica la cantidad de registros que serán devueltos por la consulta
     * @return List Lista de empleados
     */
	@RequestMapping(value="/listarEmpleados", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmpleadoDTO>> listarEmpleados(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize")  int pageSize){
		
		Sort sort = Sort.by(Sort.Direction.DESC, "idEmpleado");
		Pageable pageable = PageRequest.of(pageIndex, pageSize, sort);
		
		List<EmpleadoDTO> listEmpleadoDTO = empleadoService.findAll(pageable);
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(listEmpleadoDTO);
		
	}
	
	/**
     * Método listarAreas, encargado de enviar al Servicio la solicitud para devolver todas las areas que se encuentran parametrizadas en la tabla Area 
     * @return List lista de areas
     */
	@RequestMapping(value="/listarAreas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AreaDTO>> listarAreas(){
		
		List<AreaDTO> listAreaDTO = areaService.findAll();
				
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(listAreaDTO);
		
	}
	
	/**
     * Método listarSubAreas, encargado de enviar al Servicio la solicitud para devolver las subareas que pertenecen a una area determinada de acuerdo con el parametro de entrada
     * @param String codigo de la Area 
     * @return List lista de subareas
     */
	@RequestMapping(value="/listarSubAreas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubareaDTO>> listarSubAreas(@RequestParam("idArea") String idArea){
		
		List<SubareaDTO> listSubareaDTO = subareaService.findByIdArea(Long.parseLong(idArea));
			
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(listSubareaDTO);
		
	}
	
	/**
     * Método listarTipoDocumento, encargado de enviar al Servicio la solicitud para devolver todos los tipos de documentos definidos en la tabla TipoDocumento
     * @return List lista de tipos de documento
     */
	@RequestMapping(value="/listarTipoDocumento", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoDocumentoDTO>> listarTipoDocumento(){
		
		List<TipoDocumentoDTO> listTipoDocumentoDTO = tipoDocumentoService.findAll();
		
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(listTipoDocumentoDTO);
		
	}
	
	/**
     * Método consultarNombres, encargado de enviar al Servicio la solicitud para consultar por el nombre los empleados registrados en la tabla Empleado y devolver una lista de conincidencias  por el campo nombres
     * @param String con el valor del filtro de nombres
     * @return List lista de empleados
     */
	@RequestMapping(value="/consultarNombres", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmpleadoDTO>> consultarNombres(@RequestParam("nombres") String nombres){
		
		List<EmpleadoDTO> listaEmpleadosDTO = empleadoService.findByNombre("%"+nombres+"%");
				
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(listaEmpleadosDTO);
		
	}
	
	/**
     * Método consultarDocumento, encargado de enviar al Servicio la solicitud para consultar por el numero de documento, los empleados registrados en la tabla Empleado y devolver una lista de conincidencias  por el campo documento
     * @param String con el valor del filtro de documento
     * @return EmpleadoDTO empleado que concuerda con la busqueda
     */
	@RequestMapping(value="/consultarDocumento", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpleadoDTO> consultarDocumento(@RequestParam("documento") long documento){
		
		EmpleadoDTO empleadoDTO = empleadoService.findByDocumento(documento);
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(empleadoDTO);
		
	}
	

}
