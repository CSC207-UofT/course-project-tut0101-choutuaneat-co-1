package ChouTuanEat.controller;

import ChouTuanEat.entity.Ingredients;
import ChouTuanEat.service.IngredientsService;
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

    @ResponseBody
    @PostMapping("/ingredients")
    public Ingredients addIngredients(@RequestBody Ingredients ingredients) {
        ingredientsService.saveOrUpdate(ingredients);
        return ingredients;
    }

    @ResponseBody
    @GetMapping(value = {"/ingredients", "/ingredients/{id}"})
    public List<Ingredients> getIngredients(@PathVariable(value = "id", required = false) Long id) {
        if (id != null) {
            return Collections.singletonList(ingredientsService.getIngredientByID(id));
        }
        return ingredientsService.getAllIngredients();
    }

    @ResponseBody
    @DeleteMapping(value = { "/ingredients/{id}"})
    public Ingredients deleteIngredients(@PathVariable(value = "id") Long id) {
        Ingredients ingredients = ingredientsService.getIngredientByID(id);
        ingredientsService.deleteIngredientsByID(id);
        return ingredients;
    }

}
