package co.com.project.crud.techadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.com.project.crud.techadmin.repository.EntityEmpleado;
import co.com.project.crud.techadmin.services.ServiceEmpleado;

//se va a encargar de hacer el mapeo de mis clases frontend

@Controller
public class ControllerFrontend {
	
	//ejecutamos la llamada al service:
			@Autowired
			ServiceEmpleado serviceEmpleado;
			
	
	//lo marcamos como una interfaz Rest
	//renderizaremos el home.html en la raiz (/):
	@GetMapping(path= "/")
	//retornaremos cadenas de caracteres (los html)
	public String index() {
		
		//retornamos el index.html que esta en el template:
		return "index";
	}
	
	@GetMapping(path= "/home")
	//retornaremos cadenas de caracteres (los html)
	public String home() {
		
		//retornamos el index.html que esta en el template:
		return "home";
	}
	
	@GetMapping(path= "/pagina2")
	//el Model va a generar la comunicacion entre la vista(los html) y este backend
    public String pagina2(Model modelo) {
		
		
		//esto va ir hacer la logica en el serve y del service para ir al repository para llamar la data:
		List <EntityEmpleado> listaEmpleados= serviceEmpleado.listarEmpleados();
		
		//agregamos un atributo y la data traida de la base de datos al model:
		modelo.addAttribute("empleado",listaEmpleados);
		
		
		//retornamos el index.html que esta en el template:
		return "pagina2";
	}

}
