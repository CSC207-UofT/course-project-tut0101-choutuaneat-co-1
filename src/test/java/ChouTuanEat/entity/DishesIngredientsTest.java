package ChouTuanEat.entity;

import ChouTuanEat.Co.entity.DishesIngredients;
import org.junit.Assert;
import org.junit.Test;

public class DishesIngredientsTest {

    @Test
    public void ingredientsIDGetterSetterTest() {
        DishesIngredients dishesIngredients = new DishesIngredients();

        dishesIngredients.setIngredientsId(2L);
        Assert.assertEquals(Long.valueOf(2), dishesIngredients.getIngredientsId());
    }

    @Test
    public void dishesIDGetterSetterTest() {
        DishesIngredients dishesIngredients = new DishesIngredients();

        dishesIngredients.setDishesId(100L);
        Assert.assertEquals(Long.valueOf(100), dishesIngredients.getDishesId());
    }

    @Test
    public void weightGetterSetterTest() {
        DishesIngredients dishesIngredients = new DishesIngredients();


        dishesIngredients.setWeight(200.0);
        Assert.assertEquals(200, dishesIngredients.getWeight(), 0.0001);
    }
}
