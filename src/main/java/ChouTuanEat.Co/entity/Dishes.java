package ChouTuanEat.co.demo.entity;

//import arraylist
import java.util.ArrayList;

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
        this.total_calories = 0;
        for (Ingredients each : in_Ingredients) {
            total_calories += each.getCalories();
        }
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
}