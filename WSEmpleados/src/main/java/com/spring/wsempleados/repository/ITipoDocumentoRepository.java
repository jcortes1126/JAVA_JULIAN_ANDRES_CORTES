package com.spring.wsempleados.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.wsempleados.entidad.TipoDocumento;

@Repository
public interface ITipoDocumentoRepository extends CrudRepository<TipoDocumento, Long> {

	@Transactional(readOnly = true)
	List<TipoDocumento> findAll();
}
