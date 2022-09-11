package co.com.project.crud.techadmin.services;

import co.com.project.crud.techadmin.model.Empleado;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceEmpleado {
    
	ArrayList<Empleado> lista= new ArrayList();
	
    public ArrayList<Empleado> listarEmpleados(){
        return lista;
    }

    public Empleado verEmpleado(int id) {
        Empleado empleado = null;
        for(Empleado i:lista) {
            if (i.getId() == id) {
                return i;
            }
        }
        return empleado;
    }

    public boolean agregarEmpleado(Empleado empleado) {
        Empleado persona = new Empleado();
        persona.setId(empleado.getId());
        persona.setNombre(empleado.getNombre());
        persona.setCorreo(empleado.getCorreo());
        persona.setEmpresaAPertenecer(empleado.getEmpresaAPertenecer());
        persona.setRol(empleado.getRol());
        lista.add(persona);

        return true;
    }

    public boolean actualizarEmpleado(int id){

        return false;
    }

    public void eliminarEmpleado(int id) {
    	
        for(Empleado i:lista) {
            if (i.getId() == id) {
                lista.remove(i);
            }
        }
    }
}
