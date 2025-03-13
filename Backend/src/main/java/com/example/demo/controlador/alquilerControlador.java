package com.example.demo.controlador;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.modelo.alquiler;
import com.example.demo.repositorio.alquilerRepositorio;


@RestController
@RequestMapping("/ver/alquiler/")
@CrossOrigin(origins = "http://localhost:4200/")
public class alquilerControlador {
	
	@Autowired 
	private alquilerRepositorio repositorio;

@GetMapping("/buscarNoEntregados")
	public List<Object>buscarNoEntregados(){
		List<Object> vehiculosNo = new LinkedList <>();
		List<alquiler> al = this.repositorio.findAll();
		String estadoAl="no entregado";
		for(int i=0;i<al.size();i++) {
			String EstadoAl=al.get(i).getEstadoAl();
			if(EstadoAl.equals(estadoAl)) {
				String placa=al.get(i).getVehiculo().getPlaca();
				String color= al.get(i).getVehiculo().getColor();
				Long valor=al.get(i).getVehiculo().getValorVehiculo();
				vehiculosNo.add("Placa: "+placa);
				vehiculosNo.add("Color: "+color);
				vehiculosNo.add("valor: "+valor);
				return vehiculosNo;	
			}else {
				vehiculosNo.add("No hay vehiculos con estado no entregado");
			}
		}
		return vehiculosNo;		
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
		@RequestParam Long id){
	List<Object> alq = new LinkedList <>();
	 List<alquiler> Ac = this.repositorio.findAll();
		for(int i=0;i<Ac.size();i++) {
			Long Id=Ac.get(i).getIdAl();
			if(Id.equals(id)) {
				Ac.get(i).getVehiculo().setEstado("disponible");
				this.repositorio.save(Ac.get(i));
				this.repositorio.deleteById(id);
			alq.add("Ha sido borrado el alquiler: "+ id);
			}if (Ac.isEmpty()) {
		        alq.add("No se encontro un alquiler con el id: " +id);
			}
				}
			return alq;
			}

@GetMapping("/actualizarAlquiler")
public List<Object> actualizarAlquiler(@RequestParam Long id) {
    List<Object> alq = new LinkedList<>();
    List<alquiler> Ac = this.repositorio.findAll();

    for (alquiler alquiler : Ac) {
        if (alquiler.getIdAl().equals(id)) {
            alquiler.getVehiculo().setEstado("disponible");

            // Obtener fechas
            Date fechaEntrega = new Date(alquiler.getFechaEnt().getTime()); // Convertir java.sql.Date a java.util.Date
            Date fechaActual = new Date();
            float valorVehiculo = alquiler.getVehiculo().getValorVehiculo();

            // Calcular diferencia de días
            long diferenciaDias = ChronoUnit.DAYS.between(
                fechaEntrega.toInstant(), fechaActual.toInstant()
            );

            // Calcular el monto adicional (días * 10000)
            float montoAdicional = diferenciaDias * 10000;

            // Calcular el valor total
            float valorTotal = valorVehiculo + montoAdicional;

            // Guardar cambios
            this.repositorio.save(alquiler);

            // Agregar información a la lista de respuesta
            alq.add("Ha sido cambiado el estado del alquiler con ID: " + id);
            alq.add("Fecha de entrega: " + fechaEntrega);
            alq.add("Diferencia de días: " + diferenciaDias);
            alq.add("Monto adicional: " + montoAdicional);
            alq.add("Valor total a pagar: " + valorTotal);

            return alq;
        }
    }

    // Si no se encuentra el ID, agregar mensaje
    if (Ac.isEmpty()) {
        alq.add("No se encontró un alquiler con el ID: " + id);
    }

    return alq;
    
}

}




	

