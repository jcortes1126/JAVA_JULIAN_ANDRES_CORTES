package com.spring.wsempleados.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.wsempleados.entidad.Subarea;

@Repository
public interface ISubareaRepository extends CrudRepository<Subarea, Long> {

	@Transactional(readOnly = true)
	List<Subarea> findByIdArea(long idArea);
	
}
