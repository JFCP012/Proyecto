package com.example.demo.controlador;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.modelo.alquiler;
import com.example.demo.repositorio.alquilerRepositorio;


@RestController
@RequestMapping("/ver/alquiler")
@CrossOrigin(origins = "http://localhost:4200/")
public class alquilerControlador {
	
	@Autowired 
	private alquilerRepositorio repositorio;

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
public List<Object>Actualizar(
		@RequestParam("placa") String placa){
	List<Object> alqA = new LinkedList <>();
	List<alquiler> Ac = this.repositorio.findAll();
	for(int i=0;i<Ac.size();i++) {
		String Placa=Ac.get(i).getVehiculo().getPlaca();
		String estadO=Ac.get(i).getEstadoAl();
        if (Placa.equals(placa) && !estadO.equals("entregado"))  {
			Ac.get(i).setEstadoAl("entregado");
			this.repositorio.save(Ac.get(i));
			return alqA;
		}if (alqA.isEmpty()) {
	        alqA.add("Error no se encuentran vehiculos con la placa: " +placa +" en estado no entregado");
	}
		}
	return alqA;
	}


@GetMapping ("/cancelar")
public List<Object> cancelar(
		@RequestParam (name = "id") Long id){
	List<Object> alq = new LinkedList <>();
	 List<alquiler> Ac = this.repositorio.findAll();
		for(int i=0;i<Ac.size();i++) {
			Long Id=Ac.get(i).getIdAl();
			if(Id.equals(id)) {
				Ac.get(i).getVehiculo().setEstado("disponible");
				this.repositorio.save(Ac.get(i));
				this.repositorio.deleteById(id);
			}if (Ac.isEmpty()) {
		        alq.add("No se encontro un alquiler con el id: " +id);
			}
				}
			return alq;
			}

@GetMapping("/actualizarAlquiler")
public void actualizarAlquiler(@RequestParam(name = "id") Long id) {
    List<Object> alq = new LinkedList<>();
    List<alquiler> Ac = this.repositorio.findAll();

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

           
        }
    }
    
}

}




	

