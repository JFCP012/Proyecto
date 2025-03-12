package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.modelo.alquiler;

public interface alquilerRepositorio extends JpaRepository<alquiler,Long> {

}
