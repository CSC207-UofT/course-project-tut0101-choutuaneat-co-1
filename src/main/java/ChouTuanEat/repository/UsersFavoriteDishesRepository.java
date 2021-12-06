package ChouTuanEat.repository;

import ChouTuanEat.entity.UserFavoriteDishes;
import ChouTuanEat.entity.UsersDishesPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersFavoriteDishesRepository extends JpaRepository<UserFavoriteDishes, UsersDishesPrimaryKey> {
    @Query(value = "select * from users_dishes where users_id = ?1", nativeQuery = true)
    List<UserFavoriteDishes> findAllFavoriteDishByUserId(Long id);

    @Query(value = "delete from users_dishes where dishes_id = ?1", nativeQuery = true)
    void deleteAllByDishesId(Long id);
}
