package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.usuario;
import java.util.Date;
public interface usuarioRepositorio extends JpaRepository<usuario, Long> {


  
    
	public usuario findBycedula(Long cedula);
	public usuario findBynombre1(String nombre1);
	public usuario findBynombre2(String nombre2);
	public usuario findByapellido1(String apellido1);
	public usuario findByapellido2(String apellido2);
	public usuario findByfechaEX(Date fechaEX);
	public usuario findBycategoriaLi(String categoriaLi);
	public usuario findByvigenciaLi(Date vigenciaLi);
	public usuario findBycorreo(String correo);
	public usuario findBytelefono(Long telefono);
    
    
}