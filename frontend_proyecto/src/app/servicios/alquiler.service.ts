import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlquilerService {

  constructor(private httpClient:HttpClient) { }

  cancelar(
    id:number
  ):Observable<any>{
return this.httpClient.get(`http://localhost:8080/ver/alquiler/cancelar?id=${id}`);
  }

  private apiUrl = 'http://localhost:8080/ver/alquiler';


  registrarAlquiler(datos: any): Observable<any> {
    return this.httpClient.get<any>(`${this.apiUrl}/registrar`, datos);
  }
}
