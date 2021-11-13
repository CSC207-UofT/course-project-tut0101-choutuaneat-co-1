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

    @PostMapping("/ingredients")
    public Ingredients addIngredients(@RequestBody Ingredients ingredients) {
        ingredientsRepository.save(ingredients);
        return ingredients;
    }

    @GetMapping(value = {"/ingredients", "/ingredients/{id}"})
    public List<Ingredients> getIngredients(@PathVariable(value = "id", required = false) Long id) {
        if (id != null) {
            return Collections.singletonList(ingredientsRepository.findById(id).get());
        }
        return ingredientsRepository.findAll();
    }

    @DeleteMapping(value = { "/ingredients/{id}"})
    public Ingredients deleteIngredients(@PathVariable(value = "id") Long id) {
        Ingredients ingredients = ingredientsRepository.findById(id).get();
        ingredientsRepository.deleteById(id);
        return ingredients;
    }

}
