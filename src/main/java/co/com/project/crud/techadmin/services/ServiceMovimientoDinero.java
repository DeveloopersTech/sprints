package co.com.project.crud.techadmin.services;

import co.com.project.crud.techadmin.repository.EntityMovimientoDinero;
import co.com.project.crud.techadmin.repository.RepositoryMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.project.crud.techadmin.model.MovimientoDinero;

import java.util.List;
@Service
public class ServiceMovimientoDinero {
    @Autowired
    RepositoryMovimientoDinero repositoryMovimientoDinero;

    public List<EntityMovimientoDinero> listarMovimientoDinero(){
        List<EntityMovimientoDinero> List = repositoryMovimientoDinero.findAll();
        return List;

    }

    public Boolean insertarMovimientoDinero(EntityMovimientoDinero movimientoDinero) {

        try {
            repositoryMovimientoDinero.save(movimientoDinero);
        }catch(Exception e) {
            return false;
        }

        return true;
    }

    //actualización parcial PATCH:
    public Boolean actualizarParcialMovimientoDinero(EntityMovimientoDinero movimientoDinero) {

        try {
            EntityMovimientoDinero movimientoDineroTemp= repositoryMovimientoDinero.findById(movimientoDinero.getId()).orElse(null);

            if(movimientoDinero.getMonto() != null) {
                movimientoDineroTemp.setMonto(movimientoDinero.getMonto());

            }
            if(movimientoDinero.getModificarConcepto() != null) {

                movimientoDineroTemp.setModificarConcepto(movimientoDinero.getModificarConcepto());

            }
            if(movimientoDinero.getEmpleado() != null){

                movimientoDineroTemp.setEmpleado(movimientoDinero.getEmpleado());
            }

            repositoryMovimientoDinero.save(movimientoDineroTemp);

        }catch(Exception e) {
            return false;
        }

        return true;

    }


    //Delete movimientoDinero:
    public void borrarMovimientoDinero(Long id) {

        repositoryMovimientoDinero.deleteById(id);
    }




}
