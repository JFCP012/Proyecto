import { LoginAdminService } from './../servicios/login-admin.service';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router'; 
@Component({
  selector: 'app-login-admin',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './login-admin.component.html',
  styleUrl: './login-admin.component.css'
})
export class LoginAdminComponent implements OnInit{

  usuario: string;
  password: string;
  

  constructor(private LoginAdminService:LoginAdminService,
        private router: Router
  ) {}

  ngOnInit(): void {}

  validacionLoginAdmin() {
    this.LoginAdminService.login(this.usuario,this.password).subscribe(dato => {
console.log(dato)
if (dato === true) { 
  this.router.navigate(['/vehiculos']); 
} else {
  alert("Usuario o contraseña incorrectos");
}
    });
  }
}
