package co.com.project.crud.techadmin.services;

import co.com.project.crud.techadmin.repository.RepositoryUsers;
import co.com.project.crud.techadmin.repository.EntityUser;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ServiceUser {

    private RepositoryUsers repositoryUsers;

    public ServiceUser(RepositoryUsers repositoryUsers) {
        this.repositoryUsers = repositoryUsers;
    }

    //Crear usuario nuevo en la BD
    public EntityUser createUser(EntityUser newUser){
        return this.repositoryUsers.save(newUser);
    }

    //Buscar Usuario registrado por email
    public EntityUser findUserByEmail(String email){
        return this.repositoryUsers.findByEmail(email);
    }

    //Crear usuario nuevo en la BD
    public EntityUser getOrCreateUser(Map<String, Object> userData){
        String email = (String) userData.get("email");

        EntityUser user = findUserByEmail(email);
        if(user == null){
            String image = (String) userData.get("picture");
            String auth0Id = (String) userData.get("sub");
            EntityUser newUser = new EntityUser(email=email,image=image,auth0Id=auth0Id);
            return createUser(newUser);
        }
        System.out.println(user.getEmail());
        return user;
    }





}
