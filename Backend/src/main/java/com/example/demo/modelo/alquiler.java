package com.example.demo.modelo;




import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="alquiler")

public class alquiler {

	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
	private Long idAl;
	
	@ManyToOne()
	@JoinColumn(name="cedula",referencedColumnName="cedula")
	private usuario usuario;
	
	@ManyToOne()
	@JoinColumn(name="placa",referencedColumnName="placa")
	private vehiculo vehiculo;
	
	@ManyToOne()
	@JoinColumn(name="usuario",referencedColumnName="usuario")
	private loginAdmin admin;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="MM/dd/yyyy")
	@Column(name= "fechaR", length = 20,nullable=false)
	private Date fecha;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="MM/dd/yyyy")
	@Column(name= "fechaEnt", length = 20,nullable=false)
	private Date fechaEnt;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="MM/dd/yyyy")
	@Column(name= "fechaD", length = 20,nullable=false)
	private Date fechaD;
	
	@Column(name ="valorFinal",length = 50 ,nullable=false)
	private Float valorFinal;
	
	@Column(name ="estadoAl",length = 50 ,nullable=false)
	private String estadoAl;

	public alquiler(usuario usuario2, vehiculo vehiculo2, loginAdmin administrador, Date fecha2, Date fechaEnt2, Date fechaD2, Long valorFinal2, String estadoAl2) {
		super();
	}

	public alquiler(usuario usuario,vehiculo vehiculo,loginAdmin admin, Date fecha, Date fechaEnt, 
			Date fechaD, Float valorFinal,String estadoAl) {
		super();
		this.usuario = usuario;
		this.vehiculo = vehiculo;
		this.admin = admin;
		this.fecha = fecha;
		this.fechaEnt = fechaEnt;
		this.fechaD = fechaD;
		this.valorFinal = valorFinal;
		this.estadoAl = estadoAl;
	}

	public Long getIdAl() {
		return idAl;
	}

	public void setIdAl(Long idAl) {
		this.idAl = idAl;
	}

	public usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(usuario usuario) {
		this.usuario = usuario;
	}

	public vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public loginAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(loginAdmin admin) {
		this.admin = admin;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaEnt() {
		return fechaEnt;
	}

	public void setFechaEnt(Date fechaEnt) {
		this.fechaEnt = fechaEnt;
	}

	public Date getFechaD() {
		return fechaD;
	}

	public void setFechaD(Date fechaD) {
		this.fechaD = fechaD;
	}

	public Float getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Float valorFinal) {
		this.valorFinal = valorFinal;
	}

	public String getEstadoAl() {
		return estadoAl;
	}

	public void setEstadoAl(String estadoAl) {
		this.estadoAl = estadoAl;
	}
	
	
	
	
	
	
	
}
