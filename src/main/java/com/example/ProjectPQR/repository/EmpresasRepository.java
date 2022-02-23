package com.example.ProjectPQR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ProjectPQR.entity.Empresas;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Long>{

	@Query(value = "select e.id_empresa, e.nombre, e.activo, e.codigo, e.telefono, e.direccion, e.nit \r\n"
			+ "from \"Empresas\" e \r\n"
			+ "inner join \"Usuarios\" u on (e.codigo=u.rol_empresa)\r\n"
			+ "where u.nombreusuario = :user", nativeQuery = true)
    List<Empresas> EmpresaUser(@Param("user") String user);
	
	
	
}
