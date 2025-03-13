package com.example.demo.controlador;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modelo.vehiculo;

import com.example.demo.repositorio.vehiculoRepositorio;

@RestController
@RequestMapping("/ver/vehiculos/")
@CrossOrigin(origins = "http://localhost:4200/")
public class vehiculoControlador {

	@Autowired 
	private vehiculoRepositorio repositorio;
	

	 @GetMapping("/buscarDisponibles")
	    public List<vehiculo> Disponibles(@RequestParam("tipo") String tipo) {
	        return repositorio.findByEstado("disponible", tipo);
	    }
	}
	
