package ChouTuanEat.service;
import ChouTuanEat.entity.Dishes;
import ChouTuanEat.entity.CookMethods;
import ChouTuanEat.entity.User;

import java.util.List;

public interface DishesService {
    Long getId();

    CookMethods getCookingMethod();

    String getDishName();

    String getInstructions();

    double getTotalCalories();

    Dishes getDishByDishID(Long id);

    List<Dishes> getDishByDishName(String name);

    List<Dishes> getAllDishes();

    void assembleDishes(Dishes dish);

    void saveOrUpdate(Dishes dish);

    void deleteDishesByID(Long id);
}
