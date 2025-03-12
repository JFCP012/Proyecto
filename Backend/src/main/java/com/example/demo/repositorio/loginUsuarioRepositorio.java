package com.example.demo.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.loginUsuario;
import com.example.demo.modelo.usuario;

public interface loginUsuarioRepositorio extends JpaRepository<loginUsuario,Long> {

	public loginUsuario findByusuario(usuario cedula);
}
