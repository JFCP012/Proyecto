import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginAdminService {

  constructor(private httpClient:HttpClient) { }


 login(
    usuario:string,
    clave:string
  ):Observable<any>{
    return this.httpClient.get(`http://localhost:8080/ver/loginAdmin/login?usuario2=${usuario}&clave2=${clave}`);
  }
}
