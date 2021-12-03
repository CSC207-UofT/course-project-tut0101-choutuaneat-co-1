package ChouTuanEat.Co.controller;

import ChouTuanEat.Co.entity.Ingredients;
import ChouTuanEat.Co.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class IngredientsController {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    /**
     * Add ingredients to the database.
     * @param ingredients The ingredients that will be added to the database.
     * @return the ingredients that were added to the database.
     */
    @PostMapping("/ingredients")
    public Ingredients addIngredients(@RequestBody Ingredients ingredients) {
        ingredientsRepository.save(ingredients);
        return ingredients;
    }

    /**
     * Get ingreidients that to be queried, it can be queried by ID and list query.
     * @param id The ID of ingredients.
     * @return ingredients that are qualified.
     */
    @GetMapping(value = {"/ingredients", "/ingredients/{id}"})
    public List<Ingredients> getIngredients(@PathVariable(value = "id", required = false) Long id) {
        if (id != null) {
            return Collections.singletonList(ingredientsRepository.findById(id).orElse(null));
        }
        return ingredientsRepository.findAll();
    }

    /**
     * Delete ingredients by ingredients' ID
     * @param id The ID of ingredients that will be deleted.
     * @return the information of the ingredients that were deleted.
     */
    @DeleteMapping(value = { "/ingredients/{id}"})
    public Ingredients deleteIngredients(@PathVariable(value = "id") Long id) {
        Ingredients ingredients = ingredientsRepository.findById(id).orElse(null);
        if (ingredients != null) {
            ingredientsRepository.deleteById(id);
        }
        return ingredients;
    }

}
