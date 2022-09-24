package co.com.project.crud.techadmin.model;

import org.springframework.stereotype.Service;

import lombok.*;


@Getter @Setter
public class Empresa {

	private int id;
	private String nombre;
	private String telefono;
	private String direccion;
	private int nit;
}
