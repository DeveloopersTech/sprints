package co.com.project.crud.techadmin.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter @Setter
public class EntityUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="email", unique = true)
    private String email;
    @Column(name="image")
    private String image;
    @Column(name="auth0Id", unique = true)
    private String auth0Id;

    public EntityUser(String email, String image, String auth0Id) {
        this.email = email;
        this.image = image;
        this.auth0Id = auth0Id;
    }

    public EntityUser() {
    }
}
