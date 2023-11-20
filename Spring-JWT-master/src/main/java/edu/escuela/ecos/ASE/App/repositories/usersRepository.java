package edu.escuela.ecos.ASE.App.repositories;



import edu.escuela.ecos.ASE.App.models.users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface usersRepository extends CrudRepository<users,Long> {
    users findByUsernameAndPasswords(String username, String passwords);

}
