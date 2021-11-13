//package ChouTuanEat.Co.entity;
//
////package ChouTuanEat.co.demo.entity;
//
//import java.util.ArrayList;
//import ChouTuanEat.Co.entity.*;
//
//public class Content{
//    private ArrayList<Fried> friedDishes;
//    private ArrayList<Boiled>  boiledDishes;
//    private ArrayList<Steamed> steamedDishes;
//    private ArrayList<Grilled> grilledDishes;
//
//    /**
//     * Construct a Content database that stores dishes (by category of fried, boiled, steamed, and grilled).
//     */
//
//    public Content(){
//        this.friedDishes = new ArrayList<>();
//        this.boiledDishes = new ArrayList<>();
//        this.steamedDishes = new ArrayList<>();
//        this.grilledDishes = new ArrayList<>();
//    }
//
//    // 'add' methods
//    /**
//     * Add dish to its respective cooking method category list.
//     * @param in_dish is a Dish instance which could be of subclass Fried, Boiled, Steamed, or Grilled.
//     */
//    public <T extends Dishes> void addDish(T in_dish){
//        if (in_dish instanceof Fried){
//            this.friedDishes.add((Fried) in_dish);
//        } else if (in_dish instanceof Boiled){
//            this.boiledDishes.add((Boiled) in_dish);
//        } else if (in_dish instanceof Steamed){
//            this.steamedDishes.add((Steamed) in_dish);
//        } else {
//            this.grilledDishes.add((Grilled) in_dish);
//        }
//    }
//
//    // 'get' methods
//    /**
//     * Gets a list of all the existing fried dishes.
//     * @return The list of existing Fried instances.
//     */
//    public ArrayList<Dishes> getFried(){
//        ArrayList<Dishes> result = new ArrayList<>();
//        for (Fried i : this.friedDishes){
//            result.add((Dishes) i);
//        }
//        return result;
//    }
//
//    /**
//     * Gets a list of all the existing boiled dishes.
//     * @return The list of existing Boiled instances.
//     */
//    public ArrayList<Dishes> getBoiled(){
//        ArrayList<Dishes> result = new ArrayList<>();
//        for (Boiled i : this.boiledDishes){
//            result.add((Dishes) i);
//        }
//        return result;
//    }
//
//    /**
//     * Gets a list of all the existing steamed dishes.
//     * @return The list of existing Steamed instances.
//     */
//    public ArrayList<Dishes> getSteamed(){
//        ArrayList<Dishes> result = new ArrayList<>();
//        for (Steamed i : this.steamedDishes){
//            result.add((Dishes) i);
//        }
//        return result;
//    }
//
//    /**
//     * Gets a list of all the existing grilled dishes.
//     * @return The list of existing Grilled instances.
//     */
//    public ArrayList<Dishes> getGrilled(){
//        ArrayList<Dishes> result = new ArrayList<>();
//        for (Grilled i : this.grilledDishes){
//            result.add((Dishes) i);
//        }
//        return result;
//    }
//
//    // 'search' method
//    /**
//     * Returns a list of dish names that matches with the input in terms of cooking method or dish name.
//     * @param input is the keyword being searched for.
//     * @return The list dish names that match with input.
//     */
//    public Dishes[] search(String input){
//        // TODO: Search functions to be improved after Tag class decisions are finalised.
//
//        ArrayList<Dishes> cumulate = new ArrayList<>();
//
//        //For cooking method searches:
//        if (input.equals("fried")){
//            cumulate = getFried();
//        } else if (input.equals("boiled")){
//            cumulate = getBoiled();
//        } else if(input.equals("steamed")){
//            cumulate = getSteamed();
//        } else if(input.equals("grilled")){
//            cumulate = getGrilled();
//        } else {
//            //For dish name searches:
//            //Search through friedDishes list for dishName match
//            for (Fried i : this.friedDishes){
//                if (i.get_dish_name().equals(input)){
//                    cumulate.add((Dishes) i);
//                }
//            }
//            //Search through boiledDishes list for dishName match
//            for (Boiled i : this.boiledDishes){
//                if (i.get_dish_name().equals(input)){
//                    cumulate.add((Dishes) i);
//                }
//            }
//            //Search through steamedDishes list for dishName match
//            for (Steamed i : this.steamedDishes){
//                if (i.get_dish_name().equals(input)){
//                    cumulate.add((Dishes) i);
//                }
//            }
//            //Search through grilledDishes list for dishName match
//            for (Grilled i : this.grilledDishes){
//                if (i.get_dish_name().equals(input)){
//                    cumulate.add((Dishes) i);
//                }
//            }
//        }
//
//        Dishes[] results = new Dishes[cumulate.size()];
//        for (int i = 0; i < cumulate.size(); i++){
//            results[i] = cumulate.get(i);
//        }
//
//        return results;
//    }
//}
//
