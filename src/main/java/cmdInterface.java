import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.Scanner;

public class cmdInterface {
    private final int QUIT = 0;
    private final int ADD_NEW_DISH = 1;
    private final int SEARCH_DISHES = 2;
    private final int MANAGE_FAVOURITE_DISHES = 3;
    private final int FRIED = 1;
    private final int BOILED = 2;
    private final int STEAMED = 3;
    private final int GRILLED = 4;

    public void execute() {
        System.out.print("Welcome to ChouTuan Eat Application! Enjoy it!\n");
        Content contentInstance = new Content();
        favourites favouritesInstance = new favourites(contentInstance);
        int selectedFunction = SEARCH_DISHES;
        while (selectedFunction != QUIT) {
            System.out.print("Please input the corresponding index of function you would like to try. You may: \n" +
                    "0. Quit\n" +
                    "1. Add a new dish recipe\n" +
                    "2. Search for dishes\n" +
                    "3. View and manage Favourite dishes list\n");
            Scanner sc = new Scanner(System.in);
            selectedFunction = sc.nextInt();
            if (selectedFunction == ADD_NEW_DISH) {
                addNewDish(contentInstance, sc);
            } else if (selectedFunction == SEARCH_DISHES) {
                searchDishes(contentInstance, favouritesInstance, sc);
            } else if (selectedFunction == MANAGE_FAVOURITE_DISHES) {
                manageFavouriteDishes(favouritesInstance, sc);
            } else {
                System.out.print("Invalid input! Please try again!\n");
            }
        }
        System.out.print("Thanks for using!\n");
        return;
    }

    /**
     * Add new dish that user input.
     * @param contentInstance a content instance to store new dish
     * @param sc a Scanner to read user's input
     */
    private void addNewDish(Content contentInstance, Scanner sc) {
        System.out.print("Please input the name of dish you would like to add\n");
        String dishName = sc.nextLine();
        System.out.print("Please input corresponding index of the dish's cooking method\n" +
                "1. Fried\n" +
                "2. Boiled\n" +
                "3. Steamed\n" +
                "4. Grilled\n");
        int cookMethod = sc.nextInt();
        boolean continueAddIngredients = true;
        ArrayList<Ingredients> ingredient_list = new ArrayList<>();
        while (continueAddIngredients) {
            System.out.print("Please input dish's ingredient with following format:\n Name:");
            String ingredientName = sc.nextLine();
            System.out.print("Weight(In grams): ");
            float ingredientWeight = sc.nextFloat();
            System.out.print("Calories(per gram): ");
            float ingredientCaloriesPerGram = sc.nextFloat();
            Ingredients newIngredient = new Ingredients(ingredientName, ingredientCaloriesPerGram, ingredientWeight);
            ingredient_list.add(newIngredient);
            //TODO: store newIngredient in content.
            System.out.print("Add an ingredient successfully! Continue to add a new one?(Y/N)");
            String continueChoice = sc.nextLine();
            continueAddIngredients = continueChoice.equals("Y");
        }
        System.out.print("Please input the instruction for the dish\n");
        String dishInstr = sc.nextLine();
        Dishes newDish;
        if (cookMethod == FRIED) {
            newDish = new Fried(dishName, ingredient_list, dishInstr);
        } else if (cookMethod == BOILED) {
            newDish = new Boiled(dishName, ingredient_list, dishInstr);
        } else if (cookMethod == STEAMED) {
            newDish = new Steamed(dishName, ingredient_list, dishInstr);
        } else {
            newDish = new Grilled(dishName, ingredient_list, dishInstr);
        }
        contentInstance.addDish(newDish);
    }

    /**
     * Search related dishes that user input.
     * @param contentInstance a content instance that store all dishes instances
     * @param favouritesInstance a favourite instance that store user's favourite dishes
     * @param sc a Scanner to read user's input
     */
    private void searchDishes(Content contentInstance, favourites favouritesInstance, Scanner sc) {
        System.out.print("Please input dish's name or ingredient to search for recipes\n");
        String searchKeyword = sc.nextLine();
        Dishes[] searchRes = contentInstance.search(searchKeyword);
        int indexOfDish = -1;
        while (indexOfDish != QUIT) {
            indexOfDish = selectDishtoCheck(favouritesInstance, sc, searchRes);
        }
    }

    /**
     * View and manage user's favourite dishes
     * @param favouritesInstance a favourite instance that store user's favourite dishes
     * @param sc a Scanner to read user's input
     */
    private void manageFavouriteDishes(favourites favouritesInstance, Scanner sc) {
        System.out.print("Here is your favourite dish list\n");
        int indexOfDish = -1;
        while (indexOfDish != QUIT) {
            Dishes[] favouritesDishList = favouritesInstance.getFavouriteList();
            indexOfDish = selectDishtoCheck(favouritesInstance, sc, favouritesDishList);
        }
    }

    /**
     * Show dishes in dishList and allow user to select one dish to check.
     * @param favouritesInstance a favourite instance that store user's favourite dishes
     * @param sc a Scanner to read user's input
     * @param dishList a list of Dishes instances
     * @return the index of dish that user selected
     */
    private int selectDishtoCheck(favourites favouritesInstance, Scanner sc, Dishes[] dishList) {
        int indexOfDish;
        showDistList(dishList);
        System.out.print("Please input corresponding index of the dish to see details, input \"0\" to return\n");
        indexOfDish = sc.nextInt();
        if (indexOfDish != QUIT)
            checkDish(dishList[indexOfDish - 1], favouritesInstance);
        return indexOfDish;
    }

    /**
     * Show a list of dish in cmd interface
     * @param dishList a list of Dishes instances
     */
    private void showDistList(Dishes[] dishList) {
        int dishListLength = dishList.length;
        for (int i = 1; i <= dishListLength; i++) {
            System.out.print(i + ". " + dishList[i - 1].get_dish_name());
        }
    }

    /**
     * Check a dish. Can view its detail, add to/drop from your favourite dish list
     * @param dishInstance the dish you want to check
     * @param favouritesList a favourite instance that store user's favourite dishes
     */
    private void checkDish(Dishes dishInstance , favourites favouritesList) {
        viewDishDetails(dishInstance);
        System.out.print("Please input \"1\" to add to/drop from your favourite dish list, input \"0\" to return\n");
        Scanner sc = new Scanner(System.in);
        int functionIndex = sc.nextInt();
        if (functionIndex == 1) {
            if(favouritesList.containDish(dishInstance)) {
                favouritesList.removeFavourite(dishInstance);
            }
            else {
                favouritesList.addFavourite(dishInstance);
            }
            while (functionIndex != QUIT) {
                System.out.print("Invalid input. Please input \"0\" to return\n");
                functionIndex = sc.nextInt();
            }
        }
    }

    /**
     * View the details of a dish
     * @param dishInstance the dish you want to view its details
     */
    private void viewDishDetails(Dishes dishInstance) {
        System.out.println("Dish Name:" + dishInstance.get_dish_name());
        ArrayList<Ingredients> ingredientsList = dishInstance.get_ingredients();
        for (int i = 0; i < ingredientsList.size(); i++) {
            System.out.println("    Ingredient Name:" + ingredientsList.get(i).getIngredientsName());
            System.out.println("    Ingredient Weight:" + ingredientsList.get(i).getWeight());
        }
        System.out.println("Dish Total Calories:" + dishInstance.get_calories());
        System.out.println("Dish Instruction:" + dishInstance.get_instructions());
    }

}
