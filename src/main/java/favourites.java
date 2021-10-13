import java.util.*;

public class favourites {

    private ArrayList<Dishes> favourite_dishes;

    public favourites(Content database){
        this.favourite_dishes = new ArrayList<Dishes>();
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
     * @return If the dish is in the list
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
        Dishes [] result = {};
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
            result[i] = this.favourite_dishes.get(i).getName();
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
            result[i] = this.favourite_dishes.get(i).getCalories();
        }
        return result;
    }







}
