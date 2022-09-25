package co.com.project.crud.techadmin.controller;

import co.com.project.crud.techadmin.model.Empleado;
import co.com.project.crud.techadmin.repository.EntityEmpleado;
import co.com.project.crud.techadmin.services.ServiceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	   @PostMapping(path = "/registrar", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Boolean> registrar(@RequestBody EntityEmpleado empleado){
		       
		   return new ResponseEntity<Boolean>(serviceEmpleado.insertarEmpleado(empleado), HttpStatus.OK);      
	   }
	   
	   @PatchMapping(path="/actualizarEmpleado/modificacion", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Boolean> actualizarEmpleado(@RequestBody EntityEmpleado empleado){

		   return new ResponseEntity<Boolean>(serviceEmpleado.actualizarParcialEmpleado(empleado), HttpStatus.OK);
	   }
	   
	   @DeleteMapping(path= "/eliminar/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	    public void eliminarEmpleado(@PathVariable Long id){
		   
		   serviceEmpleado.borrarEmpleado(id);
		   
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
