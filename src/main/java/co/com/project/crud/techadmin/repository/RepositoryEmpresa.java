package co.com.project.crud.techadmin.repository;

import co.com.project.crud.techadmin.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmpresa extends JpaRepository<EntityEmpresa, Long> {


}
