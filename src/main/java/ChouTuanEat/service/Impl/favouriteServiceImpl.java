package ChouTuanEat.service.Impl;

import ChouTuanEat.entity.Dishes;
import ChouTuanEat.entity.favourites;
import ChouTuanEat.repository.FavouriteRepository;
import ChouTuanEat.service.DishesService;
import ChouTuanEat.service.favouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class favouriteServiceImpl implements favouriteService {

    @Autowired
    FavouriteRepository favouriteRepository;
    DishesService dishesService;

    @Override
    public Long getId(favourites favourite){
        return favourite.getId();
    }

    /**
     * Find the desired favourite object given the user id.
     * @param id The desired favourite object's id.
     * @return The desired favourite object.
     */
    @Override
    public favourites getListByUserId(Long id){
        return favouriteRepository.findByUserId(id).orElse(null);
    }

    /**
     * Modify the favourite object into the database
     * @param favourite The given modified favourite object.
     */
    @Override
    public void saveOrUpdate(favourites favourite){
        favouriteRepository.save(favourite);
    }

    /**
     * Return the wanted favourite list, given the favourite object.
     * @param favourite The given favourite object.
     * @return The favourite object's favourite list.
     */
    @Override
    public ArrayList<Dishes> getFavouriteList(favourites favourite) {
        List<Long> idList = favourite.getIdList();
        ArrayList<Dishes> result = new ArrayList<>();
        for (Long id : idList) {
            result.add(dishesService.getDishByDishID(id));
        }
        return result;
    }

    /**
     * Given the favourite object, return the favourite list sorted given the specified method.
     * @param favourite The given favourite object.
     * @param method The specified method
     * @return A sorted list.
     */
    @Override
    public Dishes[] getSortedFavouriteList(favourites favourite, String method){
        ArrayList<Dishes> dishes = getFavouriteList(favourite);
        return getFavouriteRank(dishes, method);
    }

        /**
     * Return the sorted favourite_dishes according to the
     * given sort method. The default sorting method is alphabetical.
     * @return A sorted dishes list
     */
    private Dishes[] getFavouriteRank(ArrayList<Dishes> dishes, String method){
        Dishes[] result = new Dishes[dishes.size()];
        if(method.equalsIgnoreCase("name")){
            result = nameSort(dishes);
        }
        if(method.equalsIgnoreCase("calories up")){
            result = calorieSort(dishes);
        }
        if(method.equalsIgnoreCase("calories down")){
            result = calorieSort(dishes);
            Collections.reverse(Arrays.asList(result));
        }
        if(method.equalsIgnoreCase("difficult up")){
            result = difficultySort(dishes);
        }
        if(method.equalsIgnoreCase("difficult down")){
            result = difficultySort(dishes);
            Collections.reverse(Arrays.asList(result));
        }

        return result;
    }

    /**
     * Return the sorted dishes array sorted in alphabetical order.
     * @param lst A dishes list to be sorted.
     * @return A sorted result list.
     */
    private Dishes[] nameSort(ArrayList<Dishes> lst){
        int n = lst.size();
        for (int i = 0; i < n-1; i++){
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (lst.get(j).getDishName().compareTo(lst.get(min_idx).getDishName()) < 0) {
                    min_idx = j;
                }
            }
            Collections.swap(lst, i, min_idx);
        }
        return toDishArray(lst);
    }

    /**
     * Return the sorted dishes array sorted in calorie order.
     * @param lst A dishes list to be sorted.
     * @return A sorted result list.
     */
    private Dishes[] calorieSort(ArrayList<Dishes> lst){
        int n = lst.size();
        for (int i = 0; i < n-1; i++){
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (lst.get(j).getTotalCalories() < lst.get(min_idx).getTotalCalories()) {
                    min_idx = j;
                }
            }
            Collections.swap(lst, i, min_idx);
        }
        return toDishArray(lst);
    }

    /**
     * Return the sorted dishes array sorted in alphabetical order.
     * @param lst A dishes list to be sorted.
     * @return A sorted result list.
     */
    private Dishes[] difficultySort(ArrayList<Dishes> lst){
        int n = lst.size();
        for (int i = 0; i < n-1; i++){
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                if (lst.get(j).getIngredientsList().size() < lst.get(i).getIngredientsList().size()){
                        min_idx = j;
                }
            }
            Collections.swap(lst, i, min_idx);
        }
        return toDishArray(lst);

    }

    /**
     * Convert the given dish arraylist to a dish array.
     * @param lst A dish arraylist.
     * @return A dish array containing all elements in the original arraylist
     * with the original ordering.
     */
    private Dishes[] toDishArray(ArrayList<Dishes> lst){
        Dishes[] result = new Dishes[lst.size()];
        for(int i = 0; i < lst.size(); i++){
            result[i] = lst.get(i);
        }
        return result;
    }


}
