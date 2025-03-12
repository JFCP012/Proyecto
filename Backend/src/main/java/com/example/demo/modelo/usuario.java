package com.example.demo.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="usuario")


public class usuario {
	
	@Id
	@Column(name="cedula",length = 15)
	private long cedula;
	
	@Column(name ="nombre1",length = 50 ,nullable=false)
	private String nombre1;
	
	@Column(name ="nombre2",length = 50 ,nullable=false)
	private String nombre2;
	
	@Column(name ="apellido1",length = 50 ,nullable=false)
	private String apellido1;
	
	@Column(name ="apellido2",length = 50 ,nullable=false)
	private String apellido2;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="MM/dd/yyyy")
	@Column(name ="fechaEx",length = 15 ,nullable=false)
	private Date fechaEX;
	
	@Column(name ="categoriaLi",length = 50 ,nullable=false)
	private String categoriaLi;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="MM/dd/yyyy")
	@Column(name ="vigenciaLi",length = 15 ,nullable=false)
	private Date vigenciaLi;
	
	@Column(name ="correo",length = 50 ,nullable=false)
	private String correo;
	
	@Column(name ="telefono",length = 50 ,nullable=false)
	private Long telefono;
	
	

	public usuario() {
		super();
	}

	public usuario(long cedula, String nombre1, String nombre2, String apellido1, String apellido2, Date fechaEX,
			String categoriaLi, Date vigenciaLi, String correo, Long telefono) {
		super();
		this.cedula = cedula;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaEX = fechaEX;
		this.categoriaLi = categoriaLi;
		this.vigenciaLi = vigenciaLi;
		this.correo = correo;
		this.telefono = telefono;

	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getFechaEX() {
		return fechaEX;
	}

	public void setFechaEX(Date fechaEX) {
		this.fechaEX = fechaEX;
	}

	public String getCategoriaLi() {
		return categoriaLi;
	}

	public void setCategoriaLi(String categoriaLi) {
		this.categoriaLi = categoriaLi;
	}

	public Date getVigenciaLi() {
		return vigenciaLi;
	}

	public void setVigenciaLi(Date vigenciaLi) {
		this.vigenciaLi = vigenciaLi;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	
			}	
