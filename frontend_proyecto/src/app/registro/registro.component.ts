import { FormsModule } from '@angular/forms';
import { UsuarioService } from '../servicios/usuario.service';
import { Component, OnInit } from '@angular/core';
import { Usuario } from '../entidades/usuario';
import { LoginUsuario } from '../entidades/login-usuario';
import { LoginUsuarioService } from '../servicios/login-usuario.service';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})
export class RegistroComponent implements OnInit{

  ngOnInit(): void {
  }
  Usuario:Usuario=new Usuario
  login : string;

  constructor(private servicio:UsuarioService, private logservi: LoginUsuarioService){

  }

  
  guardarRegistro(){
    this.servicio.registrarUsuario(this.Usuario).subscribe(dato=>{
      console.log(dato)
      if(dato!=null){
        alert("usuario registrado");
        window.location.replace("/login"); 
      }
      else{
        alert ("registro incompleto")
   }

  
})
  }

}
