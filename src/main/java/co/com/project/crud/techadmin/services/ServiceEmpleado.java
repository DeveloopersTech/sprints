package co.com.project.crud.techadmin.services;

import co.com.project.crud.techadmin.model.Empleado;
import co.com.project.crud.techadmin.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceEmpleado {

	/*ArrayList<Empleado> lista= new ArrayList();*/

    //Primer instanciamos el repositorio
    private EmpleadoRepository repository;
    public ServiceEmpleado(EmpleadoRepository repository){
        this.repository = repository
    }

    public List<Empleado> listarEmpleados(){
        return this.repository.findAll();
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

    public boolean actualizarEmpleado(int id, Empleado modificacion){

    	for(Empleado i:lista) {
            if (i.getId() == id) {
            	
            	lista.remove(i);
            	lista.add(modificacion);
            	
            	/*
            	if (i.getNombre() != modificacion.getNombre()) {
            	   i.setNombre(modificacion.getNombre());
            	}
            	if(i.getCorreo() != modificacion.getCorreo()) {
            	}
            	if(i.getEmpresaAPertenecer() != modificacion.getEmpresaAPertenecer()) {
            		i.setEmpresaAPertenecer(modificacion.getEmpresaAPertenecer());
            	}
            	if(i.getRol() != modificacion.getRol()) {
            		i.setRol(modificacion.getRol());
            	}
            	return true;
            	*/
            	return true;
            }
        }
    	return false;
    }

    public Boolean eliminarEmpleado(int id) {
    	
        for(Empleado i:lista) {
            if (i.getId() == id) {
                lista.remove(i);
                return true;
            }
        }
        return false;
    }
}
