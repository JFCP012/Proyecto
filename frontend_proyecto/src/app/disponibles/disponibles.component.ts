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

  abrirsesion(): void {
    this.router.navigate(['./alquileres']);
  }
  volver():void{
    this.router.navigate([`/vehiculos`])
      }
    }

    