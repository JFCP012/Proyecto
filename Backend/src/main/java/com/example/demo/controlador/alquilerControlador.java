package com.example.demo.controlador;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.modelo.alquiler;
import com.example.demo.modelo.loginAdmin;
import com.example.demo.modelo.usuario;
import com.example.demo.modelo.vehiculo;
import com.example.demo.repositorio.alquilerRepositorio;
import com.example.demo.repositorio.loginAdminRepositorio;
import com.example.demo.repositorio.usuarioRepositorio;
import com.example.demo.repositorio.vehiculoRepositorio;


@RestController
@RequestMapping("/ver/alquiler")
@CrossOrigin(origins = "http://localhost:4200/")
public class alquilerControlador {
	
	@Autowired 
	private alquilerRepositorio repositorio;
	@Autowired 
	private vehiculoRepositorio vehiculorepositorio;
	@Autowired 
	private usuarioRepositorio usuariorepositorio;
	@Autowired 
	private loginAdminRepositorio adminrepositorio;

@GetMapping("/buscarNoEntregados")
	public List<alquiler>buscarNoEntregados(){
	return repositorio.findByEstadoAl("no entregado");
	}
	
	@GetMapping("/buscar")
	public List<alquiler>buscaR(){
		return repositorio.findAll();
		}
	
	@GetMapping("/buscarAl")
	public List<alquiler>buscaAl(@RequestParam(name = "cedula") Long cedula){
		return repositorio.findbycedula(cedula);
		}
	

@GetMapping ("/actualizar")
public boolean Actualizar(
		@RequestParam("placa") String placa){
	List<alquiler> Ac = this.repositorio.findAll();
	boolean encontrado = false;
	for(int i=0;i<Ac.size();i++) {
		String Placa=Ac.get(i).getVehiculo().getPlaca();
		String estadO=Ac.get(i).getEstadoAl();
        if (Placa.equals(placa) && !estadO.equals("entregado"))  {
			Ac.get(i).setEstadoAl("entregado");
			this.repositorio.save(Ac.get(i));
			encontrado=true;
			break;
		}
        else {
        	encontrado=false;
        }
		}
	return encontrado;
	}


@GetMapping ("/cancelar")
public void cancelar(
		@RequestParam (name = "id") Long id){
	 List<alquiler> Ac = this.repositorio.findAll();
	 boolean encontrado = false;
		for(int i=0;i<Ac.size();i++) {
			Long Id=Ac.get(i).getIdAl();
			if(Id.equals(id)) {
				Ac.get(i).getVehiculo().setEstado("disponible");
				this.repositorio.save(Ac.get(i));
				this.repositorio.deleteById(id);
				
			} 
				}


			}

@GetMapping("/actualizarAlquiler")
public boolean actualizarAlquiler(@RequestParam(name = "id") Long id) {
    List<Object> alq = new LinkedList<>();
    List<alquiler> Ac = this.repositorio.findAll();
    boolean encontrado = false;

    for(int i=0;i<Ac.size();i++) {
        if (Ac.get(i).getIdAl().equals(id)) {
            Ac.get(i).getVehiculo().setEstado("disponible");

            // Obtener fechas
            Date fechaEntrega = new Date(Ac.get(i).getFechaEnt().getTime()); // Convertir java.sql.Date a java.util.Date
            Date fechaActual = new Date();
            float valorVehiculo = Ac.get(i).getVehiculo().getValorVehiculo();

            // Calcular diferencia de días
            long diferenciaDias = ChronoUnit.DAYS.between(
                fechaEntrega.toInstant(), fechaActual.toInstant()
            );

            // Calcular el monto adicional (días * 10000)
            float montoAdicional = diferenciaDias * 10000;

            // Calcular el valor total
            float valorTotal = valorVehiculo + montoAdicional;

            Ac.get(i).setValorFinal(valorTotal);
            // Guardar cambios
            this.repositorio.save(Ac.get(i));
            encontrado=true;

           
        }else {
        	encontrado=false;
        }
    }return encontrado;
    
}
@GetMapping("/registrar")
public alquiler registrarAlquiler(
        @RequestParam Long cedula,
        @RequestParam String placa,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaEnt,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaD) {

    usuario usuario = usuariorepositorio.findBycedula(cedula);
    vehiculo vehiculo = vehiculorepositorio.findByplaca(placa);

    if ("ocupado".equals(vehiculo.getEstado())) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "el vehiculo ya esta alquilado");
    }
    vehiculo.setEstado("ocupado");
    vehiculorepositorio.save(vehiculo);

    loginAdmin administrador = adminrepositorio.findById("1").get();
    Long valorFinal = vehiculo.getValorVehiculo();

    String estadoAl = "ocupado";
    alquiler nuevoAlquiler = new alquiler(usuario, vehiculo, administrador, fecha, fechaEnt, fechaD, valorFinal, estadoAl);
    repositorio.save(nuevoAlquiler);

    return nuevoAlquiler;
}

}




	

