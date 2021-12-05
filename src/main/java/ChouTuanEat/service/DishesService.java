package ChouTuanEat.service;
import ChouTuanEat.entity.Dishes;
import ChouTuanEat.entity.UserFavoriteDishes;

import java.util.List;

public interface DishesService {
    Long getId();

    Dishes getDishByDishID(Long id);

    List<Dishes> getDishByDishName(String name);

    List<Dishes> getAllDishes();

    List<Dishes> getFavorListByUserId(Long id);

    void assembleDishes(Dishes dish);

    void saveOrUpdate(Dishes dish);

    void saveOrUpdateFavoriteList(UserFavoriteDishes useDishIdPair);

    void deleteDishesByID(Long id);

    void deleteDishesFromFavor(UserFavoriteDishes useDishIdPair);
}
