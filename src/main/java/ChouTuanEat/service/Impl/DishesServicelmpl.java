package ChouTuanEat.service.Impl;

import ChouTuanEat.entity.Dishes;
import ChouTuanEat.entity.DishesIngredients;
import ChouTuanEat.entity.UserFavoriteDishes;
import ChouTuanEat.repository.*;
import ChouTuanEat.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private UsersFavoriteDishesRepository usersFavoriteDishesRepository;

    @Override
    public Long getId() {
        return null;
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
    public List<Dishes> getFavorListByUserId(Long userId) {
        List<UserFavoriteDishes> userDishesIdPairList =  usersFavoriteDishesRepository.findAllFavoriteDishByUserId(userId);
        List<Long> dishIds = userDishesIdPairList.stream().map(UserFavoriteDishes::getDishesId).collect(Collectors.toList());
        List<Dishes> dishesList = new ArrayList<>();
        for (Long dishId : dishIds) {
            dishesList.add(getDishByDishID(dishId));
        }
        dishesList.forEach(this::assembleDishes);
        return dishesList;
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
    public void saveOrUpdateFavoriteList(UserFavoriteDishes useDishIdPair) {
        usersFavoriteDishesRepository.save(useDishIdPair);
    }

    @Override
    public void deleteDishesByID(Long id) {
        dishesRepository.deleteById(id);
        dishesIngredientsRepository.deleteAllByDishesId(id);
        usersFavoriteDishesRepository.deleteAllByDishesId(id);
    }

    @Override
    public void deleteDishesFromFavor(UserFavoriteDishes idPair) {
        usersFavoriteDishesRepository.delete(idPair);
    }
}
