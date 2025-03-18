import { Alquiler } from './../entidades/alquiler';
import { UsuarioService } from './../servicios/usuario.service';
import { AlquilerService } from './../servicios/alquiler.service';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';



import jsPDF from 'jspdf';
import 'jspdf-autotable';

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
  alquiler: Alquiler= new Alquiler;
  vehiculoAlquilado: any = null;
  
  estadoAl: string ;
  valorFinal: number ;

constructor(
  private alquilerService: AlquilerService, 
  private usuarioService: UsuarioService,
  private router: Router,
  private AlquilerService:AlquilerService
) {}

  ngOnInit(): void {
  }
  
verAlquiler(){
  this.usuarioService.buscar(this.cedula).subscribe(datos => {
    console.log('Datos recibidos:', datos);
    this.Alquiler=datos;
    // Si `datos` no es un array, lo convertimos en uno
    if (datos.length === 0) {
      this.Alquiler = []; // Aseguramos que la variable sea un array vacío
      alert("No hay alquileres relacionados a la cedula digitada");
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

            registrar() {
              this.AlquilerService.registrarAlquiler({ params: this.alquiler }).subscribe({
                next: (response) => {
                  console.log('alquiler registrado:', response);
                  alert('alquiler registrado con exito');
          
                  this.generarPDF(response);
                },
                error: (error) => {
                  alert(error.error.message);
                }
              });
          }
          
          generarPDF(data: any) {
              const doc = new jsPDF();
          
              doc.setFontSize(18);
              doc.text('comprobante de alquiler', 70, 20);
          
              doc.setFontSize(12);
              doc.text(`cedula: ${this.alquiler.cedula}`, 20, 40);
              doc.text(`fecha de alquiler: ${this.alquiler.fecha}`, 20, 50);
              doc.text(`fecha de entrega: ${this.alquiler.fechaEnt}`, 20, 60);
              doc.text(`fecha de devolucion: ${this.alquiler.fechaD}`, 20, 70);
              doc.text(`valor final: ${data.valorFinal}`, 20, 80);
              doc.text(`estado del alquiler: ${data.estadoAl}`, 20, 90);
          
              doc.text('datos del vehiculo:', 20, 110);
              doc.text(`placa: ${data.vehiculo.placa}`, 20, 120);
              
              doc.text(`color: ${data.vehiculo.color}`, 20, 150);
          
              doc.save(`alquiler_${this.alquiler.cedula}.pdf`);
          }
          
          
  }

