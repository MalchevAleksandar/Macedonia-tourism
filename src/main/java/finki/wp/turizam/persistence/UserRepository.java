package finki.wp.turizam.persistence;

import finki.wp.turizam.model.jpa.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Aleksandar on 21.06.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);
}
