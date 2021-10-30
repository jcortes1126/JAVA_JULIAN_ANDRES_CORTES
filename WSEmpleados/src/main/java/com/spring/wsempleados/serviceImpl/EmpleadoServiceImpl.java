package com.spring.wsempleados.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.wsempleados.dto.EmpleadoDTO;
import com.spring.wsempleados.entidad.Empleado;
import com.spring.wsempleados.repository.IEmpleadoRepository;
import com.spring.wsempleados.service.IEmpleadoService;
import com.spring.wsempleados.utils.MHelpers;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepository;
	
	@Override
	public List<EmpleadoDTO> findAll(Pageable pageable) {
		List<EmpleadoDTO> listaEmpleadosDTO = new ArrayList<EmpleadoDTO>();
		List<Empleado> listaEmpleado = empleadoRepository.findAll(pageable);
		
		for(Empleado empleado: listaEmpleado) {
			EmpleadoDTO empleadoDTO = MHelpers.modelMapper().map(empleado,EmpleadoDTO.class);
			listaEmpleadosDTO.add(empleadoDTO);
		}
		
		return listaEmpleadosDTO;
	}

	@Override
	public EmpleadoDTO findByDocumento(long numeroDocumento) {
		EmpleadoDTO empleadoDTO = new EmpleadoDTO();
		Empleado empleado = empleadoRepository.findByDocumento(numeroDocumento);
		
		empleadoDTO = MHelpers.modelMapper().map(empleado,EmpleadoDTO.class);
		
		return empleadoDTO;
	}

	@Override
	public List<EmpleadoDTO> findByNombre(String nombre) {
		List<EmpleadoDTO> listaEmpleadosDTO = new ArrayList<EmpleadoDTO>();
		List<Empleado> listaEmpleado = empleadoRepository.findByNombre(nombre);
		
		for(Empleado empleado: listaEmpleado) {
			EmpleadoDTO empleadoDTO = MHelpers.modelMapper().map(empleado,EmpleadoDTO.class);
			listaEmpleadosDTO.add(empleadoDTO);
		}
		
		return listaEmpleadosDTO;
	}

	@Override
	public void save(EmpleadoDTO empleadoDTO) {
		
		Empleado empleado = MHelpers.modelMapper().map(empleadoDTO, Empleado.class);
		
		empleado.setIdEmpleado(empleadoRepository.conultaSecuencia());
		
		empleadoRepository.save(empleado);
	}

	@Override
	public void update(EmpleadoDTO empleadoDTO) {
		Empleado empleado = MHelpers.modelMapper().map(empleadoDTO, Empleado.class);
		empleadoRepository.save(empleado);		
	}

}
