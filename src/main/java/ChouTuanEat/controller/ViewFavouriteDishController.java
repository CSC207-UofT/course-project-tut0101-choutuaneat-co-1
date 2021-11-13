//package ChouTuanEat.Co.controller;
//import ChouTuanEat.Co.entity.Dishes;
//import ChouTuanEat.Co.entity.User;
////import ChouTuanEat.Co.service.FavouriteService;
//import ChouTuanEat.Co.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/favourite")
//public class ViewFavouriteDishController {
//    private static User DUMMY_FORM_PLACEHOLDER_STUDENT = new User();
//
//    FavouriteService favouriteService;
//    @Autowired
//    public void setFavouriteService(FavouriteService favouriteService) {
//        this.favouriteService = favouriteService;
//    }
//
//    // http://127.0.0.1/favourite/list
//    // using json format to send response
//    @GetMapping("/list")
//    public List<Dishes> list() {
//        List<Dishes> allDishes = favouriteService.list();
//        return allDishes;
//    }
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
