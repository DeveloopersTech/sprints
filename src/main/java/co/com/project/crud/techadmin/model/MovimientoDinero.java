package co.com.project.crud.techadmin.model;

import lombok.Data;
//@Getter @Setter
@Data public class MovimientoDinero {
    private double monto;
    private String modificarConcepto;
    private String usuario;

    public MovimientoDinero(String usuario)
    {
        this.usuario = usuario;
    }

    //Modificar Monto
    public void consignar(int cantidad)

    {
    	this.monto = this.monto + cantidad;
    }

}
