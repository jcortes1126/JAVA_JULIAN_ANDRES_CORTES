package com.spring.wsempleados.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.wsempleados.dto.AreaDTO;
import com.spring.wsempleados.entidad.Area;
import com.spring.wsempleados.repository.IAreaRepository;
import com.spring.wsempleados.service.IAreaService;
import com.spring.wsempleados.utils.MHelpers;

@Service
public class AreaServiceImpl implements IAreaService {

	@Autowired
	private IAreaRepository areaRepository;
	

	public List<AreaDTO> findAll() {

		List<AreaDTO> listaAreaDTO = new ArrayList<AreaDTO>();
		
		List<Area> listaArea = areaRepository.findAll();
 
		for (Area area: listaArea) {
			
			AreaDTO areaDTO = MHelpers.modelMapper().map(area, AreaDTO.class);
			listaAreaDTO.add(areaDTO);
			
		}
		
		return listaAreaDTO;
	}

}
