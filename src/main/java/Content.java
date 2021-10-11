import java.util.ArrayList;

public class Content{
    private ArrayList<Fried> fried_dishes;
    private ArrayList<Boiled>  boiled_dishes;
    private ArrayList<Steamed> steamed_dishes;
    private ArrayList<Grilled> grilled_dishes;

    /**
     * Construct a Content database that stores dishes by category of fried, boiled, steamed, and grilled.
     */

    public Content{
        this.fried_dishes = new ArrayList<>();
        this.boiled_dishes = new ArrayList<>();
        this.steamed_dishes = new ArrayList<>();
        this.grilled_dishes = new ArrayList<>();
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