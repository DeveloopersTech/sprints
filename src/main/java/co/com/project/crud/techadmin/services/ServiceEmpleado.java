package co.com.project.crud.techadmin.services;

import co.com.project.crud.techadmin.model.Empleado;
import co.com.project.crud.techadmin.model.MovimientoDinero;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class ServiceEmpleado {


    public ResponseEntity<Empleado> listarEmpleados() {
        return null;
    }

    public Empleado verEmpleado(int id) {
        return null;
    }

    public boolean agregarEmpleado(Empleado empleado) {

        return true;
    }

    public boolean actualizarEmpleado(int id){

        return false;
    }

    public void eliminarEmpleado(int id) {
    }
}
