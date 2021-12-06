package ChouTuanEat.controller;

import ChouTuanEat.entity.Ingredients;
import ChouTuanEat.usecase.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;


    @GetMapping("/addIngredients")
    public String getAddIngredientPage() {
        return "ingredients";
    }

    /**
     * Add ingredients to the database.
     * @param ingredients The ingredients that will be added to the database.
     * @return the ingredients that were added to the database.
     */
    @ResponseBody
    @PostMapping("/ingredients")
    public Ingredients addIngredients(@RequestBody Ingredients ingredients) {
        ingredientsService.saveOrUpdate(ingredients);
        return ingredients;
    }

    /**
     * Get ingreidients that to be queried, it can be queried by ID and list query.
     * @param id The ID of ingredients.
     * @return ingredients that are qualified.
     */
    @ResponseBody
    @GetMapping(value = {"/ingredients", "/ingredients/{id}"})
    public List<Ingredients> getIngredients(@PathVariable(value = "id", required = false) Long id) {
        if (id != null) {
            return Collections.singletonList(ingredientsService.getIngredientByID(id));
        }
        return ingredientsService.getAllIngredients();
    }

    /**
     * Delete ingredients by ingredients' ID
     * @param id The ID of ingredients that will be deleted.
     * @return the information of the ingredients that were deleted.
     */
    @ResponseBody
    @DeleteMapping(value = { "/ingredients/{id}"})
    public Ingredients deleteIngredients(@PathVariable(value = "id") Long id) {
        Ingredients ingredients = ingredientsService.getIngredientByID(id);
        ingredientsService.deleteIngredientsByID(id);
        return ingredients;
    }

}
