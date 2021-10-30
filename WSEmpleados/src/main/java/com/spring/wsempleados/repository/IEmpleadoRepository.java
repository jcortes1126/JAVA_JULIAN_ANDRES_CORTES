package com.spring.wsempleados.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.wsempleados.entidad.Empleado;

@Repository
public interface IEmpleadoRepository extends CrudRepository<Empleado, Long> {
	
	@Transactional(readOnly = true)
	List<Empleado> findAll(Pageable pageable);
	
	@Transactional(readOnly = true)
	Empleado findByDocumento(long numeroDocumento);
	
	@Query(value="select p from Empleado p where nombres like :nombre")
	List<Empleado> findByNombre(@Param("nombre") String nombre);
	
	@Query(value="SELECT nextval('empleados.seq_empleado') as consecutivo",nativeQuery = true)
	long conultaSecuencia();
	
	

}
