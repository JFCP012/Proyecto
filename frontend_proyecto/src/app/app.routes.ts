import { Routes } from '@angular/router';
import { UsuarioComponent } from './usuario/usuario.component';
import { LoginUsuarioComponent } from './login-usuario/login-usuario.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegistroComponent } from './registro/registro.component';
import { VehiculosComponent } from './vehiculos/vehiculos.component';
import { AlquilerComponent } from './alquiler/alquiler.component';
import { AdminComponent } from './admin/admin.component';

export const routes: Routes = [
    {path:'login',component:LoginUsuarioComponent},
    {path:'registro',component:RegistroComponent},
    {path:'loginAdmin',component:LoginAdminComponent},
    {path:'vehiculos',component:VehiculosComponent},
    {path:'alquiler',component:AlquilerComponent},
    {path:"usuario",component:UsuarioComponent},
    {path:"alquileres",component:AdminComponent}

];
