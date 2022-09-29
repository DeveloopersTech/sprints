package co.com.project.crud.techadmin.controller;

import java.util.List;

import co.com.project.crud.techadmin.repository.EntityEmpresa;
import co.com.project.crud.techadmin.repository.EntityMovimientoDinero;
import co.com.project.crud.techadmin.services.ServiceEmpresa;
import co.com.project.crud.techadmin.services.ServiceMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import co.com.project.crud.techadmin.repository.EntityEmpleado;
import co.com.project.crud.techadmin.services.ServiceEmpleado;
import org.springframework.web.servlet.view.RedirectView;

//se va a encargar de hacer el mapeo de mis clases frontend

@Controller
public class ControllerFrontend {
	
	//ejecutamos la llamada al service:
	@Autowired
	ServiceEmpleado serviceEmpleado;
	@Autowired
	ServiceEmpresa serviceEmpresa;

	@Autowired
	ServiceMovimientoDinero serviceMovimientoDinero;

			
	
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
	
	@GetMapping(path= "/404")
	//retornaremos cadenas de caracteres (los html)
	public String error() {
		
		//retornamos el index.html que esta en el template:
		return "404";
	}

	// MEEEEE
	@GetMapping(path= "/empleado")
	//retornaremos cadenas de caracteres (los html)
	public String empleado(Model modelo) {
		List<EntityEmpleado> listaempleados = serviceEmpleado.listarEmpleados();
		modelo.addAttribute("empleado", listaempleados);
		//retornamos el empleado.html que esta en el template:
		return "empleado";
	}

	@GetMapping(path= "/empresa")
	//retornaremos cadenas de caracteres (los html)
	public String empresa(Model modelo) {
		List<EntityEmpresa> listaempresas = serviceEmpresa.listarEmpresas();
		modelo.addAttribute("empresa", listaempresas);
		//retornamos el empresa.html que esta en el template:
		return "empresa";
	}

	@GetMapping(path= "/movimiento")
	//retornaremos cadenas de caracteres (los html)
	public String movimiento(Model modelo) {
		List<EntityMovimientoDinero> listamovimientos = serviceMovimientoDinero.listarMovimientoDinero();
		modelo.addAttribute("movimiento", listamovimientos);
		//retornamos el movimiento.html que esta en el template:
		return "movimiento";
	}
	

	@GetMapping(path= "/formularioEmpresaEditar")
	//retornaremos cadenas de caracteres (los html)
	public String formularioEmpresaEditar() {

		//retornamos el movimiento.html que esta en el template:
		return "formularioEmpresaEditar";
	}

	

	@GetMapping(path= "/formularioMovimientoEditar")
	//retornaremos cadenas de caracteres (los html)
	public String formularioMovimientoEditar() {

		//retornamos el movimiento.html que esta en el template:
		return "formularioMovimientoEditar";
	}



	//Models:
	
	
	//el Model va a generar la comunicacion entre la vista(los html) y este backend
	//el ModelAttribute se encargara de que todo lo que viaje en el form sea englobado
	//el Metodo de tipo RedirectView lo que hará es enviarnos a una vista cuando el proceso POST de succes
	@GetMapping(path= "/formularioEmpleado")
	public String formularioEmpleado(Model modelo){

		/*con la instancia new le entragamos al frontend (formulario) el modelo de empleado vacio para ser
		llenado:*/
		modelo.addAttribute("nuevoEmpleado", new EntityEmpleado());
		
		return "formularioEmpleado";
	}
	
	//retornaremos cadenas de caracteres (los html)
	@GetMapping(path= "/formularioEmpresa")
	public String formularioEmpresa(Model modelo) {

		modelo.addAttribute("nuevaEmpresa", new EntityEmpresa());

		//retornamos el movimiento.html que esta en el template:
		return "formularioEmpresa";
	}
	
	//retornaremos cadenas de caracteres (los html)
		@GetMapping(path= "/formularioMovimiento")
		public String formularioMovimiento(Model modelo) {

			modelo.addAttribute("nuevoMovimiento", new EntityMovimientoDinero());

			//retornamos el movimiento.html que esta en el template:
			return "formularioMovimiento";
		}
	
	//El id es para saber cual es el empleado a editar
	@GetMapping(path= "/formularioEmpleadoEditar/{id}")
	public String formularioEmpleadoEditar(Model modelo, @PathVariable Long id){
		
		EntityEmpleado empleadoTemp= serviceEmpleado.buscarEmpleadoId(id);
		/*enviamos el objeto con la data llena en el modelo*/
		modelo.addAttribute("Eempleado", empleadoTemp);
		
		return "formularioEmpleadoEditar";
	}
	
	//El id es para saber cual es el empleado a editar
		@GetMapping(path= "/formularioEmpresaEditar/{id}")
		public String formularioEmpresaEditar(Model modelo, @PathVariable Long id){
			
			EntityEmpresa empresaTemp= serviceEmpresa.buscarEmpresaId(id);
			/*enviamos el objeto con la data llena en el modelo*/
			modelo.addAttribute("Eempresa", empresaTemp);
			
			return "formularioEmpresaEditar";
		}
		
		//El id es para saber cual es el empleado a editar
		@GetMapping(path= "/formularioMovimientoEditar/{id}")
		public String formularioMovimientoEditar(Model modelo, @PathVariable Long id){
					
			EntityMovimientoDinero movimientoTemp= serviceMovimientoDinero.buscarMovimientoId(id);
			/*enviamos el objeto con la data llena en el modelo*/
			modelo.addAttribute("Emovimiento", movimientoTemp);
					
			return "formularioMovimientoEditar";
		}




	//pauuuuu-------------------------------------------------------------------------------
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


