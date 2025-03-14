import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-navegador',
  standalone: true,
  imports: [RouterOutlet, FormsModule, CommonModule],
  templateUrl: './navegador.component.html',
  styleUrl: './navegador.component.css'
})
export class NavegadorComponent {
  ver: boolean = true; // Los botones se muestran por defecto

  constructor(private router: Router) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        // Mostrar los botones solo en la página principal
        this.ver = event.url === '/' || event.url === '/home';
      }
    });
  }

  abrirsesion() {
    this.router.navigate(['/login']); // Navega sin modificar `ver`, lo hará `router.events`
  }

  Registro() {
    this.router.navigate(['/registro']); // Lo mismo aquí
  }
}
