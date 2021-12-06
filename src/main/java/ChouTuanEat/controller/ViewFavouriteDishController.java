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

//
//    // http://127.0.0.1/favourite/rank?method=xxx
//    // using json format to send response
//    @GetMapping("/rank")
//    public List<Dishes> rank(@RequestParam String method) {
//        List<Dishes> rankDishes = favouriteService.rank(method);
//        return rankDishes;
//    }
//
//    // http://127.0.0.1/favourite/rank?method=xxx
//    // using json format to send response
//    @GetMapping("/names")
//    public List<String> names() {
//        List<String> rankDishes = favouriteService.names();
//
//        return rankDishes;
//    }
//
//    // POST http://127.0.0.1/favourite/add
//    // using json format to send request and response
//    @PostMapping("/add")
//    public boolean add(@RequestBody Dishes dishes) {return favouriteService.add(dishes);}
//
//    // POST http://127.0.0.1/favourite/remove
//    // using json format to send request and response
//    @PostMapping("/remove")
//    public boolean remove(@RequestBody Dishes dishes) {return favouriteService.remove(dishes);}
//}
