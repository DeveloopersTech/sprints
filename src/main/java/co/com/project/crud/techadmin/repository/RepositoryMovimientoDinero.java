package co.com.project.crud.techadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMovimientoDinero extends JpaRepository<EntityMovimientoDinero, Long> {
}
