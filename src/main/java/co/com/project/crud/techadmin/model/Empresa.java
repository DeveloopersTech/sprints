package co.com.project.crud.techadmin.model;

import org.springframework.stereotype.Service;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name="Empresa")
@Getter @Setter
public class Empresa{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name="nombre")
	private String nombre;

	@Column(name="telefono")
	private String telefono;

	@Column(name="direccion")
	private String direccion;

	@Column(name="nit")
	private int nit;

	public Empresa(){}
}

