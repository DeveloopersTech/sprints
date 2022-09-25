package co.com.project.crud.techadmin.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="movimientodinero")
@Getter @Setter
public class EntityMovimientoDinero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="monto")
    private Double monto;

    @Column(name="modificarConcepto")
    private String modificarConcepto;

    @Column(name="empleado")
    private String empleado;

    public EntityMovimientoDinero() {
    }
}
