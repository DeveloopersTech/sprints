package co.com.project.crud.techadmin.model;

import org.springframework.stereotype.Service;

import lombok.*;


@Getter @Setter
public class MovimientoDinero {
    private double monto;
    private String modificarConcepto;
    private String usuario;



    //Modificar Monto
    public void consignar(int cantidad)

    {
        this.monto = this.monto + cantidad;
    }

}
