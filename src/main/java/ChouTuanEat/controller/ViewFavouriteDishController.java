package ChouTuanEat.controller;

import ChouTuanEat.entity.Dishes;
//import ChouTuanEat.entity.User;
import ChouTuanEat.entity.favourites;
import ChouTuanEat.usecase.favouriteService;
//import ChouTuanEat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

@Controller
@RequestMapping("/favourite")
public class ViewFavouriteDishController {

    private favouriteService FavouriteService;

    @Autowired
    public void setFavouriteService(favouriteService FavouriteService) {this.FavouriteService = FavouriteService;}

    @GetMapping("/my_favourites")
    @ResponseBody
    public favourites get_List_By_User_Id(@RequestParam Long id){
        favourites favourite_items = FavouriteService.getListByUserId(id);
        return favourite_items;
    }

    @PostMapping("/save")
    public String save_Or_Update(@RequestBody favourites favourite){
        FavouriteService.saveOrUpdate(favourite);
        return "updated";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Dishes> get_Favourite_List(@RequestParam Long user_Id){
        favourites favourite = FavouriteService.getListByUserId(user_Id);
        List<Dishes> favourite_list = FavouriteService.getFavouriteList(favourite);
        return favourite_list;
    }

    @GetMapping("/rank")
    @ResponseBody
    public Dishes[] get_Sorted_Favourite_List(@RequestParam Long user_Id, @RequestParam String method){
        favourites favourite = FavouriteService.getListByUserId(user_Id);
        Dishes[] wanted_dishes = FavouriteService.getSortedFavouriteList(favourite, method);
        return wanted_dishes;
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
