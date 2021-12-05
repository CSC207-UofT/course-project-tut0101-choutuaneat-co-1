package ChouTuanEat.controller;

import ChouTuanEat.entity.Dishes;
import ChouTuanEat.usecase.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class DishesController {

    @Autowired
    private DishesService dishesService;

    @GetMapping("/homepage")
    public String gethomepage() {
        return "index";
    }

    @GetMapping("/searchDishes")
    public String getSearchDishPage() {
        return "search_dishes";
    }

    @GetMapping("/addDishes")
    public String getAddDishPage() {
        return "dishes";
    }

    /**
     * Add dishes to the database.
     * @param dishes The dishes to be added.
     * @return The dishes that was added.
     */
    @ResponseBody
    @PostMapping("/dishes")
    public Dishes addDishes(@RequestBody Dishes dishes) {
        dishesService.saveOrUpdate(dishes);
        return dishes;
    }

    /**
     * Get dishes that can be queried by ID, list or fuzzy query by name.
     * @param name The name of dishes (optional parameters).
     * @param id   The Id of dishes (optional parameters).
     * @return A list of dishes that meets the requirements of fuzzy query.
     */
    @ResponseBody
    @GetMapping(value = {"/dishes/{id}", "/dishes", "/dishes/like/{name}"})
    public List<Dishes> getDishes(@PathVariable(value = "name", required = false) String name,
                                  @PathVariable(value = "id",required = false) Long id) {
        if (id != null) {
            Dishes dishes = dishesService.getDishByDishID(id);
            if (dishes == null) {
                return null;
            }
            dishesService.assembleDishes(dishes);
            return Collections.singletonList(dishes);
        }
        if (name != null) {
            List<Dishes> dishesList = dishesService.getDishByDishName(name);
            dishesList.forEach(item -> dishesService.assembleDishes(item));
            return dishesList;
        }
        List<Dishes> dishesList = dishesService.getAllDishes();
        dishesList.forEach(item -> dishesService.assembleDishes(item));
        return dishesList;
    }

    /**
     * Delete dishes by dishes' ID.
     * @param id ID of a dish.
     * @return a dish that was deleted by ID.
     */
    @ResponseBody
    @DeleteMapping("/dishes/{id}")
    public Dishes deleteDishes(@PathVariable("id") Long id) {
        Dishes dishes = dishesService.getDishByDishID(id);
        if (dishes == null) {
            return null;
        }
        dishesService.assembleDishes(dishes);
        dishesService.deleteDishesByID(id);
        return dishes;
    }
}
