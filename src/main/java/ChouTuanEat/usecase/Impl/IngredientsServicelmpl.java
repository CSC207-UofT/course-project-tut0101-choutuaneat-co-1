package ChouTuanEat.usecase.Impl;

import ChouTuanEat.entity.Ingredients;
import ChouTuanEat.repository.IngredientsRepository;
import ChouTuanEat.usecase.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsServicelmpl implements IngredientsService {
    @Autowired
    private IngredientsRepository ingredientsRepository;

    /**
     * Save or update Ingredients, update if they exist, add if they don’t exist.
     */
    @Override
    public void saveOrUpdate(Ingredients ingredients) {
        ingredientsRepository.save(ingredients);
    }

    /**
     * Get ingredients according to ingredients' id.
     * @param id ingredients id
     * @return ingredients
     */
    @Override
    public Ingredients getIngredientByID(Long id) {
        return ingredientsRepository.findById(id).orElse(null);
    }

    /**
     * Get all ingredients
     * @return all ingredients
     */
    @Override
    public List<Ingredients> getAllIngredients() { return ingredientsRepository.findAll(); }

    /**
     * Delete ingredients according to ingredients' id
     * @param id ingredients id
     */
    @Override
    public void deleteIngredientsByID(Long id) {
        ingredientsRepository.deleteById(id);
    }
}
