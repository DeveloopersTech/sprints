package co.com.project.crud.techadmin.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="MovimientoDinero")
@Getter @Setter
public class EntityMovimientoDinero {

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
