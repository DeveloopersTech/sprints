package co.com.project.crud.techadmin.controller;

import java.util.ArrayList;

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

import co.com.project.crud.techadmin.model.Empresa;
import co.com.project.crud.techadmin.services.ServiceEmpresa;
import co.com.project.crud.techadmin.services.ServiceEmpresa;

@RestController
@RequestMapping("/enterprises")
public class ControllerEmpresa {
	@Autowired
	ServiceEmpresa serviceEmpresa;


   @GetMapping(path= "/lista", produces= MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Empresa> listar(){
	  
	  ArrayList<Empresa> empresa= serviceEmpresa.listarEmpresas();
	  return empresa;
   }

   
    @GetMapping(path="/{id}", produces="application/json")
    public ResponseEntity verEmpresa(@PathVariable int id){
        
        Empresa empresa= serviceEmpresa.verEmpresa(id);
        
        if (empresa != null) {
           
        	return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
        }
		return new ResponseEntity("No existe la empresa", HttpStatus.INTERNAL_SERVER_ERROR);
    }
 
   
    @PostMapping(path = "/registrar", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> registrar(@RequestBody Empresa empresa){
        
    	boolean salida= serviceEmpresa.agregarEmpresa(empresa);
        
        if(salida) {
          
        	return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);
        }else {
        
        	return new ResponseEntity("no se ha podido agregar esta empresa", HttpStatus.INTERNAL_SERVER_ERROR);
        }	
    }


    @PatchMapping(path="/actualizarEmpresa/{id}/modificacion", produces= MediaType.APPLICATION_JSON_VALUE)
    // OJOOOOOOOOOOOOOOOOOOOOOOOOOOO
    public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable int id, @RequestBody Empresa modificacion){

    	boolean salida = serviceEmpresa.actualizarEmpresa(id, modificacion);
    	
    	if(salida != false) {
    	
    		return new ResponseEntity("Empresa actualizada", HttpStatus.OK);
    	}else {
    	
    		return new ResponseEntity("No fue posible actualizar la empresa", HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    

    @DeleteMapping(path= "/eliminar/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Empresa> eliminarUsuario(@PathVariable int id){
        
    	boolean salida= serviceEmpresa.eliminarEmpresa(id);
    	if(salida != false) {
        return new ResponseEntity("empresa eliminada", HttpStatus.OK);
    	}
    	return new ResponseEntity("empresa no encontrada", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
