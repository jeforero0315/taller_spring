package tallerunospring.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tallerunospring.demo.models.users_model;

@Repository
public interface users_repo extends CrudRepository<users_model, Long>{
}
