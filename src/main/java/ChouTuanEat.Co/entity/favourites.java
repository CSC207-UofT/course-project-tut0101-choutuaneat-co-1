package ChouTuanEat.Co.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class favourites {

    private ArrayList<Dishes> favourite_dishes;

    public favourites(Dishes[] dishes){
        ArrayList<Dishes> list1 = new ArrayList<Dishes>();
        Collections.addAll(list1, dishes);
        this.favourite_dishes = list1;
    }

    /**
     * Add the dish to favourite_dishes if the dish is not
     * an existing entity in the list.
     * @param dish The dish to be added.
     * @return If the dish can be added or not.
     */
    public boolean addFavourite(Dishes dish){
        if(!this.favourite_dishes.contains(dish)){
            this.favourite_dishes.add(dish);
            return true;
        }
        return false;
    }

    /**
     * Remove the indicated dish from the current favourite_dishes list
     * if the dish is currently in the list.
     * @param dish The dish to be removed.
     * @return If the dish can be removed or not.
     */
    public boolean removeFavourite(Dishes dish){
        if(this.favourite_dishes.contains(dish)){
            this.favourite_dishes.remove(dish);
            return true;
        }
        return false;
    }

    /**
     * Check if the given dish is in the favourite list or not.
     * @param dish The dish to be checked.
     * @return If the dish is in the list.
     */
    public boolean containDish(Dishes dish){
        return this.favourite_dishes.contains(dish);
    }

    /**
     * Return the current favourite list of dishes.
     * @return The Current favourite list as an array.
     */
    public Dishes[] getFavouriteList(){
        Dishes[] result = new Dishes[this.favourite_dishes.size()];
        //Check if the current favourite_dishes list has nothing in it.
        if (this.favourite_dishes.isEmpty()) {
            result = new Dishes[0];
            return result;
        }
        //Allocate every dish into the result array.
        for (int i = 0; i < this.favourite_dishes.size(); i++) {
            result[i] = this.favourite_dishes.get(i);
        }
            return result;
    }

    /**
     * Return the sorted favourite_dishes according to the
     * given sort method. The default sorting method is alphabetical.
     * @return A sorted dishes list
     */
    public Dishes[] getFavouriteRank(String method){
        Dishes[] result = new Dishes[this.favourite_dishes.size()];
        if(method.toLowerCase().equals("name")){
            result = nameSort(this.favourite_dishes);
        }
        if(method.toLowerCase().equals("calories up")){
            result = calorieSort(this.favourite_dishes);
        }
        if(method.toLowerCase().equals("calories down")){
            result = calorieSort(this.favourite_dishes);
            Collections.reverse(Arrays.asList(result));
        }
        if(method.toLowerCase().equals("difficult up")){
            result = difficultySort(this.favourite_dishes);
        }
        if(method.toLowerCase().equals("difficult down")){
            result = difficultySort(this.favourite_dishes);
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
                if (lst.get(j).get_dish_name().compareTo(lst.get(min_idx).get_dish_name()) < 0) {
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
                if (lst.get(j).get_calories() < lst.get(min_idx).get_calories()) {
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
                if (lst.get(j).get_ingredients().size() < lst.get(i).get_ingredients().size()){
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

    /**
     * Return all the names of the current favourite_dishes list.
     * @return A string array containing all the names in favourite_dishes.
     */
    public String[] getNames(){
        String [] result = new String[this.favourite_dishes.size()];
        //Check if the current favourite_dishes list has nothing in it.
        if (this.favourite_dishes.isEmpty()){
            result = new String[0];
            return result;
        }
        //Allocate every dishes' name into the result array.
        for(int i = 0; i < this.favourite_dishes.size(); i ++){
            result[i] = this.favourite_dishes.get(i).get_dish_name();
        }
        return result;
    }

    /**
     * Return all the calories of the current favourite_dishes list.
     * @return A int array containing all the calories in favourite_dishes.
     */
    public int[] getCalories(){
        int [] result = new int[this.favourite_dishes.size()];
        //Check if the current favourite_dishes list has nothing in it.
        if (this.favourite_dishes.isEmpty()){
            result = new int[0];
            return result;
        }
        //Allocate every dishes' calories into the result array.
        for(int i = 0; i < this.favourite_dishes.size(); i ++){
            result[i] = (int)this.favourite_dishes.get(i).get_calories();
        }
        return result;
    }
}
