package ChouTuanEat.service.Impl;

import ChouTuanEat.entity.CookMethods;
import ChouTuanEat.entity.Dishes;
import ChouTuanEat.entity.DishesIngredients;
import ChouTuanEat.repository.DishesIngredientsRepository;
import ChouTuanEat.repository.DishesRepository;
import ChouTuanEat.repository.IngredientsRepository;
import ChouTuanEat.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishesServicelmpl implements DishesService {

    @Autowired
    DishesRepository dishesRepository;

    @Autowired
    private DishesIngredientsRepository dishesIngredientsRepository;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public CookMethods getCookingMethod() {
        return null;
    }

    @Override
    public String getDishName() {
        return null;
    }

    @Override
    public String getInstructions() {
        return null;
    }

    @Override
    public double getTotalCalories() {
        return 0;
    }

    @Override
    public Dishes getDishByDishID(Long id) {
        return dishesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dishes> getDishByDishName(String name) {
        return dishesRepository.findAllLikeDishName(name);
    }

    @Override
    public List<Dishes> getAllDishes() {
        return dishesRepository.findAll();
    }
    @Override
    public void assembleDishes(Dishes dishes) {
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

    @Override
    public void saveOrUpdate(Dishes dishes) {
        dishesRepository.save(dishes);
        dishes.getDishesIngredientsList().forEach(dishesIngredients -> {
            dishesIngredients.setDishesId(dishes.getId());
            dishesIngredientsRepository.save(dishesIngredients);
        });
    }

    @Override
    public void deleteDishesByID(Long id) {
        dishesRepository.deleteById(id);
        dishesIngredientsRepository.deleteAllByDishesId(id);
    }
}
