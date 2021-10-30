package com.spring.wsempleados.service;

import java.util.List;

import com.spring.wsempleados.dto.TipoDocumentoDTO;

public interface ITipoDocumentoService {
	
	List<TipoDocumentoDTO> findAll();

}
