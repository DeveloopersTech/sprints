package co.com.project.crud.techadmin.controller;

import co.com.project.crud.techadmin.model.MovimientoDinero;
import co.com.project.crud.techadmin.model.MovimientoDinero;
import co.com.project.crud.techadmin.services.ServiceMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/enterprises")

public class ControllerMovimientoDinero {

    @Autowired
    ServiceMovimientoDinero serviceMovimientoDinero;

    @GetMapping(path="/{id}/movements", produces="application/json")
    public ResponseEntity <MovimientoDinero> verMovimientoDinero(@PathVariable int id, @RequestBody MovimientoDinero movements){

        MovimientoDinero movimiento= serviceMovimientoDinero.verMovimientoDinero(id, movements);

        if (movimiento != null) {

            return new ResponseEntity<MovimientoDinero>(movimiento, HttpStatus.OK);
        }
        return new ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping(path="/{id}/movements", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovimientoDinero> registrar(@PathVariable int id, @RequestBody MovimientoDinero movements){

        boolean salida= serviceMovimientoDinero.agregarMovimientoDinero(id, movements);

        if(salida) {

            return new ResponseEntity<MovimientoDinero>(movements, HttpStatus.OK);
        }else {

            return new ResponseEntity("no se ha podido agregar a este movimiento", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @PatchMapping(path="/{id}/movements", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovimientoDinero> actualizarMovimientoDinero(@PathVariable int id, @RequestBody MovimientoDinero movements){

        boolean salida = serviceMovimientoDinero.actualizarMovimientoDinero(id, movements);

        if(salida) {

            return new ResponseEntity("MovimientoDinero actualizado", HttpStatus.OK);
        }else {

            return new ResponseEntity("No fue posible actualizar el movimiento", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}/movements")
    public ResponseEntity<MovimientoDinero> eliminarUsuario(@PathVariable int id, @RequestBody MovimientoDinero movements){
        serviceMovimientoDinero.eliminarMovimientoDinero(id, movements);

        return new ResponseEntity("movimiento eliminado", HttpStatus.OK);
    }


}
