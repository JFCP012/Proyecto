package com.example.demo.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import com.example.demo.modelo.alquiler;
import com.example.demo.modelo.loginAdmin;
import com.example.demo.modelo.usuario;
import com.example.demo.modelo.vehiculo;

public interface alquilerRepositorio extends JpaRepository<alquiler,Long> {
	
	@Query(value = "SELECT * FROM alquiler v WHERE v.estado_al = :estado",nativeQuery = true)
	List<alquiler> findByEstadoAl(@Param("estado") String estado);

	@Query(value = "SELECT * FROM alquiler v WHERE v.cedula = :cedula",nativeQuery = true)
	List<alquiler> findbycedula(@Param("cedula")Long cedula);

	public alquiler findByusuario(usuario usuario);
	public alquiler findByvehiculo(vehiculo vehiculo);
	public alquiler findByadmin(loginAdmin admin);
	public alquiler findByfecha(Date fecha);
	public alquiler findByfechaEnt(Date fechaEnt);
	public alquiler findByfechaD(Date fechaD);
	public alquiler findByvalorFinal(Float valorFinal);
	public alquiler findByestadoAl(String estadoAl);
	


}
