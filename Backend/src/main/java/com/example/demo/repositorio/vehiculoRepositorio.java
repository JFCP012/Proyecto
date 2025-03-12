package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.vehiculo;



public interface vehiculoRepositorio extends JpaRepository<vehiculo,String> {

}
