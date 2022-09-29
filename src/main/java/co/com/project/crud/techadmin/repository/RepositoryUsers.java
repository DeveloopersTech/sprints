package co.com.project.crud.techadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsers extends JpaRepository<EntityUser, Long> {
    EntityUser findByEmail(String email);
}