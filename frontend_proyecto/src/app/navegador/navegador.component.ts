import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navegador',
  standalone: true,
  imports: [RouterOutlet,FormsModule,CommonModule],
  templateUrl: './navegador.component.html',
  styleUrl: './navegador.component.css'
})
export class NavegadorComponent {
ver:boolean

constructor(private router:Router){
  this.ver=true;
}
abrirsesion(){
  this.ver = false;
  this.router.navigate(['./login'])

}
Registro(){
  this.ver=false;
  this.router.navigate(['./registro'])
  }
}
