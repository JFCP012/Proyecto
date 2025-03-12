package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vehiculos")

public class vehiculo {
	@Id
	@Column(name="placa",length = 20)
	private String placa;
	
	@Column(name ="color",length = 50 ,nullable=false)
	private String color;
	
	@Column(name ="tipo",length = 50 ,nullable=false)
	private String tipo;
	
	@Column(name ="estado",length = 20 ,nullable=false)
	private String estado;
	
	@Column(name ="valorVehiculo",length = 50 ,nullable=false)
	private Long valorVehiculo;

	public vehiculo() {
		super();
	}

	public vehiculo(String placa, String color, String tipo, String estado, Long valorVehiculo) {
		super();
		this.placa = placa;
		this.color = color;
		this.tipo = tipo;
		this.estado = estado;
		this.valorVehiculo = valorVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getValorVehiculo() {
		return valorVehiculo;
	}

	public void setValorVehiculo(Long valorVehiculo) {
		this.valorVehiculo = valorVehiculo;
	}
	
	
}
