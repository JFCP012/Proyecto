import { RouterOutlet } from '@angular/router';
import { LoginUsuarioService } from './../servicios/login-usuario.service';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router'; 
import { FormsModule } from '@angular/forms';
import { NavegadorComponent } from "../navegador/navegador.component";

@Component({
  selector: 'app-login-usuario',
  standalone: true,
  imports: [RouterOutlet, CommonModule, FormsModule, NavegadorComponent], 
  templateUrl: './login-usuario.component.html',
  styleUrls: ['./login-usuario.component.css'] 
})
export class LoginUsuarioComponent implements OnInit {

  cedula: number ;
  password: string ;

  constructor(
    private loginUsuarioService: LoginUsuarioService, 
    private router: Router // Inyectar Router
  ) {}

  ngOnInit(): void {}

  validacionLogin() {
    this.loginUsuarioService.iniciarSesion(this.cedula,this.password).subscribe(dato => {
      console.log(dato); 
      if (dato === true) { 
        this.router.navigate(['/usuario']); 
      } else {
        alert("Usuario o contraseña incorrectos");
      }
    });
  }
}
