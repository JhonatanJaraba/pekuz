package com.example.ProjectPQR.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProjectPQR.security.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    Optional<Usuario> findByNombreUsuarioOrEmail(String nombreUsuario, String email);
    Optional<Usuario> findByTokenPassword(String tokenPassword);
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByEmail(String email);
    
}
