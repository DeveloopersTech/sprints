package co.com.project.crud.techadmin.controller;

import co.com.project.crud.techadmin.model.Empleado;
import co.com.project.crud.techadmin.services.ServiceEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Empleado")
public class ControllerEmpleado {
        @Autowired
		ServiceEmpleado serviceEmpleado;


	   @GetMapping(path="", produces="application/json")
	    public ResponseEntity<Empleado> listar(){

	        return serviceEmpleado.listarEmpleados();
	    }

	   
	    @GetMapping(path="/{id}", produces="application/json")
	    public ResponseEntity verEmpleado(@PathVariable int id){
	        
	        Empleado empleado= serviceEmpleado.verEmpleado(id);
	        
	        if (empleado != null) {
	           
	        	return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);
	        }
			return new ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 

	    @PostMapping(path="/registrar", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Empleado> registrar(@RequestBody Empleado empleado){
	        
	    	boolean salida= serviceEmpleado.agregarEmpleado(empleado);
	        
	        if(salida) {
	          
	        	return new ResponseEntity<Empleado>(empleado,HttpStatus.OK);
	        }else {
	        
	        	return new ResponseEntity("no se ha podido agregar a este empleado", HttpStatus.INTERNAL_SERVER_ERROR);
	        }	
	    }


	    
	    @PatchMapping(path="/editarEmpleado/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable int id){

	    	boolean salida = serviceEmpleado.actualizarEmpleado(id);
	    	
	    	if(salida) {
	    	
	    		return new ResponseEntity("Empleado actualizado", HttpStatus.OK);
	    	}else {
	    	
	    		return new ResponseEntity("No fue posible actualizar el empleado", HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    }
	    

	    @DeleteMapping("/eliminar/{id}")
	    public ResponseEntity<Empleado> eliminarUsuario(@PathVariable int id){
	        serviceEmpleado.eliminarEmpleado(id);
	        
	        return new ResponseEntity("empleado eliminado", HttpStatus.OK);
	    }

}
