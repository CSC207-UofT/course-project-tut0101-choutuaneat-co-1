package ChouTuanEat.repository;

import ChouTuanEat.entity.favourites;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

public interface FavouriteRepository extends CrudRepository<favourites, Long>{
}
