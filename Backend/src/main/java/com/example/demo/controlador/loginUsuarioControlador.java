package com.example.demo.controlador;


import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modelo.loginUsuario;

import com.example.demo.repositorio.loginUsuarioRepositorio;


@RestController
@RequestMapping("/ver/loginUsuario/")
@CrossOrigin(origins = "http://localhost:4200/")
public class loginUsuarioControlador {


	
	@Autowired 
	private loginUsuarioRepositorio repositorio;
	

	@GetMapping("/login")
	public boolean login(@RequestParam Long cedula2, @RequestParam String clave2) {
	    List<loginUsuario> usuarios = this.repositorio.findAll();
	    boolean usuarioEncontrado = false;
	    
	    for (loginUsuario usuario : usuarios) {
	        long cedula = usuario.getUsuario().getCedula();
	        String clave = usuario.getClave();
	        String nombre = usuario.getUsuario().getNombre1();
	        
	        if (cedula == cedula2 && clave.equals(clave2)) {
	            usuarioEncontrado = true;
	        }
	    }
	    
	    if (!usuarioEncontrado) {
			usuarioEncontrado=false;
	    }
		return usuarioEncontrado;
	    
	}
	
	}

//cambielo solo hice para que no me mostrara error
