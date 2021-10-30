package com.spring.wsempleados.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.wsempleados.dto.SubareaDTO;
import com.spring.wsempleados.entidad.Subarea;
import com.spring.wsempleados.repository.ISubareaRepository;
import com.spring.wsempleados.service.ISubareaService;
import com.spring.wsempleados.utils.MHelpers;

@Service
public class SubareaServiceImpl implements ISubareaService {

	@Autowired
	private ISubareaRepository subAreaRepository;
	
	@Override
	public List<SubareaDTO> findByIdArea(long idArea) {
		
		List<SubareaDTO> listaSubareaDTO = new ArrayList<SubareaDTO>();
		
		List<Subarea> listaSubarea = subAreaRepository.findByIdArea(idArea);
 
		for (Subarea subarea: listaSubarea) {
			
			SubareaDTO subareaDTO = MHelpers.modelMapper().map(subarea, SubareaDTO.class);
			listaSubareaDTO.add(subareaDTO);
			
		}
		
		return listaSubareaDTO;
	}

}
