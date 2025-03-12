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
@Table(name="logindmin")

public class loginAdmin {
	
	@Id
	@Column(name="usuario",length = 50)
	private String usurio;
	
	@Column(name ="clave",length = 50 ,nullable=false)
	private String clave;
	
	

	public loginAdmin() {
		super();
	}



	public loginAdmin(String usurio, String clave) {
		super();
		this.usurio = usurio;
		this.clave = clave;
	}



	public String getUsurio() {
		return usurio;
	}



	public void setUsurio(String usurio) {
		this.usurio = usurio;
	}



	public String getClave() {
		return clave;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	//borrar 
	

}
