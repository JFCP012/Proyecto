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
  vehiculos:Vehiculos[];


  ngOnInit(): void {
    this.verDisponibles(); 
  }
  constructor(private vehiculosService: VehiculosService) {}

  verDisponibles() {
    this.vehiculosService.disponibles().subscribe(datos => {
      this.vehiculos=datos; 
      console.log('Datos recibidos:', datos);

    });
  }

  actualizar(){
    this.vehiculosService.gestionar("JFCP012S").subscribe(dato=>{
      alert(dato)
      console.log(dato)
    })
  }
}

