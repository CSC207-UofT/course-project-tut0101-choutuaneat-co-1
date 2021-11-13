package ChouTuanEat.Co.controller;

import ChouTuanEat.Co.entity.Dishes;
import ChouTuanEat.Co.service.impl.AddDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("Add Dish")

public class AddDishController {
    private static Dishes DUMMY_FORM_PLACEHOLDER_DISHES = new Dishes();

    @Autowired
    private AddDishService addDishService;

    @GetMapping()
    public String getAddDishesPage(Model model){
        model.addAttribute("Dish", DUMMY_FORM_PLACEHOLDER_DISHES);

        return "Add New Dish";
    }

    @PostMapping()
    public String addNewDish(@ModelAttribute(value="Dish") Dishes dishes, Model model) {

        Dishes dish = AddDishService.getDishByDishName(Dishes.getDishName());

        if (Dishes != null && Dishes.getIngredientsList().equals(dish.getIngredientsList())) {
            model.addAttribute("Dish", dish);
            model.addAttribute("Ingredients", dish.getIngredientsList());
            model.addAttribute("Calories", dish.getCalories());

            return "DishesInfoPage";
        }

        model.addAttribute("Dish", DUMMY_FORM_PLACEHOLDER_DISHES);

        return "Add New Dish";
    }

}
