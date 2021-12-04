package ChouTuanEat.entity;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class DishesTest {

    @Test
    public void dishNameGetterAndSetterTest() {
        Dishes dishes = new Dishes();

        dishes.setDishName("aaa");
        Assert.assertEquals("aaa", dishes.getDishName());
    }

    @Test
    public void totalCaloriesGetterAndSetterTest() {
        Dishes dishes = new Dishes();

        dishes.setTotalCalories(111);
        Assert.assertEquals(111, dishes.getTotalCalories(), 0.001);
    }

    @Test
    public void idGetterAndSetterTest() {
        Dishes dishes = new Dishes();

        dishes.setId(1L);
        Assert.assertEquals(Long.valueOf(1), dishes.getId());
    }

    @Test
    public void instructionsGetterAndSetterTest() {
        Dishes dishes = new Dishes();

        dishes.setInstructions("aaaaaa");
        Assert.assertEquals("aaaaaa", dishes.getInstructions());
    }

    @Test
    public void ingredientsListGetterAndSetterTest() {
        Dishes dishes = new Dishes();
        Ingredients ingredients1 = new Ingredients();

        dishes.setIngredientsList(Collections.singletonList(ingredients1));
        Assert.assertEquals(Collections.singletonList(ingredients1), dishes.getIngredientsList());
    }

    @Test
    public void dishesIngredientsListGetterAndSetterTest() {
        Dishes dishes = new Dishes();
        DishesIngredients dishesIngredients1 = new DishesIngredients();

        dishes.setDishesIngredientsList(Collections.singletonList(dishesIngredients1));
        Assert.assertEquals(Collections.singletonList(dishesIngredients1), dishes.getDishesIngredientsList());
    }
}
