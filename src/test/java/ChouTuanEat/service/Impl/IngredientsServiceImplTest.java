package ChouTuanEat.service.Impl;

import ChouTuanEat.entity.Ingredients;
import ChouTuanEat.usecase.IngredientsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IngredientsServiceImplTest {

    @Autowired
    private IngredientsService ingredientsService;

    @Test
    public void saveOrUpdateAndGetIngredientByIDTest() {
        Ingredients ingredients = new Ingredients();
        ingredients.setIngredientsName("aaa");

        ingredientsService.saveOrUpdate(ingredients);

        Ingredients ingredientByID = ingredientsService.getIngredientByID(ingredients.getId());

        Assert.assertEquals(ingredients.getIngredientsName(), ingredientByID.getIngredientsName());
    }

    @Test
    public void deleteIngredientsByIDAndGetAllIngredientsTest() {
        List<Ingredients> allIngredients = ingredientsService.getAllIngredients();

        for (Ingredients ingredients : allIngredients) {
            ingredientsService.deleteIngredientsByID(ingredients.getId());
        }

        Assert.assertEquals(0, ingredientsService.getAllIngredients().size());
    }


}
