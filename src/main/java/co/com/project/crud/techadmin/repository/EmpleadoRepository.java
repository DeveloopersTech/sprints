
package co.com.project.crud.techadmin.repository;

import co.com.project.crud.techadmin.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {


}
