public class Ingredients {
    String ingredients_name;
    double calories;
    double weight;

    public Ingredients (String ingredients_name, double calories){
        this.ingredients_name = ingredients_name;
        this.calories = calories;
        this.weight = weight;
    }

    public String getIngredientsName() {
        return this.ingredients_name;
    }

    public double getCalories(){
        return this.calories;
    }

    public double getWeight(){
        return this.weight;
    }
}

