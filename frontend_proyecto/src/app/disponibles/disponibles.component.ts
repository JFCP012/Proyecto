import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../servicios/usuario.service';
import { Vehiculos } from '../entidades/vehiculos';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-disponibles',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './disponibles.component.html',
  styleUrl: './disponibles.component.css'
})
export class DisponiblesComponent implements OnInit {
  vehiculos: Vehiculos[];
  tipo:string;


  constructor(private UsuarioService: UsuarioService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.verDisponibles()
  }
  verDisponibles() {
    this.UsuarioService.disponibles(this.tipo).subscribe({
      next: (datos) => {
        console.log('Datos recibidos:', datos);
  
        // Verificamos si `datos` es un array y si tiene elementos
        if (!Array.isArray(datos) || datos.length === 0) {
          this.vehiculos = []; // Aseguramos que la variable sea un array vacío
          alert("No hay vehiculos disponibles");
        } else {
          this.vehiculos = datos;
        }
      },
      error: (error) => {
        console.error('Error al obtener los datos:', error);
        alert("Ocurrió un error al obtener los vehículos disponibles.");
      }
    });
  }
  

  abrirsesion(): void {
    this.router.navigate(['./alquileres']);
  }
  volver():void{
    this.router.navigate([`/vehiculos`])
      }
    }

    