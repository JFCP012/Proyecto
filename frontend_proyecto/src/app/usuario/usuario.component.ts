import { UsuarioService } from './../servicios/usuario.service';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Vehiculos } from '../entidades/vehiculos';
import { VehiculosService } from '../servicios/vehiculos.service';


@Component({
  selector: 'app-usuario',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './usuario.component.html',
  styleUrl: './usuario.component.css'
})
export class UsuarioComponent {
 vehiculos: Vehiculos[];
  tipo:string;

  constructor(private UsuarioService: UsuarioService) {}
  verDisponibles() {
    this.UsuarioService.disponibles(this.tipo).subscribe(datos => {
      console.log('Datos recibidos:', datos);
      
      // Si `datos` no es un array, lo convertimos en uno
      if (!Array.isArray(datos)) {
        this.vehiculos = [datos]; // 🔹 Lo convertimos en un array
      } else {
        this.vehiculos = datos;
      }
    });
  }
    }