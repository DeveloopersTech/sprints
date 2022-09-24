package co.com.project.crud.techadmin.model;

import org.springframework.stereotype.Service;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Empleado")

@Getter @Setter
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name="nombre")
	private String nombre;
	@Column(name="correo")
	private String correo;
	@Column(name="empresaAPertenecer")
	private String empresaAPertenecer;
	@Column(name="rol")
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
