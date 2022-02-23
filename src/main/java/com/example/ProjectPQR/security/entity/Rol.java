package com.example.ProjectPQR.security.entity;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.ProjectPQR.security.enums.RolNombre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`Rol`")
public class Rol {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;
}
