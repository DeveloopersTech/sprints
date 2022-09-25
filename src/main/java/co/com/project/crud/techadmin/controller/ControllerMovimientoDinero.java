package co.com.project.crud.techadmin.controller;


import co.com.project.crud.techadmin.model.MovimientoDinero;
import co.com.project.crud.techadmin.repository.EntityMovimientoDinero;
import co.com.project.crud.techadmin.services.ServiceMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movimiento")
public class controllerMovimientoDinero {
    @Autowired
    ServiceMovimientoDinero serviceMovimientoDinero;


    @GetMapping(path= "/lista", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> listarTodo(){
        return new ResponseEntity<Object>(serviceMovimientoDinero.listarMovimientoDinero(), HttpStatus.OK);
    }

    @PostMapping(path = "/registrar", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> registrar(@RequestBody EntityMovimientoDinero movimientoDinero){

        return new ResponseEntity<Boolean>(serviceMovimientoDinero.insertarMovimientoDinero(movimientoDinero), HttpStatus.OK);
    }

    @PatchMapping(path="/actualizarMovimientoDinero/modificacion", produces= MediaType.APPLICATION_JSON_VALUE, consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> actualizarMovimientoDinero(@RequestBody EntityMovimientoDinero movimientoDinero){

        return new ResponseEntity<Boolean>(serviceMovimientoDinero.actualizarParcialMovimientoDinero(movimientoDinero), HttpStatus.OK);
    }

    @DeleteMapping(path= "/eliminar/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public void eliminarMovimientoDinero(@PathVariable Long id){

        serviceMovimientoDinero.borrarMovimientoDinero(id);

    }
}
