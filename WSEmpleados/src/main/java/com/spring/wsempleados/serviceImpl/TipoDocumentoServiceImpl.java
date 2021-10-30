package com.spring.wsempleados.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.wsempleados.dto.TipoDocumentoDTO;
import com.spring.wsempleados.entidad.TipoDocumento;
import com.spring.wsempleados.repository.ITipoDocumentoRepository;
import com.spring.wsempleados.service.ITipoDocumentoService;
import com.spring.wsempleados.utils.MHelpers;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {

	@Autowired
	private ITipoDocumentoRepository tipoDocumentoRepository;
	
	@Override
	public List<TipoDocumentoDTO> findAll() {
		List<TipoDocumentoDTO> listaTipoDocumentoDTO = new ArrayList<TipoDocumentoDTO>();
		
		List<TipoDocumento> listaTipoDocumento = tipoDocumentoRepository.findAll();
 
		for (TipoDocumento tipoDocumento: listaTipoDocumento) {
			
			TipoDocumentoDTO tipoDocumentoDTO = MHelpers.modelMapper().map(tipoDocumento, TipoDocumentoDTO.class);
			listaTipoDocumentoDTO.add(tipoDocumentoDTO);
			
		}
		
		return listaTipoDocumentoDTO;
	}

}
