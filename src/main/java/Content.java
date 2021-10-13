import java.util.ArrayList;


public class Content{
    private ArrayList<Fried> friedDishes;
    private ArrayList<Boiled>  boiledDishes;
    private ArrayList<Steamed> steamedDishes;
    private ArrayList<Grilled> grilledDishes;

    /**
     * Construct a Content database that stores dishes (by category of fried, boiled, steamed, and grilled).
     */

    public Content(){
        this.friedDishes = new ArrayList<>();
        this.boiledDishes = new ArrayList<>();
        this.steamedDishes = new ArrayList<>();
        this.grilledDishes = new ArrayList<>();
    }

    // 'add' methods
    /**
     * Add dish to its respective cooking method category list.
     * @param in_dish is a Dish instance which could be of subclass Fried, Boiled, Steamed, or Grilled.
     */
    public <T extends Dishes> void addDish(T in_dish){
        if (in_dish instanceof Fried){
            this.friedDishes.add((Fried) in_dish);
        } else if (in_dish instanceof Boiled){
            this.boiledDishes.add((Boiled) in_dish);
        } else if (in_dish instanceof Steamed){
            this.steamedDishes.add((Steamed) in_dish);
        } else {
            this.grilledDishes.add((Grilled) in_dish);
        }
    }

    // 'get' methods
    /**
     * Gets a list of all the existing fried dishes.
     * @return The list of existing Fried instances.
     */
    public ArrayList<Fried> getFried(){
        return this.friedDishes;
    }

    /**
     * Gets a list of all the existing boiled dishes.
     * @return The list of existing Boiled instances.
     */
    public ArrayList<Boiled> getBoiled(){
        return this.boiledDishes;
    }

    /**
     * Gets a list of all the existing steamed dishes.
     * @return The list of existing Steamed instances.
     */
    public ArrayList<Steamed> getSteamed(){
        return this.steamedDishes;
    }

    /**
     * Gets a list of all the existing grilled dishes.
     * @return The list of existing Grilled instances.
     */
    public ArrayList<Grilled> getGrilled(){
        return this.grilledDishes;
    }

    // 'search' method
    /**
     * Returns a list of dish names with the same name as the dishName.
     * @param dishName of the dish that is being searched for.
     * @return The list dish names that match with dishName.
     */
    public ArrayList<String> searchDish(String dishName){
        // TODO: To be improved and made more efficient after Tag class decisions are finalised.

        ArrayList<String> results = new ArrayList<>();

        //Search through friedDishes list for dishName match
        for (Fried i : this.friedDishes){
            String currName = i.get_dish_name();
            if (currName.equals(dishName)){
                results.add(currName);
            }
        }

        //Search through boiledDishes list for dishName match
        for (Boiled i : this.boiledDishes){
            String currName = i.get_dish_name();
            if (currName.equals(dishName)){
                results.add(currName);
            }
        }

        //Search through steamedDishes list for dishName match
        for (Steamed i : this.steamedDishes){
            String currName = i.get_dish_name();
            if (currName.equals(dishName)){
                results.add(currName);
            }
        }

        //Search through grilledDishes list for dishName match
        for (Grilled i : this.grilledDishes){
            String currName = i.get_dish_name();
            if (currName.equals(dishName)){
                results.add(currName);
            }
        }

        return results;
    }
}