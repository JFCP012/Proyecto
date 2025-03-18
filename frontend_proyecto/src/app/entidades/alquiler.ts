import { LoginAdmin } from '../login-admin';
import { Usuario } from './usuario';
import { Vehiculos } from './vehiculos';
export class Alquiler {
    idAl:number;
    usuario:Usuario;
    vehiculo:Vehiculos;
    admin:LoginAdmin;
    fecha:Date;
    fechaEnt:Date;
    fechaD:Date;
    valorFinal:number;
    estadoAl:string;
    cedula: number;
    placa: String;
   

    

}
