package co.com.project.crud.techadmin.model;

import org.springframework.stereotype.Service;

import lombok.*;

@Getter @Setter
public class Empleado {

	private String nombre;
	private int id;
	private String correo;
	private String empresaAPertenecer;
	private String rol;


	public Empleado(String nombre, String correo, String empresaAPertenecer, String rol) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.empresaAPertenecer = empresaAPertenecer;
		this.rol = rol;
	}


	public Empleado() {

	}
}
