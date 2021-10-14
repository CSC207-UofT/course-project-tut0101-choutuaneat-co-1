import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Tag {

    private static Map<String, String> ingredients = new HashMap<>();

    public static void main(String[] args) {

        ingredients.put("Beef", "Meat");
        ingredients.put("Lamb", "Meat");
        ingredients.put("Chicken", "Meat");
        ingredients.put("Pork", "Meat");
        ingredients.put("Fish", "Seafood");
        ingredients.put("Shrimp", "Seafood");
        ingredients.put("Crab", "Seafood");
        ingredients.put("Tomato", "Vegetable");
        ingredients.put("Potato", "Vegetable");
        ingredients.put("Cabbage", "Vegetable");
        ingredients.put("Carrot", "Vegetable");
        ingredients.put("Lettuce", "Vegetable");
        ingredients.put("Pepper", "Vegetable");
        ingredients.put("Egg", "Egg");

    }

    public static String getType(String key) {
        if (ingredients.containsKey(key)) {
            return ingredients.get(key);
        }
        else {
            return "Does not exist, please use addIngredients to add it.";
        }
    }

    public static void addIngredients(String key, String value) {
        ingredients.put(key, value);
    }



}


