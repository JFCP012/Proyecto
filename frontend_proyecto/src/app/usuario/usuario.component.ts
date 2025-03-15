import { UsuarioService } from './../servicios/usuario.service';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Vehiculos } from '../entidades/vehiculos';
import { VehiculosService } from '../servicios/vehiculos.service';
import { Router } from '@angular/router';


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

  constructor(private UsuarioService: UsuarioService,
       private router: Router
  ) {}
  verDisponibles() {
    this.UsuarioService.disponibles(this.tipo).subscribe(datos => {
      console.log('Datos recibidos:', datos);
      
      if (!Array.isArray(datos) || datos.length === 0) {
        this.vehiculos = []; // Aseguramos que la variable sea un array vacío
        alert("No hay vehiculos disponibles");
      } else {
        this.vehiculos = datos;
      } 
    });
  }
  abrirsesion(): void {
    this.router.navigate(['./alquiler']);
  }


    }