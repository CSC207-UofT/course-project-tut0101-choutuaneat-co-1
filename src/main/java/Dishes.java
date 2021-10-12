import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dishes {
    ArrayList<Ingredients> ingredient_list;
    String dish_name;
    String instructions;
    double total_calories;

//    Initializer:
    public Dishes(String name, ArrayList<Ingredients> in_Ingredients, String in_instructions){
        this.ingredient_list = new ArrayList<>(in_Ingredients);
        this.dish_name = name;
        this.instructions = in_instructions;
    }

//    get_calories method:
    public double get_calories() {
        return this.total_calories;
    }

//    get_dish_name method:
    public String get_dish_name(){
        return this.dish_name;
    }

//    get_instructions method:
    public String get_instructions(){
        return this.instructions;
    }

//    get_ingredients method:
    public ArrayList<Ingredients> get_ingredients(){
        return this.ingredient_list;
    }

//    cook method:
    public void cook(Dishes in_dish, ArrayList<Ingredients> input){
        double total_calories = 0;
        for (Ingredients each : input) {
            total_calories += each.get_Calories();
        }
        if (in_dish instanceof Fry){}
        if (in_dish instanceof Steam){}
        if (in_dish instanceof Boil){}
        if (in_dish instanceof Grilled){}
    }

}
