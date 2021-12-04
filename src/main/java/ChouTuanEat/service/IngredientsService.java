package ChouTuanEat.service;

import ChouTuanEat.entity.Ingredients;

import java.util.List;

public interface IngredientsService {
    /**
     * 保存或更新Ingredients， 如果存在则更新，不存在则添加
     */
    void saveOrUpdate(Ingredients ingredients);

    /**
     * 按照ingredients id 获取 ingredients
     * @param id ingredients id
     * @return ingredients
     */
    Ingredients getIngredientByID(Long id);

    /**
     * 获取所有的ingredients
     * @return 所有 ingredients
     */
    List<Ingredients> getAllIngredients();

    /**
     * 按照ingredients id 删除ingredients
     * @param id ingredients id
     */
    void deleteIngredientsByID(Long id);
}
