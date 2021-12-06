package ChouTuanEat.usecase;

import ChouTuanEat.entity.Ingredients;

import java.util.List;

public interface IngredientsService {

    void saveOrUpdate(Ingredients ingredients);

    Ingredients getIngredientByID(Long id);

    List<Ingredients> getAllIngredients();

    void deleteIngredientsByID(Long id);
}
