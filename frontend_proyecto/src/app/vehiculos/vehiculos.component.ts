import { CommonModule } from '@angular/common';
import { VehiculosService } from './../servicios/vehiculos.service';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router'; // ✅ Importar Router
import { Alquiler } from '../entidades/alquiler';

@Component({
  selector: 'app-vehiculos',
  standalone: true,
  imports: [CommonModule, FormsModule], // ✅ Eliminado CommonModule duplicado
  templateUrl: './vehiculos.component.html',
  styleUrls: ['./vehiculos.component.css']
})
export class VehiculosComponent implements OnInit {
  alquiler: Alquiler[] = []; // ✅ Inicialización para evitar `undefined`

  constructor(
    private vehiculosService: VehiculosService,
    private router: Router // ✅ Agregado `Router` al constructor
  ) {}

  ngOnInit(): void {
    this.verDisponibles();
  }

  verDisponibles(): void {
    this.vehiculosService.disponiblesN().subscribe({
      next: (datos) => {
        console.log('Datos recibidos:', datos);
        this.alquiler = datos;
      },
      error: (err) => console.error('Error al obtener datos:', err) // ✅ Manejo de errores
    });
  }



  abrirsesion(): void {
    this.router.navigate(['./alquileres']);
  }
  abrirsesion2(): void {
    this.router.navigate(['./listaDisponibles']);
  }
}
