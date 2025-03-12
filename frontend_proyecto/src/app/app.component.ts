import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavegadorComponent } from "./navegador/navegador.component";
import { FormsModule } from '@angular/forms';
import { LoginUsuarioComponent } from "./login-usuario/login-usuario.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [NavegadorComponent, FormsModule, LoginUsuarioComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend_proyecto';
}
