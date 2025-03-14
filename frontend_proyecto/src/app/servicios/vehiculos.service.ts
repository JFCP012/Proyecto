
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vehiculos } from '../entidades/vehiculos';
import { Alquiler } from '../entidades/alquiler';

@Injectable({
  providedIn: 'root'
})
export class VehiculosService {
  private bdURL ="http://localhost:8080/ver/alquiler";

  constructor(private httpClient: HttpClient) {}

  disponiblesN(): Observable<Alquiler[]> {
    return this.httpClient.get<Alquiler[]>(`${this.bdURL}/buscarNoEntregados`,{
    });
}
  gestionar(
    placa:string
  ):Observable<any>{
return this.httpClient.get(`http://localhost:8080/ver/alquiler/actualizar?placa=${placa}`)
  }

  buscar():Observable<Alquiler[]>{
    return this.httpClient.get<Alquiler[]>(`http://localhost:8080/ver/alquiler/buscar`)
  }

  actualizarAlquiler(id:number):Observable<object[]>{
    return this.httpClient.get<object[]>(`http://localhost:8080/ver/alquiler/actualizarAlquiler?id=${id}`)
  }
}
