import { AlquilerService } from './../servicios/alquiler.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-alquiler',
  standalone: true,
  imports: [],
  templateUrl: './alquiler.component.html',
  styleUrl: './alquiler.component.css'
})
export class AlquilerComponent implements OnInit {
  constructor(private AlquilerService:AlquilerService){}


  ngOnInit(): void {}

  cancelar(){
    this.AlquilerService.cancelar(1).subscribe(dato => {
      alert(dato)
      console.log(dato)
          });
        }
  }

