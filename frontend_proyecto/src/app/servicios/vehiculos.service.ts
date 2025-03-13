import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Vehiculos } from '../entidades/vehiculos';

@Injectable({
  providedIn: 'root'
})
export class VehiculosService {
  private bdURL ="http://localhost:8080/ver/vehiculos/buscarDisponibles";

  constructor(private httpClient: HttpClient) {}

  disponibles():Observable<Vehiculos[]> {
    return this.httpClient.get<Vehiculos[]>(`${this.bdURL}`);
  }
  

  gestionar(
    placa:string
  ):Observable<any>{
return this.httpClient.get(`http://localhost:8080/ver/alquiler/actualizar?placa=${placa}`)
  }
}
