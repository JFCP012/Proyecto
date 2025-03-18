package com.example.demo.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.modelo.loginAdmin;

import com.example.demo.repositorio.loginAdminRepositorio;

@RestController
@RequestMapping("/ver/loginAdmin/")
@CrossOrigin(origins = "http://localhost:4200/")
public class loginAdminControlador {

	@Autowired 
		private loginAdminRepositorio repositorio;
		
		@GetMapping("/login")
		public boolean Login(
			    @RequestParam(name = "usuario2") String usuario2,
			    @RequestParam(name = "clave2") String clave2){	
			List<loginAdmin> adm = this.repositorio.findAll();
			boolean adminEncontrado=false;
			for(int i=0;i<adm.size();i++) {
				String usuario=adm.get(i).getUsurio();
				String clave=adm.get(i).getClave();
				if(usuario.equals(usuario2) && clave.equals(clave2)) {
					adminEncontrado=true;
					
				}
			}
			if (!adminEncontrado) {
		        adminEncontrado=false;
		    }
		    
		    return adminEncontrado;
		}
		
		}


