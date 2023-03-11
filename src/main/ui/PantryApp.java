package ui;

import model.Ingredient;
import model.Pantry;
import org.json.JSONObject;
import presistence.JsonReader;
import presistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Pantry Application
public class PantryApp {
    private Pantry newPantry;
    private List<String> ingredientNames = new ArrayList<>();  // a list of names of ingredients in the user's pantry
    private Scanner input;
    private static final String JSON_STORE = "./data/pantry.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the pantry application
    public PantryApp() throws FileNotFoundException {
        runPantryApplication();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runPantryApplication() {
        boolean keepGoing = true;
        String command = null;

        initScannerPantryJson();

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
    // EFFECTS: initializes scanner, pantry and json reader and writer
    public void initScannerPantryJson() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        newPantry = new Pantry();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nWelcome!");
        System.out.println("\tTo add an item to your pantry, enter a.");
        System.out.println("\tTo remove an item from your pantry, enter r.");
        System.out.println("\tTo see everything that you currently have in your pantry, enter s.");
        System.out.println("\tTo mark an item in your pantry as 'TO BUY', enter m.");
        System.out.println("\tTo save your current pantry and grocery list, enter p.");
        System.out.println("\tTo load your saved pantry and grocery list on file, press g.");
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
            doPrintAllIngredientNames();
        } else if (command.equals("m")) {
            doMarkItemAsToBuy();
        } else if (command.equals("p")) {
            doSavePantryToFile();
        } else if (command.equals("g")) {
            doLoadPantryFromFile();
        } else {
            System.out.println("The selection is not valid.\n");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds ingredient to pantry using the ingredient name and amount entered by user
    // and adds ingredient name to ingredientNames if it is not already in the list
    private void doAddToPantry() {
        System.out.println("What is the name of the item you would like to add to your pantry?");
        String name = input.nextLine();
        System.out.println("How many of these items would you like to add to your pantry?\n");
        int amount = input.nextInt();
        if (amount <= 0) {
            System.out.println("The amount entered must be greater than 0.\n");
            input.nextLine();
        } else {
            Ingredient ing = new Ingredient(name, amount);
            newPantry.addIngredient(ing);
            if (!ingredientNames.contains(name)) {
                ingredientNames.add(name);
            }
            System.out.println(amount + " units of " + name + " have been successfully added to your pantry!\n");
            int newAmount = newPantry.getIngredientAtIndex(newPantry.getIndex(name)).getAmount();
            System.out.println("You now have " + newAmount + " units of " + name + " in your pantry.\n");
            input.nextLine();
        }
    }

    // MODIFIES: this
    // EFFECTS: removes ingredient from pantry using the ingredient name and amount entered by user
    // and removes ingredient name from ingredientNames if the new ingredient amount in the pantry equals 0
    private void doRemoveFromPantry() {
        System.out.println("What is the name of the item you would like to remove from your pantry?\n");
        String name = input.nextLine();
        if (newPantry.doesPantryContain(name)) {
            System.out.println("How many of these items would you like to remove from your pantry?\n");
            int amount = input.nextInt();
            int realAmount = newPantry.getIngredientAtIndex(newPantry.getIndex(name)).getAmount();
            if (realAmount < amount) {
                System.out.println("You only have " + realAmount + " units of " + name + " in your pantry.");
                input.nextLine();
            } else {
                newPantry.removeIngredient(name, amount);
                System.out.println(amount + " units of " + name + " were successfully removed from your pantry!\n");
                input.nextLine();
                if (newPantry.doesPantryContain(name)) {
                    int newRealAmount = newPantry.getIngredientAtIndex(newPantry.getIndex(name)).getAmount();
                    System.out.println("You now have " + newRealAmount + " units of " + name + " left in your pantry.");
                } else {
                    removeFromIngredientNamesAndPrint(name);
                }
            }
        } else {
            System.out.println("There is no ingredient with the name " + name + " in your pantry.\n");
        }
    }

    // REQUIRES: pantry must not contain an ingredient with the given name
    // MODIFIES: this
    // EFFECTS: removes given name from ingredientNames and prints out "You now have 0 units of (given name)
    // left in your pantry."
    private void removeFromIngredientNamesAndPrint(String ingredientName) {
        ingredientNames.remove(ingredientName);
        System.out.println("You now have 0 units of " + ingredientName + " left in your pantry.");
    }

    // MODIFIES: this
    // EFFECTS: prints out all the elements of ingredientNames
    private void doPrintAllIngredientNames() {
        if (newPantry.getPantrySize() == 0) {
            System.out.println("There are currently no items in your pantry.");
        } else {
            System.out.println("Here is a list of the names of all of the items currently in your pantry:");
            for (String s : ingredientNames) {
                System.out.println(s);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: marks ingredient as to buy
    private void doMarkItemAsToBuy() {
        System.out.println("Which ingredient would you like to mark as 'TO BUY'?");
        String itemToBuy = input.nextLine();
        if (newPantry.doesPantryContain(itemToBuy)) {
            newPantry.getIngredientAtIndex(newPantry.getIndex(itemToBuy)).setToBuyTrue();
            System.out.println("The item " + itemToBuy + " was successfully marked as 'TO BUY'!");
            System.out.println("Your grocery list has been updated:");
            for (String s : newPantry.toBuyToGroceryList()) {
                System.out.println(s);
            }
        } else {
            System.out.println("This ingredient is not in your pantry.");
        }
    }

    // EFFECTS: saves the user's current pantry and grocery list to file
    private void doSavePantryToFile() {
        try {
            jsonWriter.open();
            jsonWriter.write(newPantry);
            jsonWriter.close();
            System.out.println("Your pantry and grocery list were successfully saved to file: " + JSON_STORE + " !");
        } catch (FileNotFoundException e) {
            System.out.println("Oops! Unable to save pantry and grocery list to file " + JSON_STORE);
        }
    }

    // EFFECTS: loads the pantry and grocery list from file
    private void doLoadPantryFromFile() {
        try {
            newPantry = jsonReader.read();
            for (String s : newPantry.makeListOfNames()) {
                if (!ingredientNames.contains(s)) {
                    ingredientNames.add(s);
                }
            }
            System.out.println("Your pantry and grocery list were successfully loaded from file: " + JSON_STORE + " !");
        } catch (IOException e) {
            System.out.println("Oops! Unable to load pantry and grocery list from file: " + JSON_STORE);
        }
    }
}



