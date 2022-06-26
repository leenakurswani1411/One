package majorProject.one.UserService.repo;

import majorProject.one.UserService.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

    Optional<User> findByUsername(String username);
}


