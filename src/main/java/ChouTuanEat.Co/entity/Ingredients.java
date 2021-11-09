package ChouTuanEat.co.demo.entity;

public class Ingredients {
    String ingredients_name;
    double calories_per_gram;
    double weight;

    public Ingredients (String ingredients_name, double calories_per_gram, double weight){
        this.ingredients_name = ingredients_name;
        this.calories_per_gram = calories_per_gram;
        this.weight = weight;
    }

    public String getIngredientsName() {
        return this.ingredients_name;
    }

    public double getCalories(){
        return this.calories_per_gram * weight;
    }

    public double getWeight(){
        return this.weight;
    }
}
