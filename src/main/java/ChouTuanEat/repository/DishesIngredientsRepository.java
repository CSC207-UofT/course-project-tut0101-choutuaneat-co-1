package ChouTuanEat.repository;

import ChouTuanEat.entity.DishesIngredients;
import ChouTuanEat.entity.DishesIngredientsPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DishesIngredientsRepository extends JpaRepository<DishesIngredients, DishesIngredientsPrimaryKey> {

    @Query(value = "select * from dishes_ingredients where dishes_id = ?1", nativeQuery = true)
    List<DishesIngredients> findAllByDishesId(Long id);

    @Query(value = "delete from dishes_ingredients where dishes_id = ?1", nativeQuery = true)
    void deleteAllByDishesId(Long id);

}
