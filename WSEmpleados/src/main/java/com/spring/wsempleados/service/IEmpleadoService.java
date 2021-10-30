package com.spring.wsempleados.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.spring.wsempleados.dto.EmpleadoDTO;


public interface IEmpleadoService {
	
	List<EmpleadoDTO> findAll(Pageable pageable);
	EmpleadoDTO findByDocumento(long numeroDocumento);
	List<EmpleadoDTO> findByNombre(String nombre);
	
	void save(EmpleadoDTO empleadoDTO);
	void update(EmpleadoDTO empleadoDTO);

}
