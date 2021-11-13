package ChouTuanEat.controller;

import ChouTuanEat.entity.Dishes;
import ChouTuanEat.entity.DishesIngredients;
import ChouTuanEat.repository.DishesIngredientsRepository;
import ChouTuanEat.repository.DishesRepository;
import ChouTuanEat.repository.IngredientsRepository;
import ChouTuanEat.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @ResponseBody
    @PostMapping("/dishes")
    public Dishes addDishes(@RequestBody Dishes dishes) {
        dishesService.saveOrUpdate(dishes);
        return dishes;
    }

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
