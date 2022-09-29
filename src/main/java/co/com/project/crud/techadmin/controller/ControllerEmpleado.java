package co.com.project.crud.techadmin.controller;

import co.com.project.crud.techadmin.model.Empleado;
import co.com.project.crud.techadmin.repository.EntityEmpleado;
import co.com.project.crud.techadmin.services.ServiceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;


@RestController
@RequestMapping("/empleado")
public class ControllerEmpleado {
        @Autowired
		ServiceEmpleado serviceEmpleado;


	   @GetMapping(path= "/lista", produces= MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Object> listarTodo(){
		  return new ResponseEntity<Object>(serviceEmpleado.listarEmpleados(), HttpStatus.OK);
	   }
/*
	   @PostMapping(path = "/registrar", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Boolean> registrar(@RequestBody EntityEmpleado empleado){
		       
		   return new ResponseEntity<Boolean>(serviceEmpleado.insertarEmpleado(empleado), HttpStatus.OK);      
	   }*/
	   
	   //Recibimos la data que nos envia el Model desde el formulario en nuestro path /registrar
	   //el Model va a generar la comunicacion entre la vista(los html) y este backend
		/*el ModelAttribute se encargara de que todo lo que viaje en el form sea englobado y que sea del mismo
	      tipo al modelo entidad*/
		//el Metodo de tipo RedirectView lo que hará es enviarnos a una vista cuando el proceso POST de succes
		@PostMapping(path= "/registrar")
		public RedirectView formularioEmpleado(@ModelAttribute EntityEmpleado empleado, Model modelo){

			//con la instancia new le entragamos al frontend el modelo de empleado vacio:
			modelo.addAttribute("nuevoEmpleado", empleado);
			//entonces si es true la insercion del empleado a la DB nos redireccionara a la pagina /empleado
			if(serviceEmpleado.insertarEmpleado(empleado).equals(Boolean.TRUE)){
				return new RedirectView("/empleado");
			}else{
				return new RedirectView("/404");//HAY QUE HACER ESTA PÁGINA DE ERROS
			}

		}
	   
	   
	   @PatchMapping(path="/actualizarEmpleado/modificacion")
	    public RedirectView actualizarEmpleadoParcial(@ModelAttribute EntityEmpleado empleado, Model modelo){

		   
		 //con la instancia new le entragamos al frontend el modelo de empleado vacio:
			modelo.addAttribute("Nueempleado", empleado);
			//entonces si es true la insercion del empleado a la DB nos redireccionara a la pagina /empleado
			if(serviceEmpleado.actualizarParcialEmpleado(empleado).equals(Boolean.TRUE)){
				return new RedirectView("/empleado");
			}else{
				return new RedirectView("/404");//HAY QUE HACER ESTA PÁGINA DE ERROS
			}
		}
	   
	   
	   
	   @PutMapping(path="/actualizarEmpleado")
	    public RedirectView actualizarEmpleado(@ModelAttribute EntityEmpleado empleado, Model modelo){

		   
		 //con la instancia new le entragamos al frontend el modelo de empleado vacio:
			modelo.addAttribute(empleado);
			//entonces si es true la insercion del empleado a la DB nos redireccionara a la pagina /empleado
			if(serviceEmpleado.actualizarEmpleado(empleado).equals(Boolean.TRUE)){
				return new RedirectView("/empleado");
			}else{
				return new RedirectView("/404");//HAY QUE HACER ESTA PÁGINA DE ERROS
			}
		}
	   
	   @DeleteMapping(path= "/eliminar/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	    public RedirectView eliminarEmpleado(@PathVariable Long id){
		  
		   
		   if(serviceEmpleado.borrarEmpleado(id).equals(Boolean.TRUE)){
				return new RedirectView("/empleado");
			}else{
				return new RedirectView("/404");//HAY QUE HACER ESTA PÁGINA DE ERROS
			}
		   
	   }
	   
	   /*
	   
	    @GetMapping(path="/{id}", produces="application/json")
	    public ResponseEntity verEmpleado(@PathVariable int id){
	        
	        Empleado empleado= serviceEmpleado.verEmpleado(id);
	        
	        if (empleado != null) {
	           
	        	return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
	        }
			return new ResponseEntity("No existe el empleado", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
	   
	    @PostMapping(path = "/registrar", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Empleado> registrar(@RequestBody Empleado persona){
	        
	    	boolean salida= serviceEmpleado.agregarEmpleado(persona);
	        
	        if(salida) {
	          
	        	return new ResponseEntity<Empleado>(persona,HttpStatus.OK);
	        }else {
	        
	        	return new ResponseEntity("no se ha podido agregar a este empleado", HttpStatus.INTERNAL_SERVER_ERROR);
	        }	
	    }

    
	    @PatchMapping(path="/actualizarEmpleado/{id}/modificacion", produces= MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable int id, @RequestBody Empleado modificacion){

	    	boolean salida = serviceEmpleado.actualizarEmpleado(id, modificacion);
	    	
	    	if(salida != false) {
	    	
	    		return new ResponseEntity("Empleado actualizado", HttpStatus.OK);
	    	}else {
	    	
	    		return new ResponseEntity("No fue posible actualizar el empleado", HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    }
	    

	    @DeleteMapping(path= "/eliminar/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Empleado> eliminarUsuario(@PathVariable int id){
	        
	    	boolean salida= serviceEmpleado.eliminarEmpleado(id);
	    	if(salida != false) {
	        return new ResponseEntity("empleado eliminado", HttpStatus.OK);
	    	}
	    	return new ResponseEntity("usuario no encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
	    */

}
