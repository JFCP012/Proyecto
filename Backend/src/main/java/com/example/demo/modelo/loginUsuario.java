package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="loginUsuario")

public class loginUsuario {
	
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private Long idL;
	
	@ManyToOne()
	@JoinColumn(name="cedula",referencedColumnName="cedula")
	private usuario usuario;
	
	@Column(name ="clave",length = 50 ,nullable=false)
	private String clave;

	public loginUsuario() {
		super();
	}

	public loginUsuario(Long idL, com.example.demo.modelo.usuario usuario, String clave) {
		super();
		this.idL = idL;
		this.usuario = usuario;
		this.clave = clave;
	}

	public Long getIdL() {
		return idL;
	}

	public void setIdL(Long idL) {
		this.idL = idL;
	}

	public usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(usuario usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	

}
