package ChouTuanEat.service;

import ChouTuanEat.entity.Dishes;
import ChouTuanEat.entity.favourites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.*;


//@Service
//public class FavouriteService {
//    private favourites favourites;
//
//    @Autowired
//    public void setFavourites(favourites favourites) {
//        this.favourites = favourites;
//    }
//
//    public List<String> names() {
//        String[] allNames = favourites.getNames();
//        List<String> nameList;
//        if (allNames != null ) {
//            nameList = Arrays.asList(allNames);
//        } else {
//            nameList = new ArrayList<String>();
//        }
//
//        return nameList;
//    }
//
//    public List<Dishes> list() {
//        Dishes[] allDishes = favourites.getFavouriteList();
//        List<Dishes> dishesList = new ArrayList<Dishes>();
//
//        if (allDishes != null) {
//            dishesList = Arrays.asList(allDishes);
//        } else {
//            dishesList = new ArrayList<Dishes>();
//        }
//        return dishesList;
//    }
//
//    public List<Dishes> rank(String method) {
//        Dishes[] rankDishes = favourites.getFavouriteRank(method);
//        List<Dishes> rankList;
//        if (rankDishes != null) {
//            rankList = Arrays.asList(rankDishes);
//        } else {
//            rankList = new ArrayList<Dishes>();
//        }
//        return rankList;
//    }
//
//    public boolean add(Dishes dishes) {return favourites.addFavourite(dishes);}
//
//    public boolean remove(Dishes dish) {return favourites.removeFavourite(dish);}
//}
