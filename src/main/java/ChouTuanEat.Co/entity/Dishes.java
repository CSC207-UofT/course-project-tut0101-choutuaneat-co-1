package ChouTuanEat.Co.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import arraylist
import ChouTuanEat.Co.entity.Ingredients;

import java.util.ArrayList;

@Entity
@Table(name = "Dish")

public class Dishes {

    private ArrayList<Ingredients> ingredient_list;
    private String dish_name;
    private String instructions;
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

    //    get_dish_name method:
    @Id
    public String get_dish_name(){
        return this.dish_name;
    }

    //    get_ingredients method:
    @Column
    public ArrayList<Ingredients> get_ingredients(){
        return this.ingredient_list;
    }

    //    get_calories method:
    @Column
    public double get_calories() {
        return this.total_calories;
    }


    //    get_instructions method:
    @Column
    public String get_instructions(){
        return this.instructions;
    }


}
