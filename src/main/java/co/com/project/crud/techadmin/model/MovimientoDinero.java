package co.com.project.crud.techadmin.model;

import org.springframework.stereotype.Service;

import lombok.*;


@Getter @Setter
public class MovimientoDinero {
    private int id;
    private double monto;
    private String modificarConcepto;
    private String empleado;
}
