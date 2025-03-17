package com.example.demo.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.usuario;
import com.example.demo.repositorio.usuarioRepositorio;


@RestController
@RequestMapping("/ver/usuario/")
@CrossOrigin(origins ="http://localhost:4200/")

public class usuarioControlador {

    	@Autowired
	private usuarioRepositorio usuariorepositorio;
	
	@PostMapping("/registrar")
    public usuario usuarioregistro( @RequestBody usuario i) {
		return this.usuariorepositorio.save(i);
		
	}
	   
		
}
