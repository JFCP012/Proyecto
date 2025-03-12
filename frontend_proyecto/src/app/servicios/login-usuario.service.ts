import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginUsuarioService {
  private bdURL ="http://localhost:8080/ver/loginUsuario/";

  constructor(private httpClient:HttpClient) { }
  
  iniciarSesion(
    cedula:number,
    clave:string
  ):Observable<any>{
    return this.httpClient.get(`http://localhost:8080/ver/loginUsuario/login?cedula2=${cedula}&clave2=${clave}`);
  }
}
