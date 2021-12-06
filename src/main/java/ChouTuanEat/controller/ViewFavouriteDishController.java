package ChouTuanEat.controller;

import ChouTuanEat.entity.Dishes;
import ChouTuanEat.entity.UserFavoriteDishes;
import ChouTuanEat.usecase.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/favourite")
public class ViewFavouriteDishController {

    @Autowired
    private DishesService dishesService;

    @GetMapping()
    public String getSearchDishPage() {
        return "favorites";
    }

    @PostMapping("/save")
    @ResponseBody
    public String saveOrUpdate(@RequestBody UserFavoriteDishes useDishIdPair){
        dishesService.saveOrUpdateFavoriteList(useDishIdPair);
        return "updated";
    }

    @GetMapping("/list/{uid}")
    @ResponseBody
    public List<Dishes> getFavouriteList(@PathVariable(value = "uid") Long user_Id){
        return dishesService.getFavorListByUserId(user_Id);
    }


    @ResponseBody
    @DeleteMapping("/list")
    public void deleteDishesFromFavorList(@RequestBody UserFavoriteDishes useDishIdPair) {
        dishesService.deleteDishesFromFavor(useDishIdPair);
    }

}
