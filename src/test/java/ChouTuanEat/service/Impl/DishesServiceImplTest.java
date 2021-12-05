package ChouTuanEat.service.Impl;

import ChouTuanEat.entity.Dishes;
import ChouTuanEat.usecase.DishesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DishesServiceImplTest {

    @Autowired
    private DishesService dishesService;

    @Test
    public void addDishesAndGetDishByDishIDTest() {
        Dishes dishes = new Dishes();
        dishes.setDishName("aaa");

        dishesService.saveOrUpdate(dishes);

        Assert.assertEquals(dishes.getDishName(), dishesService.getDishByDishID(dishes.getId()).getDishName());
    }

    @Test
    public void getAllDishesAndDeleteDishesByIdTest() {
        List<Dishes> allDishes = dishesService.getAllDishes();
        for (Dishes dishes : allDishes) {
            dishesService.deleteDishesByID(dishes.getId());
        }

        Assert.assertEquals(0, dishesService.getAllDishes().size());
    }

}
