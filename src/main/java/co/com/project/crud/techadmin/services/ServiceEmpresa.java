package co.com.project.crud.techadmin.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import co.com.project.crud.techadmin.model.Empresa;
import co.com.project.crud.techadmin.model.Empresa;

@Service
public class ServiceEmpresa {

    ArrayList<Empresa> lista= new ArrayList();
	
    public ArrayList<Empresa> listarEmpresas(){
        return lista;
    }

    public Empresa verEmpresa(int id) {
        Empresa empresa = null;
        for(Empresa i:lista) {
            if (i.getId() == id) {
                return i;
            }
        }
        return empresa;
    }

    public boolean agregarEmpresa(Empresa empresa) {
        Empresa enterprise = new Empresa();
        enterprise.setId(empresa.getId());
        enterprise.setNombre(empresa.getNombre());
        enterprise.setDireccion(empresa.getDireccion());
        enterprise.setTelefono(empresa.getTelefono());
        enterprise.setNit(empresa.getNit());
        lista.add(enterprise);

        return true;
    }

    public boolean actualizarEmpresa(int id, Empresa modificacion){

    	for(Empresa i:lista) {
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

    public Boolean eliminarEmpresa(int id) {
    	
        for(Empresa i:lista) {
            if (i.getId() == id) {
                lista.remove(i);
              return true; 
            }
        }
        return false;
    }
}
