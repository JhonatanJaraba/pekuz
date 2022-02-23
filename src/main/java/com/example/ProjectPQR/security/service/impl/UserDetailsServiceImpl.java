package com.example.ProjectPQR.security.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ProjectPQR.entity.Empresas;
import com.example.ProjectPQR.repository.EmpresasRepository;
import com.example.ProjectPQR.security.entity.Usuario;
import com.example.ProjectPQR.security.entity.UsuarioPrincipal;
import com.example.ProjectPQR.security.enums.RolNombre;
import com.example.ProjectPQR.security.service.UsuarioService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
    UsuarioService usuarioService;
	
	@Autowired
	EmpresasRepository empresasRepository;
	
	@Override
	public UserDetails loadUserByUsername(String nombreOrEmail) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioService.getByNombreUsuarioOrEmail(nombreOrEmail).get();
		List<Empresas> empresas = null;
		List<RolNombre> roles = usuario.getRoles().stream().map(service -> service.getRolNombre()).collect(Collectors.toList());
		String rolUser = roles.toString();
		String nombreUser = usuario.getNombreUsuario();
		
		if(rolUser.contains("ROLE_SUPERADMIN")) {
		    empresas = empresasRepository.findAll();
			System.out.println(empresas);	
		} else {
			empresas = empresasRepository.EmpresaUser(nombreUser);
			System.out.println(empresas);
		}
		
		return UsuarioPrincipal.build(usuario,empresas);
	}

}
