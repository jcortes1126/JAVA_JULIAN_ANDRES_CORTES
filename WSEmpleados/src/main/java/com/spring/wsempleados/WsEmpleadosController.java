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
import com.spring.wsempleados.entidad.Empleado;
import com.spring.wsempleados.respuesta.RespuestaWs;
import com.spring.wsempleados.service.IAreaService;
import com.spring.wsempleados.service.IEmpleadoService;
import com.spring.wsempleados.service.ISubareaService;
import com.spring.wsempleados.service.ITipoDocumentoService;

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
	
	
	@RequestMapping(value="/grabarEmpleado", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaWs> grabarEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
		
		RespuestaWs respuestaWs = new RespuestaWs();
		
		empleadoService.save(empleadoDTO);
		
		respuestaWs.setCodigoRespuesta("1");
		respuestaWs.setRespuesta("Empleado grabado");	
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(respuestaWs);
		
	}
	
	@RequestMapping(value="/actualizarEmpleado", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaWs> actualizarEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
		
		RespuestaWs respuestaWs = new RespuestaWs();
		
		empleadoService.save(empleadoDTO);
		
		respuestaWs.setCodigoRespuesta("1");
		respuestaWs.setRespuesta("Empleado actualizado");	
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(respuestaWs);
		
	}
	
	
	@RequestMapping(value="/listarEmpleados", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmpleadoDTO>> listarEmpleados(@RequestParam("pageIndex") int pageIndex, @RequestParam("pageSize")  int pageSize){
		
		Sort sort = Sort.by(Sort.Direction.DESC, "idEmpleado");
		Pageable pageable = PageRequest.of(pageIndex, pageSize, sort);
		
		List<EmpleadoDTO> listEmpleadoDTO = empleadoService.findAll(pageable);
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(listEmpleadoDTO);
		
	}
	
	
	@RequestMapping(value="/listarAreas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AreaDTO>> listarAreas(){
		
		List<AreaDTO> listAreaDTO = areaService.findAll();
		
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(listAreaDTO);
		
	}
	
	@RequestMapping(value="/listarSubAreas", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SubareaDTO>> listarSubAreas(@RequestParam("idArea") String idArea){
		
		List<SubareaDTO> listSubareaDTO = subareaService.findByIdArea(Long.parseLong(idArea));
		
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(listSubareaDTO);
		
	}
	
	
	@RequestMapping(value="/listarTipoDocumento", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoDocumentoDTO>> listarTipoDocumento(){
		
		List<TipoDocumentoDTO> listTipoDocumentoDTO = tipoDocumentoService.findAll();
		
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(listTipoDocumentoDTO);
		
	}
	
	@RequestMapping(value="/consultarNombres", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmpleadoDTO>> consultarNombres(@RequestParam("nombres") String nombres){
		
		List<EmpleadoDTO> listaEmpleadosDTO = empleadoService.findByNombre("%"+nombres+"%");
		
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(listaEmpleadosDTO);
		
	}
	
	@RequestMapping(value="/consultarDocumento", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpleadoDTO> consultarDocumento(@RequestParam("documento") long documento){
		
		EmpleadoDTO empleadoDTO = empleadoService.findByDocumento(documento);
		
		return ResponseEntity.ok().header("Content-Type", "application/json;charset=UTF-8").body(empleadoDTO);
		
	}
	

}
