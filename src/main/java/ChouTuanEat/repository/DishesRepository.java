package ChouTuanEat.repository;

import ChouTuanEat.entity.Dishes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishesRepository extends JpaRepository<Dishes, Long> {

    @Query(value = "select * from dishes as d where dish_name like %?1%", nativeQuery = true)
    public List<Dishes> findAllLikeDishName(String dishName);

}
