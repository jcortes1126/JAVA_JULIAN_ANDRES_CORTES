package com.spring.wsempleados.service;

import java.util.List;

import com.spring.wsempleados.dto.SubareaDTO;

public interface ISubareaService {
	
	List<SubareaDTO> findByIdArea(long idArea);

}
