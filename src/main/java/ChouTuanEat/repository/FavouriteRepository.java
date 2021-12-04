package ChouTuanEat.repository;

import ChouTuanEat.entity.favourites;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

public interface FavouriteRepository extends CrudRepository<favourites, Long>{
    @Query("SELECT u FROM favourites u WHERE u.userId = ?1")
    public Optional<favourites> findByUserId(Long id);
}
