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
    DishesService dishesService;
    @Autowired
    FavouriteRepository favouriteRepository;

    @Override
    public Long getId(){
        return null;
    }

    @Override
    public favourites getListByUserId(Long id){
        return favouriteRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOrUpdate(favourites favourite){
        favouriteRepository.save(favourite);
    }

    @Override
    public ArrayList<Dishes> getFavouriteList(favourites favourite) {
        List<Long> idList = favourite.getIdList();
        ArrayList<Dishes> result = new ArrayList<Dishes>();
        for (Long id : idList) {
            result.add(dishesService.getDishByDishID(id));
        }
        return result;
    }

    @Override
    public Dishes[] getSortedFavouriteList(favourites favourite, String method){
        ArrayList<Dishes> dishes = getFavouriteList(favourite);
        Dishes[] result = getFavouriteRank(dishes, method);
        return result;
    }

        /**
     * Return the sorted favourite_dishes according to the
     * given sort method. The default sorting method is alphabetical.
     * @return A sorted dishes list
     */
    private Dishes[] getFavouriteRank(ArrayList<Dishes> dishes, String method){
        Dishes[] result = new Dishes[dishes.size()];
        if(method.toLowerCase().equals("name")){
            result = nameSort(dishes);
        }
        if(method.toLowerCase().equals("calories up")){
            result = calorieSort(dishes);
        }
        if(method.toLowerCase().equals("calories down")){
            result = calorieSort(dishes);
            Collections.reverse(Arrays.asList(result));
        }
        if(method.toLowerCase().equals("difficult up")){
            result = difficultySort(dishes);
        }
        if(method.toLowerCase().equals("difficult down")){
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
    public Dishes[] toDishArray(ArrayList<Dishes> lst){
        Dishes[] result = new Dishes[lst.size()];
        for(int i = 0; i < lst.size(); i++){
            result[i] = lst.get(i);
        }
        return result;
    }


}
