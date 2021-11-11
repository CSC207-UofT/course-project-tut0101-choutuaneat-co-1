package ChouTuanEat.Co.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import arraylist

import java.util.ArrayList;

@Entity
@Table(name = "Dish")

public class Dishes {

    @Id
    private String dishname;

    @Column
    private ArrayList<Ingredients> ingredientlist;

    @Column
    private double totalcalories;

    @Column
    private String instructions;

    public String getDishName(){
        return dishname;
    }

    public void setDishName(String dishname) {
        this.dishname = dishname;
    }

    public ArrayList<Ingredients> getIngredientsList(){
        return ingredientlist;
    }

    public void setIngredientlist(ArrayList<Ingredients> ingredientlist) {
        this.ingredientlist = ingredientlist;
    }

    public double getCalories() {
        return totalcalories;
    }
    public void setCalories(Double total_calories) {
        this.totalcalories = totalcalories;
    }

    public String getInstructions(){
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }


}
