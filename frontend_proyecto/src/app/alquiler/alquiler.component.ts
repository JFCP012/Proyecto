import { Alquiler } from './../entidades/alquiler';
import { UsuarioService } from './../servicios/usuario.service';
import { AlquilerService } from './../servicios/alquiler.service';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-alquiler',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './alquiler.component.html',
  styleUrl: './alquiler.component.css'
})
export class AlquilerComponent implements OnInit {
  cedula: number;
  Alquiler:Alquiler[]

constructor(
  private alquilerService: AlquilerService, 
  private usuarioService: UsuarioService,
  private router: Router
) {}

  ngOnInit(): void {
  }
  
verAlquiler(){
  this.usuarioService.buscar(this.cedula).subscribe(datos => {
    console.log('Datos recibidos:', datos);
    this.Alquiler=datos;
    // Si `datos` no es un array, lo convertimos en uno
    if (!Array.isArray(datos)) {
      this.Alquiler = [datos]; // 🔹 Lo convertimos en un array
    } else {
      this.Alquiler = datos;
    }
  });
}

  cancelar(idAl:number){
    this.alquilerService.cancelar(idAl).subscribe(dato => {
      console.log(dato)
      this.verAlquiler()
          });
        }

        volver():void{
          this.router.navigate([`/usuario`])
            }
  }

