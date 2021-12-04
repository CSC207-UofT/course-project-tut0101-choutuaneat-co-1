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

    /**
     * 根据ID查找对应的dishes
     * @param id 菜品ID
     * @return dishes
     */
    Dishes getDishByDishID(Long id);

    /**
     * 根据name模糊查找dishes
     * @param name dishes name
     * @return 符合的dishes
     */
    List<Dishes> getDishByDishName(String name);

    /**
     * 获取所有的dishes
     * @return 所有的dishes
     */
    List<Dishes> getAllDishes();

    /**
     * Assemble different ingredients into one dish.
     * @param dish Dishes to be assembled.
     */
    void assembleDishes(Dishes dish);

    /**
     * 保存dishes，如果dishes已存在，则更新
     * @param dish dishes
     */
    void saveOrUpdate(Dishes dish);

    /**
     * 按照dishes id 删除 dishes
     * @param id dishes id
     */
    void deleteDishesByID(Long id);
}
