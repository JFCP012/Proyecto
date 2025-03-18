import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { VehiculosService } from '../servicios/vehiculos.service';
import { Alquiler } from '../entidades/alquiler';

import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit {
  Alquiler: Alquiler[]
  recibo: object[]
  

  ngOnInit(): void {
    this.buscarAlquilados()
  }
  constructor(private vehiculosService: VehiculosService,
    private router: Router
  ) {}


  buscarAlquilados(){
    this.vehiculosService.buscar().subscribe(dato=>{
this.Alquiler=dato;
console.log(dato)
    })
  }
  actualizar(placa: string): void {
    this.vehiculosService.gestionar(placa).subscribe({
      next: (dato) => {
        console.log(dato);
        if (dato === true) {  // Corrección: Usar comparación en lugar de asignación
          this.buscarAlquilados();
        } if(dato ===false) {
          alert("El auto ya ha sido entregado");
        }
      },
    });
  }
  actualizarAlquiler(id: number): void {
    this.vehiculosService.actualizarAlquiler(id).subscribe({
      next: (dato) => {
        console.log(dato);
        if (dato === true) {  
          this.buscarAlquilados();
        } if(dato === false) {
          alert("El auto ya esta disponible");
        }
      },
      
    });
  }
  

  volver():void{
    this.router.navigate([`/vehiculos`])
      }
      abrirsesion2(): void {
        this.router.navigate(['./listaDisponibles']);
      }
}
