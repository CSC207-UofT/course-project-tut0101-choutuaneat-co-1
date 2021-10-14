import java.util.ArrayList;

class Fried extends Dishes {

    public Fried(String name, ArrayList<Ingredients> in_Ingredients, String in_instructions){
        super(name, in_Ingredients, in_instructions);
    }

    @Override
    public void cook(Dishes in_dish, ArrayList<Ingredients> input){
        super.cook(in_dish, input);
        this.total_calories = this.total_calories * 4;
    }
}

class Boiled extends Dishes {
    public Boiled(String name, ArrayList<Ingredients> in_Ingredients, String in_instructions){
        super(name, in_Ingredients, in_instructions);
    }

    @Override
    public void cook(Dishes in_dish, ArrayList<Ingredients> input){
        super.cook(in_dish, input);
        this.total_calories = this.total_calories * 1;
    }
}

class Steamed extends Dishes {
    public Steamed(String name, ArrayList<Ingredients> in_Ingredients, String in_instructions){
        super(name, in_Ingredients, in_instructions);
    }

    @Override
    public void cook(Dishes in_dish, ArrayList<Ingredients> input){
        super.cook(in_dish, input);
        this.total_calories = this.total_calories * 2;
    }
}

class Grilled extends Dishes {
    public Grilled(String name, ArrayList<Ingredients> in_Ingredients, String in_instructions){
        super(name, in_Ingredients, in_instructions);
    }

    @Override
    public void cook(Dishes in_dish, ArrayList<Ingredients> input){
        super.cook(in_dish, input);
        this.total_calories = this.total_calories * 3;
    }
}
