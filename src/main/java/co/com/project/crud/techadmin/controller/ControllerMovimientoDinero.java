package co.com.project.crud.techadmin.controller;


import co.com.project.crud.techadmin.model.MovimientoDinero;
import co.com.project.crud.techadmin.repository.EntityEmpleado;
import co.com.project.crud.techadmin.repository.EntityEmpresa;
import co.com.project.crud.techadmin.repository.EntityMovimientoDinero;
import co.com.project.crud.techadmin.services.ServiceMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@RequestMapping("/movimiento")
public class ControllerMovimientoDinero {
    @Autowired
    ServiceMovimientoDinero serviceMovimientoDinero;


    @GetMapping(path= "/lista", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTodo(){
        return new ResponseEntity<Object>(serviceMovimientoDinero.listarMovimientoDinero(), HttpStatus.OK);
    }

    /*@PostMapping(path = "/registrar", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> registrar(@RequestBody EntityMovimientoDinero movimientoDinero){

        return new ResponseEntity<Boolean>(serviceMovimientoDinero.insertarMovimientoDinero(movimientoDinero), HttpStatus.OK);
    }*/

    @PatchMapping(path="/actualizarMovimientoDinero/modificacion", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> actualizarMovimientoDinero(@RequestBody EntityMovimientoDinero movimientoDinero){

        return new ResponseEntity<Boolean>(serviceMovimientoDinero.actualizarParcialMovimientoDinero(movimientoDinero), HttpStatus.OK);
    }

    
  //Recibimos la data que nos envia el Model desde el formulario en nuestro path /registrar
	   //el Model va a generar la comunicacion entre la vista(los html) y este backend
		/*el ModelAttribute se encargara de que todo lo que viaje en el form sea englobado y que sea del mismo
	      tipo al modelo entidad*/
		//el Metodo de tipo RedirectView lo que hará es enviarnos a una vista cuando el proceso POST de succes
		@PostMapping(path= "/registrar")
		public RedirectView formularioMovimiento(@ModelAttribute EntityMovimientoDinero movimiento, Model modelo){

			//con la instancia new le entragamos al frontend el modelo de movimiento dinero vacio:
			modelo.addAttribute("nuevoMovimiento", movimiento);
			//entonces si es true la insercion del empleado a la DB nos redireccionara a la pagina /empleado
			if(serviceMovimientoDinero.insertarMovimientoDinero(movimiento).equals(Boolean.TRUE)){
				return new RedirectView("/movimiento");
			}else{
				return new RedirectView("/404");//HAY QUE HACER ESTA PÁGINA DE ERROS
			}
		}
		
		
		@PutMapping(path="/actualizarMovimiento")
		   public RedirectView actualizarMovimiento(@ModelAttribute EntityMovimientoDinero movimiento, Model modelo){

			   
			 //con la instancia new le entragamos al frontend el modelo de empleado vacio:
				modelo.addAttribute(movimiento);
				//entonces si es true la insercion del empleado a la DB nos redireccionara a la pagina /empleado
				if(serviceMovimientoDinero.actualizarMovimientoDinero(movimiento).equals(Boolean.TRUE)){
					return new RedirectView("/movimiento");
				}else{
					return new RedirectView("/404");//HAY QUE HACER ESTA PÁGINA DE ERROS
				}
		}
		
		@DeleteMapping(path= "/eliminar/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
		   public RedirectView eliminarEmpresa(@PathVariable Long id){
			  
			   
			   if(serviceMovimientoDinero.borrarMovimientoDinero(id).equals(Boolean.TRUE)){
					return new RedirectView("/movimiento");
				}else{
					return new RedirectView("/404");//HAY QUE HACER ESTA PÁGINA DE ERROS
				}   
		  }
		
		
}
