package com.example.ProjectPQR.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectPQR.security.entity.Rol;
import com.example.ProjectPQR.security.enums.RolNombre;

public interface RolRepository extends JpaRepository<Rol, Integer>{
	 Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
