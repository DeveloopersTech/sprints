package co.com.project.crud.techadmin.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Empresa")
@Getter @Setter
public class EntityEmpresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="nombre")
	private String nombre;

	@Column(name="telefono")
	private String telefono;

	@Column(name="direccion")
	private String direccion;

	@Column(name="nit")
	private int nit;

	public EntityEmpresa() {
	}
}

