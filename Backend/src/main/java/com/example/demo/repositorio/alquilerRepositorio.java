package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.modelo.alquiler;

public interface alquilerRepositorio extends JpaRepository<alquiler,Long> {
	
	@Query(value = "SELECT * FROM alquiler v WHERE v.estado_al = :estado",nativeQuery = true)
	List<alquiler> findByEstadoAl(@Param("estado") String estado);

	@Query(value = "SELECT * FROM alquiler v WHERE v.cedula = :cedula",nativeQuery = true)
	List<alquiler> findbycedula(@Param("cedula")Long cedula);

}
