package ChouTuanEat.Co.repository;

import ChouTuanEat.Co.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public Optional<User>  findByUsername(String username);
}
