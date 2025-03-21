import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehiculos } from '../entidades/vehiculos';
import { Alquiler } from '../entidades/alquiler';


import { Usuario } from '../entidades/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private bdURL ="http://localhost:8080/ver/vehiculos";
  constructor(private httpClient: HttpClient) { }

  disponibles(tipo: string): Observable<Vehiculos[]> {
    return this.httpClient.get<Vehiculos[]>(`${this.bdURL}/buscarDisponibles`, { params: { tipo } });
  }
  
  buscar(cedula:number):Observable<Alquiler[]>{
    return this.httpClient.get<Alquiler[]>(`http://localhost:8080/ver/alquiler/buscarAl?cedula=${cedula}`)
  }

  private bdURLG = "http://localhost:8080/ver/usuario/registrar"
  registrarUsuario(usuario: Usuario):Observable<object>{
    return this.httpClient.post(`${this.bdURLG}`,usuario);
  }
}
