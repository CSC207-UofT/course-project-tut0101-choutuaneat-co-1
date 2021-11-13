package ChouTuanEat.Co.controller;

import ChouTuanEat.Co.entity.Dishes;
import ChouTuanEat.Co.entity.DishesIngredients;
import ChouTuanEat.Co.repository.DishesIngredientsRepository;
import ChouTuanEat.Co.repository.DishesRepository;
import ChouTuanEat.Co.repository.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class DishesController {

    @Autowired      // 自动注入的注解，会把容器里的DishesRepository放到这里来
    private DishesRepository dishesRepository;

    @Autowired
    private DishesIngredientsRepository dishesIngredientsRepository;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @PostMapping("/dishes")
    public Dishes addDishes(@RequestBody Dishes dishes) {
        dishesRepository.save(dishes);
        dishes.getDishesIngredientsList().forEach(dishesIngredients -> {
            dishesIngredients.setDishesId(dishes.getId());
            dishesIngredientsRepository.save(dishesIngredients);
        });
        return dishes;
    }

    @GetMapping(value = {"/dishes/{id}", "/dishes", "/dishes/like/{name}"})
    public List<Dishes> getDishes(@PathVariable(value = "name", required = false) String name,
                                  @PathVariable(value = "id",required = false) Long id) {
        if (id != null) {
            Optional<Dishes> dishesOptional = dishesRepository.findById(id);
            if (dishesOptional.isEmpty()) {
                return null;
            }
            Dishes dishes = dishesOptional.get();
            assembleDishes(dishes);
            return Collections.singletonList(dishes);
        }
        if (name != null) {
            List<Dishes> dishesList = dishesRepository.findAllLikeDishName(name);
            dishesList.forEach(this::assembleDishes);
            return dishesList;
        }
        List<Dishes> dishesList = dishesRepository.findAll();
        dishesList.forEach(this::assembleDishes);
        return dishesList;
    }

    @DeleteMapping("/dishes/{id}")
    public Dishes addDishes(@PathVariable("id") Long id) {
        Optional<Dishes> dishesOptional = dishesRepository.findById(id);
        if (dishesOptional.isEmpty()) {
            return null;
        }
        Dishes dishes = dishesOptional.get();
        assembleDishes(dishes);
        dishesRepository.deleteById(id);
        dishesIngredientsRepository.deleteAllByDishesId(id);
        return dishes;
    }

    private void assembleDishes(Dishes dishes) {
        dishes.setDishesIngredientsList(dishesIngredientsRepository.findAllByDishesId(dishes.getId()));
        List<Long> ingredientIds = dishes.getDishesIngredientsList().stream().map(DishesIngredients::getIngredientsId).collect(Collectors.toList());
        dishes.setIngredientsList(ingredientsRepository.findAllById(ingredientIds));
        dishes.getIngredientsList().forEach(ingredients -> {
            Long id = ingredients.getId();
            dishes.getDishesIngredientsList().forEach(dishesIngredients -> {
                if (dishesIngredients.getIngredientsId().equals(id)) {
                    ingredients.setWeight(dishesIngredients.getWeight());
                }
            });
        });
    }
}
