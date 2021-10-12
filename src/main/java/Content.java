import java.util.ArrayList;


public class Content{
    private ArrayList<Fried> fried_dishes;
    private ArrayList<Boiled>  boiled_dishes;
    private ArrayList<Steamed> steamed_dishes;
    private ArrayList<Grilled> grilled_dishes;

    /**
     * Construct a Content database that stores dishes (by category of fried, boiled, steamed, and grilled).
     */

    public Content{
        this.fried_dishes = new ArrayList<>();
        this.boiled_dishes = new ArrayList<>();
        this.steamed_dishes = new ArrayList<>();
        this.grilled_dishes = new ArrayList<>();
    }



    /**
     * Add dish to its respective cooking method category list.
     * @param in_dish is an instance of Dish which could be of subclass Fried, Boiled, Steamed, or Grilled.
     */
    public void addDish(Dishes in_dish){
        if (in_dish instanceof Fried){
            this.fried_dishes.add((Fried) in_dish);
        } else if (in_dish instanceof Boiled){
            this.boiled_dishes.add((Boiled) in_dish);
        } else if (in_dish instanceof Steamed){
            this.steamed_dishes.add((Steamed) in_dish);
        } else {
            this.grilled_dishes.add((Grilled) in_dish);
        }

    }

    /**
     * Gets a list of all the existing fried dishes.
     * @return The list of existing Fried instances.
     */
    public ArrayList<Dishes> getFried(){
        return this.fried_dishes;
    }

    /**
     * Gets a list of all the existing boiled dishes.
     * @return The list of existing Boiled instances.
     */
    public ArrayList<Dishes> getBoiled(){
        return this.boiled_dishes;
    }

    /**
     * Gets a list of all the existing steamed dishes.
     * @return The list of existing Steamed instances.
     */
    public ArrayList<Dishes> getSteamed(){
        return this.steamed_dishes;
    }

    /**
     * Gets a list of all the existing grilled dishes.
     * @return The list of existing Grilled instances.
     */
    public ArrayList<Dishes> getGrilled(){
        return this.grilled_dishes;
    }
}