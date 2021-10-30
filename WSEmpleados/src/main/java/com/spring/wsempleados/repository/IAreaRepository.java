package com.spring.wsempleados.repository;

import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.wsempleados.entidad.Area;

@Repository
public interface IAreaRepository extends CrudRepository<Area, Long> {
	
	@Transactional(readOnly = true)
	List<Area> findAll();

	
	
}
