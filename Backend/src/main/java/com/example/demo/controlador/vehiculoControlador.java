package com.example.demo.controlador;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modelo.vehiculo;

import com.example.demo.repositorio.vehiculoRepositorio;

@RestController
@RequestMapping("/ver/vehiculos/")
public class vehiculoControlador {

	@Autowired 
	private vehiculoRepositorio repositorio;
	
	@GetMapping("/buscarDisponibles")
	public List<Object> buscarDisponibles() {
	    List<Object> vehiculosD = new LinkedList<>();
	    List<vehiculo> ve = this.repositorio.findAll();
	    String estado = "disponible";
	    boolean hayDisponibles = false;

	    for (int i = 0; i < ve.size(); i++) {
	        String Estado = ve.get(i).getEstado();
	        if (Estado.equals(estado)) {
	            String placa = ve.get(i).getPlaca();
	            String color = ve.get(i).getColor();
	            Long valor = ve.get(i).getValorVehiculo();
	            vehiculosD.add(placa);
	            vehiculosD.add(color);
	            vehiculosD.add(valor);
	            hayDisponibles = true;
	        }
	    }
//iyguguy
	    if (!hayDisponibles) {
	        vehiculosD.add("No hay carros disponibles");
	    }

	    return vehiculosD;
	}
	
	}
