package ui;

import model.Ingredient;
import model.Meal;
import model.Pantry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static model.Category.*;

// Meal Suggestion Application
public class MealSuggestionApp {
    private Pantry newPantry;
    private Meal lobsterPasta;
    private Meal tofuSalad;
    private Meal tiramisu;
    private Meal eggsBenedict;
    private Meal bluePancakes;
    private Meal blueWaffles;
    private Meal heartyVegan;
    private Meal japaneseMiracleNoodles;
    private Meal pestoPasta;
    private Meal stirFry;
    private Meal chickenCaesar;
    private Meal capriSalad;
    private final List<Ingredient> lobsterIngredients = new ArrayList<>();
    private final List<Ingredient> tofuSaladIngredients = new ArrayList<>();
    private final List<Ingredient> tiramisuIngredients = new ArrayList<>();
    private final List<Ingredient> benedictIngredients = new ArrayList<>();
    private final List<Ingredient> bluePancakesIngredients = new ArrayList<>();
    private final List<Ingredient> blueWafflesIngredients = new ArrayList<>();
    private final List<Ingredient> heartyVeganIngredients = new ArrayList<>();
    private final List<Ingredient> miracleNoodlesIngredients = new ArrayList<>();
    private final List<Ingredient> pestoPastaIngredients = new ArrayList<>();
    private final List<Ingredient> stirFryIngredients = new ArrayList<>();
    private final List<Ingredient> chickenCaesarIngredients = new ArrayList<>();
    private final List<Ingredient> capriIngredients = new ArrayList<>();
    private Ingredient tofu;
    private Ingredient tomatoes;
    private Ingredient lettuce;
    private Ingredient avocados;
    private Ingredient spaghetti;
    private Ingredient lobster;
    private Ingredient bacon;
    private Ingredient eggs;
    private Ingredient cheese;
    private Ingredient coffee;
    private Ingredient ladyfingers;
    private Ingredient englishMuffins;
    private Ingredient blueberries;
    private Ingredient pancakes;
    private Ingredient waffles;
    private Ingredient potatoes;
    private Ingredient miracleNoodles;
    private Ingredient mushrooms;
    private Ingredient pestoSauce;
    private Ingredient chowMeinNoodles;
    private Ingredient chicken;
    private Ingredient croutons;
    private Ingredient mozzarella;
    private Ingredient balsamicVinegar;
    private List<Meal> allMeals = new ArrayList<>();
    private Scanner input;
    private List<Meal> newMeals = new ArrayList<>();

    // EFFECTS: runs the recipe suggestion application
    public MealSuggestionApp() {
        runMealSuggestion();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runMealSuggestion() {
        boolean keepGoing = true;
        String command = null;

        initIngredients();
        initAddIngredientsToMealIngredientListsOne();
        initAddIngredientsToMealIngredientListsTwo();
        initMealsScannerPantry();
        initListOfMeals();
        setAllIngredientLists();

        while (keepGoing) {
            displayMenu();
            command = input.nextLine();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("Goodbye!");
    }

    // MODIFIES: this
    // EFFECTS: initializes ingredients
    private void initIngredients() {
        tomatoes = new Ingredient("tomatoes", 6);
        avocados = new Ingredient("avocados", 7);
        spaghetti = new Ingredient("spaghetti", 3);
        lobster = new Ingredient("lobster", 10);
        bacon = new Ingredient("bacon", 7);
        lettuce = new Ingredient("lettuce", 8);
        eggs = new Ingredient("eggs", 9);
        cheese = new Ingredient("cheese", 5);
        coffee = new Ingredient("coffee", 4);
        ladyfingers = new Ingredient("ladyfingers", 2);
        englishMuffins = new Ingredient("english muffins", 1);
        blueberries = new Ingredient("blueberries", 40);
        pancakes = new Ingredient("pancakes", 3);
        waffles = new Ingredient("waffles", 3);
        potatoes = new Ingredient("potatoes", 3);
        miracleNoodles = new Ingredient("miracle noodles", 1);
        mushrooms = new Ingredient("mushrooms", 8);
        pestoSauce = new Ingredient("pesto sauce", 1);
        chowMeinNoodles = new Ingredient("chow mein noodles", 1);
        chicken = new Ingredient("chicken", 2);
        croutons = new Ingredient("croutons", 20);
        mozzarella = new Ingredient("mozzarella", 10);
        balsamicVinegar = new Ingredient("balsamic vinegar", 1);
    }

    // MODIFIES: this
    // EFFECTS: adds some ingredients to ingredient lists for the meals
    private void initAddIngredientsToMealIngredientListsOne() {
        tofu = new Ingredient("tofu", 4);
        lobsterIngredients.add(spaghetti);
        lobsterIngredients.add(lobster);
        lobsterIngredients.add(bacon);
        tofuSaladIngredients.add(tofu);
        tofuSaladIngredients.add(lettuce);
        tofuSaladIngredients.add(avocados);
        tofuSaladIngredients.add(tomatoes);
        tiramisuIngredients.add(eggs);
        tiramisuIngredients.add(cheese);
        tiramisuIngredients.add(coffee);
        tiramisuIngredients.add(ladyfingers);
        benedictIngredients.add(eggs);
        benedictIngredients.add(avocados);
        benedictIngredients.add(englishMuffins);
        bluePancakesIngredients.add(pancakes);
        bluePancakesIngredients.add(blueberries);
        blueWafflesIngredients.add(waffles);
        blueWafflesIngredients.add(blueberries);
        heartyVeganIngredients.add(avocados);
        heartyVeganIngredients.add(potatoes);
        heartyVeganIngredients.add(tomatoes);
        miracleNoodlesIngredients.add(miracleNoodles);
    }


    // MODIFIES: this
    // EFFECTS: adds rest of ingredients to ingredient lists for the meals
    private void initAddIngredientsToMealIngredientListsTwo() {
        miracleNoodlesIngredients.add(eggs);
        miracleNoodlesIngredients.add(mushrooms);
        pestoPastaIngredients.add(spaghetti);
        pestoPastaIngredients.add(pestoSauce);
        pestoPastaIngredients.add(tomatoes);
        stirFryIngredients.add(chowMeinNoodles);
        stirFryIngredients.add(mushrooms);
        stirFryIngredients.add(tofu);
        chickenCaesarIngredients.add(chicken);
        chickenCaesarIngredients.add(croutons);
        chickenCaesarIngredients.add(lettuce);
        capriIngredients.add(tomatoes);
        capriIngredients.add(mozzarella);
        capriIngredients.add(balsamicVinegar);
    }

    // MODIFIES: this
    // EFFECTS: initializes the meals, scanner and pantry
    public void initMealsScannerPantry() {
        lobsterPasta = new Meal("dairy-free Lobster Pasta", PASTA, 90);
        tofuSalad = new Meal("vegan Tofu Salad",
                SALADS, 30);
        tiramisu = new Meal("Tiramisu", DESSERTS, 180);
        eggsBenedict = new Meal("vegetarian Eggs Benedict", BREAKFAST, 40);
        bluePancakes = new Meal("dairy-free blueberry pancakes", BREAKFAST, 10);
        blueWaffles = new Meal("gluten-free waffles and blueberry sauce", BREAKFAST, 30);
        heartyVegan = new Meal("hearty vegan breakfast", BREAKFAST, 45);
        japaneseMiracleNoodles = new Meal("gluten-free miracle noodles", PASTA, 20);
        pestoPasta = new Meal("vegan pesto spaghetti", PASTA, 60);
        stirFry = new Meal("vegetarian stir fry", PASTA, 40);
        chickenCaesar = new Meal("dairy-free chicken caesar salad", SALADS, 45);
        capriSalad = new Meal("gluten-free capri salad", SALADS, 10);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        newPantry = new Pantry();
    }

    // MODIFIES: this
    // EFFECTS: adds all meals to a list of meals
    public void initListOfMeals() {
        allMeals.add(lobsterPasta);
        allMeals.add(tofuSalad);
        allMeals.add(tiramisu);
        allMeals.add(eggsBenedict);
        allMeals.add(bluePancakes);
        allMeals.add(blueWaffles);
        allMeals.add(heartyVegan);
        allMeals.add(japaneseMiracleNoodles);
        allMeals.add(pestoPasta);
        allMeals.add(stirFry);
        allMeals.add(chickenCaesar);
        allMeals.add(capriSalad);
    }

    // MODIFIES: this
    // EFFECTS: sets all ingredient lists to their corresponding meals
    public void setAllIngredientLists() {
        lobsterPasta.setMealIngredients(lobsterIngredients);
        tofuSalad.setMealIngredients(tofuSaladIngredients);
        tiramisu.setMealIngredients(tiramisuIngredients);
        eggsBenedict.setMealIngredients(benedictIngredients);
        bluePancakes.setMealIngredients(bluePancakesIngredients);
        blueWaffles.setMealIngredients(blueWafflesIngredients);
        pestoPasta.setMealIngredients(pestoPastaIngredients);
        stirFry.setMealIngredients(stirFryIngredients);
        chickenCaesar.setMealIngredients(chickenCaesarIngredients);
        capriSalad.setMealIngredients(capriIngredients);
    }


    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nWelcome!");
        System.out.println("\tTo add an item to your pantry, enter a.");
        System.out.println("\tTo remove an item from your pantry, enter r.");
        System.out.println("\tTo search for a meal suggestion, enter s.");
        System.out.println("\tTo quit the app, enter q.");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            doAddToPantry();
        } else if (command.equals("r")) {
            doRemoveFromPantry();
        } else if (command.equals("s")) {
            filterCookingTime();
            filterDietaryRestrictions();
            filterPantryItems();
            userMakeMeal();
        }
    }

    // MODIFIES: this
    // EFFECTS: adds ingredient to pantry using the ingredient name and amount entered by user
    private void doAddToPantry() {
        System.out.println("What is the name of the item you would like to add to your pantry?");
        String name = input.nextLine();
        System.out.println("How many of these items would you like to add to your pantry?\n");
        int amount = input.nextInt();
        if (amount <= 0) {
            System.out.println("The amount entered must be greater than 0.\n");
        } else {
            Ingredient ing = new Ingredient(name, amount);
            newPantry.addIngredient(ing);
            System.out.println(amount + " units of " + name + " have been successfully added to your pantry!\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: removes amount, entered by the user, of a certain ingredient from pantry if
    // ingredient with name specified by user is in the pantry, otherwise prints out "there is no ingredient with
    // the name (name entered by user) in your pantry"
    private void doRemoveFromPantry() {
        System.out.println("What is the name of the item you would like to remove from your pantry?\n");
        String name = input.nextLine();
        if (newPantry.doesPantryContain(name)) {
            System.out.println("How many of these items would you like to remove from your pantry?\n");
            int amount = input.nextInt();
            newPantry.removeIngredient(name, amount);
            System.out.println(amount + " units of " + name + " were successfully removed from your pantry!\n");
        } else {
            System.out.println("There is no ingredient with the name " + name + " in your pantry.\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: filters the list of available meal suggestions based on the cooking time entered by the user
    private void filterCookingTime() {
        System.out.println("How much time do you have to cook?\n");
        int amount = input.nextInt();
        if (amount < 10) {
            System.out.println("The cooking time entered must be greater than or equal to 10.\n");
        } else {
            allMeals.removeIf(meal -> meal.getCookTime() > amount);
        }
    }

    // MODIFIES: this
    // EFFECTS: filters list of available meals based on the user's dietary restrictions
    private void filterDietaryRestrictions() {
        System.out.println("Do you have any dietary restrictions? Select up to one option.");
        System.out.println("If you are vegetarian, enter 1.");
        System.out.println("If you are vegan, enter 2.");
        System.out.println("If you are dairy-free, enter 3.");
        System.out.println("If you are gluten-free, enter 4.");
        System.out.println("If you do not have any dietary restrictions, enter 0.");
        int restriction = input.nextInt();
        if (restriction == 1) {
            allMeals.removeIf(meal -> !meal.isVegetarian());
        } else if (restriction == 2) {
            allMeals.removeIf(meal -> !meal.isVegan());
        } else if (restriction == 3) {
            allMeals.removeIf(meal -> !meal.isDairyFree());
        } else if (restriction == 4) {
            allMeals.removeIf(meal -> !meal.isGlutenFree());
        } else if (!(restriction == 0)) {
            System.out.println("The selection is not valid.\n");
        }
    }


    // MODIFIES: this
    // EFFECTS: filters the list of meals based on what user has in their pantry
    private void filterPantryItems() {
        if (newPantry.getPantrySize() < 3) {
            System.out.println("You must add more items to your pantry to make a meal.");
        } else {
            Iterator<Meal> mealIterator = allMeals.iterator();
            while (mealIterator.hasNext()) {
                Meal m = mealIterator.next();
                Iterator<Ingredient> ingredientIterator = m.getIngredients().iterator();
                Ingredient i = ingredientIterator.next();
                while (ingredientIterator.hasNext()) {
                    if ((newPantry.doesPantryContain(i.getName())) &&
                            (newPantry.doesPantryHaveEnough(i.getName(), i.getAmount()))) {
                        newMeals.add(m);
                    }
                }
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: user picks meal they want to make and the ingredients list for the selected meal is displayed;
    // prints out "you do not have enough items in your pantry to make any of the meals
    //  that match your preferences." otherwise
    private void userMakeMeal() {
        if (newMeals.isEmpty()) {
            System.out.println("You do not have enough items in your pantry to make any of the meals that "
                    + "match your preferences.");
        } else {
            System.out.println("Which meal would you like to make? Enter the meal name.");
            for (Meal m : allMeals) {
                System.out.println("/" + m.getName() + ", cooking time:" + m.getCookTime());
            }
            String mealName = input.nextLine();
            System.out.println("Would you like to rate this meal? Enter a rating from 1 to 5 to"
                    + "receive a free dessert suggestion!");
            int userRating = input.nextInt();
            for (Meal m : allMeals) {
                if (m.getName().equals(mealName)) {
                    m.setRating(userRating);
                }
            }
            userAccessDessert();
        }
    }

    // MODIFIES: this
    // EFFECTS: allows user to access dessert suggestion
    private void userAccessDessert() {
        tiramisu.setUnlocked();
        System.out.println("You unlocked a dessert suggestion!");
        System.out.println("/" + tiramisu.getName() + ", cooking time:" + tiramisu.getCookTime());
        for (Ingredient i : tiramisuIngredients) {
            System.out.println("/Ingredients needed:");
            System.out.print("/" + i.getName() + "amount:" + i.getAmount());
        }
    }
}
