package ChouTuanEat.usecase;
import ChouTuanEat.entity.Dishes;
import ChouTuanEat.entity.UserFavoriteDishes;

import java.util.List;

public interface DishesService {

    Dishes getDishByDishID(Long id);

    List<Dishes> getDishByDishName(String name);

    List<Dishes> getAllDishes();

    List<Dishes> getFavorListByUserId(Long id);

    void assembleDishes(Dishes dish);

    void saveOrUpdate(Dishes dishes);

    void saveOrUpdateFavoriteList(UserFavoriteDishes useDishIdPair);

    void deleteDishesByID(Long id);

    void deleteDishesFromFavor(UserFavoriteDishes useDishIdPair);

    Object getId();
}
