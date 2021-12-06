package ChouTuanEat.entity;

import org.junit.Assert;
import org.junit.Test;

public class IngredientsTest {

    @Test
    public void WeightGetterAndSetterTest() {
        Ingredients ingredients = new Ingredients();

        ingredients.setWeight(1);
        Assert.assertEquals(1, ingredients.getWeight(), 0.001);
    }

    @Test
    public void ingredientsNameGetterAndSetterTest() {
        Ingredients ingredients = new Ingredients();

        ingredients.setIngredientsName("aaa");
        Assert.assertEquals("aaa", ingredients.getIngredientsName());
    }

    @Test
    public void caloriesPerGramGetterAndSetterTest() {
        Ingredients ingredients = new Ingredients();

        ingredients.setCaloriesPerGram(100);
        Assert.assertEquals(100, ingredients.getCaloriesPerGram(), 0.001);
    }

    @Test
    public void dishesIDGetterAndSetterTest() {
        Ingredients ingredients = new Ingredients();

        ingredients.setDishesId(1L);
        Assert.assertEquals(Long.valueOf(1), ingredients.getDishesId());
    }

    @Test
    public void idGetterAndSetterTest() {
        Ingredients ingredients = new Ingredients();

        ingredients.setId(2L);
        Assert.assertEquals(Long.valueOf(2), ingredients.getId());
    }

}
