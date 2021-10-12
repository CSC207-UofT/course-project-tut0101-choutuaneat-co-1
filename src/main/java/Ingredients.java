public class Ingredients {
    String ingredients_name;
    double calories;

    public Ingredients (String ingredients_name, double calories){
        this.ingredients_name = ingredients_name;
        this.calories = calories;
    }

    public String getIngredientsName() {
        return this.ingredients_name;
    }

    public double getCalories(){
        return this.calories;
    }
}

