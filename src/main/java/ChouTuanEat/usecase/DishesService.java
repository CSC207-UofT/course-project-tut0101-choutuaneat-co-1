package ChouTuanEat.usecase;
import ChouTuanEat.entity.Dishes;

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

    void assembleDishes(Dishes dishes);

    void saveOrUpdate(Dishes dishes);

    void deleteDishesByID(Long id);
}
