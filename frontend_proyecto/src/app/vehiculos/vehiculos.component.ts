import { CommonModule } from '@angular/common';
import { VehiculosService } from './../servicios/vehiculos.service';
import { Component, OnInit } from '@angular/core';
import { Vehiculos } from '../entidades/vehiculos';

@Component({
  selector: 'app-vehiculos',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './vehiculos.component.html',
  styleUrls: ['./vehiculos.component.css'] // ✅ Corrección: `styleUrls`
})
export class VehiculosComponent implements OnInit  {
  vehiculos: Vehiculos[];



  ngOnInit(): void {
    this.verDisponibles(); 
  }
  constructor(private vehiculosService: VehiculosService) {}
  verDisponibles() {
    this.vehiculosService.disponibles().subscribe(datos => {
      console.log('Datos recibidos:', datos);
      
      // Si `datos` no es un array, lo convertimos en uno
      if (!Array.isArray(datos)) {
        this.vehiculos = [datos]; // 🔹 Lo convertimos en un array
      } else {
        this.vehiculos = datos;
      }
    });
  }
  
  
  

  actualizar(placa:string){
    this.vehiculosService.gestionar(placa).subscribe(dato=>{
      alert(dato)
      console.log(dato)
      window.location.reload()
    })
  }
}

