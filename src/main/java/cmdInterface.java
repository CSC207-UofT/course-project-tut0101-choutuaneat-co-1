import java.util.ArrayList;
import java.util.Scanner;

public class cmdInterface {
    private final int QUIT = 0;
    private final int ADD_NEW_DISH = 1;
    private final int SEARCH_DISHES = 2;
    private final int MANAGE_FAVOURITE_DISHES = 3;
    private final int ADD_DELETE = 1;

    public void execute() {
        System.out.print("Welcome to ChouTuan Eat Application! Enjoy it!\n");
        Content contentInstance = new Content();
        favourites favouritesInstance = new favourites();
        int selectedFunction;
        boolean continueExecute = true;
        while (continueExecute) {
            System.out.print("Please input the corresponding index of function you would like to try. You may: \n" +
                    "0. Quit\n" +
                    "1. Add a new dish recipe\n" +
                    "2. Search for dishes\n" +
                    "3. View and manage Favourite dishes list\n");
            Scanner sc = new Scanner(System.in);
            try {
                selectedFunction = sc.nextInt();
                sc.nextLine();
                if (selectedFunction == ADD_NEW_DISH) {
                    addNewDish(contentInstance, sc);
                } else if (selectedFunction == SEARCH_DISHES) {
                    searchDishes(contentInstance, favouritesInstance, sc);
                } else if (selectedFunction == MANAGE_FAVOURITE_DISHES) {
                    manageFavouriteDishes(favouritesInstance, sc);
                } else if(selectedFunction != QUIT){
                    throw new Exception();
                }
                continueExecute = selectedFunction != QUIT;
            }
            catch (Exception e) {
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
        boolean continueAddDish = true;
        while(continueAddDish) {
            System.out.print("Please input the name of dish you would like to add\n");
            String dishName = sc.nextLine();
            boolean reInput = true;
            int cookMethod = CookMethods.FRIED;
            while(reInput) {
                System.out.print("Please input corresponding index of the dish's cooking method\n" +
                        "1. Fried\n" +
                        "2. Boiled\n" +
                        "3. Steamed\n" +
                        "4. Grilled\n");
                sc = new Scanner(System.in);
                try {
                    cookMethod = sc.nextInt();
                    sc.nextLine();
                    if(cookMethod != CookMethods.FRIED && cookMethod != CookMethods.GRILLED
                    && cookMethod != CookMethods.STEAMED && cookMethod != CookMethods.BOILED)
                        throw new Exception();
                    reInput = false;
                }
                catch (Exception e) {
                    System.out.print("Invalid input! Please try again!\n");
                }
            }
            boolean continueAddIngredients = true;
            ArrayList<Ingredients> ingredient_list = new ArrayList<>();
            while (continueAddIngredients) {
                System.out.print("Please input dish's ingredient with following format:\nName: ");
                String ingredientName = sc.nextLine();
                reInput = true;
                float ingredientWeight = 0;
                while(reInput) {
                    System.out.print("Weight(In grams): ");
                    sc = new Scanner(System.in);
                    try {
                        ingredientWeight = sc.nextFloat();
                        sc.nextLine();
                        if(ingredientWeight < 0)
                            throw new Exception();
                        reInput = false;
                    }
                    catch (Exception e) {
                        System.out.print("Invalid input! Please try again!\n");
                    }
                }
                reInput = true;
                float ingredientCaloriesPerGram = 0;
                while(reInput) {
                    System.out.print("Calories(per gram): ");
                    sc = new Scanner(System.in);
                    try {
                        ingredientCaloriesPerGram = sc.nextFloat();
                        sc.nextLine();
                        if(ingredientCaloriesPerGram < 0)
                            throw new Exception();
                        reInput = false;
                    }
                    catch (Exception e) {
                        System.out.print("Invalid input! Please try again!\n");
                    }
                }
                Ingredients newIngredient = new Ingredients(ingredientName, ingredientCaloriesPerGram, ingredientWeight);
                ingredient_list.add(newIngredient);
                //TODO: store newIngredient in content.
                reInput = true;
                String continueChoice = "Y";
                while(reInput) {
                    System.out.print("Add an ingredient successfully! Continue to add a new one?(Y/N)\n");
                    continueChoice = sc.nextLine();
                    if(continueChoice.equals("Y") || continueChoice.equals("N"))
                        reInput = false;
                    else {
                        System.out.print("Invalid input! Please try again!\n");
                    }
                }
                continueAddIngredients = continueChoice.equals("Y");
            }
            System.out.print("Please input the instruction for the dish\n");
            String dishInstr = sc.nextLine();
            Dishes newDish;
            if (cookMethod == CookMethods.FRIED) {
                newDish = new Fried(dishName, ingredient_list, dishInstr);
            } else if (cookMethod == CookMethods.BOILED) {
                newDish = new Boiled(dishName, ingredient_list, dishInstr);
            } else if (cookMethod == CookMethods.STEAMED) {
                newDish = new Steamed(dishName, ingredient_list, dishInstr);
            } else if (cookMethod == CookMethods.GRILLED){
                newDish = new Grilled(dishName, ingredient_list, dishInstr);
            } else {
                newDish = new Dishes(dishName, ingredient_list, dishInstr);
            }
            contentInstance.addDish(newDish);
            reInput = true;
            String continueChoice = "Y";
            while(reInput) {
                System.out.print("Add a dish successfully! Continue to add a new one?(Y/N)\n");
                continueChoice = sc.nextLine();
                if(continueChoice.equals("Y") || continueChoice.equals("N"))
                    reInput = false;
                else {
                    System.out.print("Invalid input! Please try again!\n");
                }
            }
            continueAddDish = continueChoice.equals("Y");
        }

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
        int indexOfDish = QUIT;
        showDistList(dishList);
        boolean reInput = true;
        while(reInput) {
            System.out.print("Please input corresponding index of the dish to see details, input \"0\" to return\n");
            sc = new Scanner(System.in);
            try {
                indexOfDish = sc.nextInt();
                sc.nextLine();
                if(indexOfDish > dishList.length || indexOfDish < 0)
                    throw new Exception();
                reInput = false;
            }
            catch (Exception e) {
                System.out.print("Invalid input! Please try again!\n");
            }
        }
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
        System.out.print("Results list as follows:\n");
        if(dishListLength == 0) {
            System.out.print("No result Found!\n");
            return;
        }
        for (int i = 1; i <= dishListLength; i++) {
            System.out.print(i + ". " + dishList[i - 1].get_dish_name()+ "\n");
        }
    }

    /**
     * Check a dish. Can view its detail, add to/drop from your favourite dish list
     * @param dishInstance the dish you want to check
     * @param favouritesList a favourite instance that store user's favourite dishes
     */
    private void checkDish(Dishes dishInstance , favourites favouritesList) {
        boolean continueCheck = true;
        Scanner sc = new Scanner(System.in);
        while(continueCheck) {
            viewDishDetails(dishInstance);
            boolean reInput = true;
            int functionIndex = QUIT;
            while(reInput) {
                System.out.print("Please input \"1\" to add to/drop from your favourite dish list, input \"0\" to return\n");
                sc = new Scanner(System.in);
                try {
                    functionIndex = sc.nextInt();
                    sc.nextLine();
                    if(functionIndex != ADD_DELETE && functionIndex != QUIT)
                        throw new Exception();
                    reInput = false;
                }
                catch (Exception e) {
                    System.out.print("Invalid input. Try again.\n");
                    continue;
                }
            }
            continueCheck = (functionIndex != QUIT);
            if (functionIndex == ADD_DELETE) {
                if(favouritesList.containDish(dishInstance)) {
                    favouritesList.removeFavourite(dishInstance);
                    System.out.print("Remove dish from favourite dish list successfully!\n");
                }
                else {
                    favouritesList.addFavourite(dishInstance);
                    System.out.print("Add dish to favourite dish list successfully!\n");
                }
            }
        }
    }

    /**
     * View the details of a dish
     * @param dishInstance the dish you want to view its details
     */
    private void viewDishDetails(Dishes dishInstance) {
        System.out.println("****************************");
        System.out.println("Dish Name: " + dishInstance.get_dish_name());
        ArrayList<Ingredients> ingredientsList = dishInstance.get_ingredients();
        for (int i = 0; i < ingredientsList.size(); i++) {
            System.out.println("    ===========================");
            System.out.println("    Ingredient Name: " + ingredientsList.get(i).getIngredientsName());
            System.out.println("    Ingredient Weight: " + ingredientsList.get(i).getWeight());
        }
        System.out.println("    ===========================");
        System.out.println("Dish Total Calories: " + dishInstance.get_calories());
        System.out.println("Dish Instruction: " + dishInstance.get_instructions());
        System.out.println("****************************\n");
    }

}
