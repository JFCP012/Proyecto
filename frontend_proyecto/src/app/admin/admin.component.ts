import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { VehiculosService } from '../servicios/vehiculos.service';
import { Alquiler } from '../entidades/alquiler';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent implements OnInit {
  Alquiler: Alquiler[]

  ngOnInit(): void {
    this.buscarAlquilados()
  }
  constructor(private vehiculosService: VehiculosService) {}


  buscarAlquilados(){
    this.vehiculosService.buscar().subscribe(dato=>{
this.Alquiler=dato;
console.log(dato)
    })
  }
  actualizar(placa: string): void {
    this.vehiculosService.gestionar(placa).subscribe({
      next: (dato) => {
        alert(dato);
        console.log(dato);
        window.location.reload() // ✅ En lugar de `window.location.reload()`, actualizamos la lista
      },
      error: (err) => console.error('Error al actualizar:', err)
    });
  }
}
