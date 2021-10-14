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

    public double getCaloriesPerGram(){
        return this.calories_per_gram;
    }

    public double getWeight(){
        return this.weight;
    }
}

