package co.com.project.crud.techadmin.model;

import org.springframework.stereotype.Service;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="MovimientoDinero")
@Getter @Setter
public class MovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="monto")
    private double monto;

    @Column(name="modificarConcepto")
    private String modificarConcepto;

    @Column(name="usuario")
    private String usuario;



    //Modificar Monto
    public void consignar(int cantidad)

    {
    	this.monto = this.monto + cantidad;
    }

}
