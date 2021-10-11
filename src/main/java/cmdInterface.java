import java.util.Scanner;

public class cmdInterface {
    private final int QUIT = 0;
    private final int ADD_NEW_DISH = 1;
    private final int SEARCH_DISHES = 2;
    private final int MANAGE_FAVOURITE_DISHES = 3;
    public void execute() {
        System.out.print("Welcome to ChouTuan Eat Application! Enjoy it!\n");
        int selectedFunction = SEARCH_DISHES;
        while(selectedFunction != QUIT) {
            System.out.print("Please input the corresponding index of function you would like to try. You may: \n" +
                    "0. Quit\n" +
                    "1. Add a new dish recipe\n" +
                    "2. Search for dishes\n" +
                    "3. View and manage Favourite dishes list\n");
            Scanner sc = new Scanner(System.in);
            selectedFunction = sc.nextInt();
            if(selectedFunction == ADD_NEW_DISH) {
                System.out.print("Please input the name of dish you would like to add\n");
                String dishName = sc.nextLine();
                boolean continueAddIngredients = true;
                while(continueAddIngredients) {
                    System.out.print("Please input dish's ingredient with following format:\n Name:");
                    String ingredientName = sc.nextLine();
                    System.out.print("\nWeight(In grams): ");
                    float ingredientWeight = sc.nextFloat();
                    System.out.print("\nCalories(per gram): ");
                    float ingredientCaloriesPerGram = sc.nextFloat();
                    //TODO: creat a new ingredient and store it in content.
                    System.out.print("Add an ingredient successfully! Continue to add a new one?(Y/N)");
                    String continueChoice = sc.nextLine();
                    continueAddIngredients = continueChoice.equals("Y");
                }
                System.out.print("Please input the instruction for the dish\n");
                String dishInstr = sc.nextLine();
                //TODO: creat a new dish and store it in content.
            }
            else if(selectedFunction == SEARCH_DISHES) {
                System.out.print("Please input dish's name or ingredient to search for recipes\n");
                String searchKeyword = sc.nextLine();
                //TODO: get a dish list from content.
                int indexOfDish = -1;
                while(indexOfDish != 0) {
                    //vector<Dishes> tmp;
                    //show(tmp);
                    System.out.print("Please input corresponding index of the dish to see details, input \"0\" to return\n");
                    indexOfDish = sc.nextInt();
                    if(indexOfDish != QUIT)
                        ;//checkDish(tmp, indexOfDish);
                }


            }
            else if(selectedFunction == MANAGE_FAVOURITE_DISHES) {
                System.out.print("Here is your favourite dish list\n");
                int indexOfDish = -1;
                while(indexOfDish != 0) {
                    //TODO: get a dish list from favorite.
                    //vector<Dishes> tmp;
                    //show(tmp);
                    System.out.print("Please input corresponding index of the dish to see details, input \"0\" to return\n");
                    indexOfDish = sc.nextInt();
                    if(indexOfDish != QUIT)
                        ;//manageFavorite(tmp, indexOfDish);
                }
            }
            else {
                System.out.print("Invalid input! Please try again!\n");
            }
        }
        System.out.print("Thanks for using!\n");
        return;
    }
    private void showDetails() {
        //TODO: given a list of dish and index, show its info on cmd.
    }
    private void checkDish() {
        showDetails();
        System.out.print("Please input \"1\" to add it to your favourite dish list, input \"0\" to return\n");
        Scanner sc = new Scanner(System.in);
        int functionIndex = sc.nextInt();
        if(functionIndex == 1) {
            //TODO: add dish to favourite dish list
            while (functionIndex != QUIT) {
                System.out.print("Invalid input. Please input \"0\" to return\n");
                functionIndex = sc.nextInt();
            }
        }
    }
    private void manageFavourite() {
        showDetails();
        System.out.print("Please input \"1\" to drop it from your favourite dish list, input \"0\" to return\n");
        Scanner sc = new Scanner(System.in);
        int functionIndex = sc.nextInt();
        if(functionIndex == 1) {
            //TODO: drop dish to favourite dish list
            while (functionIndex != QUIT) {
                System.out.print("Invalid input. Please input \"0\" to return\n");
                functionIndex = sc.nextInt();
            }
        }
    }
}
