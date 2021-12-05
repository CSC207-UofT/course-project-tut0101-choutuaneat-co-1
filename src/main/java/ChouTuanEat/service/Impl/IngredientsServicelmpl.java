package ChouTuanEat.service.Impl;

import ChouTuanEat.entity.Ingredients;
import ChouTuanEat.repository.IngredientsRepository;
import ChouTuanEat.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsServicelmpl implements IngredientsService {
    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Override
    public void saveOrUpdate(Ingredients ingredients) {
        ingredientsRepository.save(ingredients);
    }

    @Override
    public Ingredients getIngredientByID(Long id) {
        return ingredientsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ingredients> getAllIngredients() { return ingredientsRepository.findAll(); }

    @Override
    public void deleteIngredientsByID(Long id) {
        ingredientsRepository.deleteById(id);
    }
}
