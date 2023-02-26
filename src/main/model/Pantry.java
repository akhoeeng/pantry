package model;

import java.util.ArrayList;
import java.util.List;

// Represents a pantry that has a list of ingredients
public class Pantry {
    private final List<Ingredient> pantry;
    private final List<String> ingredientNames = new ArrayList<>();
    private final List<String> groceryList = new ArrayList<>();

    // EFFECTS: creates a new pantry with no ingredients added
    public Pantry() {
        pantry = new ArrayList<>();
    }

    // REQUIRES: ingredient name must have non-zero length and amount > 0
    // MODIFIES: this
    // EFFECTS: adds amount of given ingredient to amount of the ingredient already in
    //  the pantry if an ingredient with the same name
    //  is already in the pantry; adds new ingredient with given name and amount to pantry otherwise
    public void addIngredient(Ingredient ingredient) {
        if (this.doesPantryContain(ingredient.getName())) {
            getIngredientAtIndex(this.getIndex(ingredient.getName())).addAmount(ingredient.getAmount());
        } else {
            pantry.add(ingredient);
        }
    }

    // REQUIRES: ingredient with the same name as the one given must be in the pantry
    // and pantry must not be empty
    // MODIFIES: this
    // EFFECTS: subtracts given amount from amount of ingredient with the same name from pantry;
    // removes the ingredient altogether if amount of ingredient in pantry <= given amount
    public void removeIngredient(String ingredientName, int amount) {
        if (amount >= getIngredientAtIndex(getIndex(ingredientName)).getAmount()) {
            pantry.remove(getIndex(ingredientName));
        } else {
            getIngredientAtIndex(getIndex(ingredientName)).subtractAmount(amount);
        }
    }


    // REQUIRES: ingredientName must be of non-zero length
    // EFFECTS: returns position in pantry of ingredient in pantry with the same name, otherwise returns -1
    public int getIndex(String ingredientName) {
        for (Ingredient i : pantry) {
            if ((i.getName()).equals(ingredientName)) {
                return pantry.indexOf(i);
            }
        }
        return -1;
    }


    // REQUIRES: pantry must not be empty and there must be something in the pantry at the given index
    // EFFECTS: returns the ingredient in the pantry at the given index
    public Ingredient getIngredientAtIndex(int index) {
        return pantry.get(index);
    }


    // EFFECTS: returns number of ingredients currently in the pantry
    public int getPantrySize() {
        return pantry.size();
    }

    // REQUIRES: ingredientName has a non-zero length
    // EFFECTS: returns true if an ingredient with the same name is
    // already in the pantry and returns false otherwise
    public boolean doesPantryContain(String ingredientName) {
        for (Ingredient i : pantry) {
            if ((i.getName()).equals(ingredientName)) {
                return true;
            }
        }
        return false;
    }

    // REQUIRES: pantry must not be empty
    // EFFECTS: adds all names of ingredients currently in the pantry to the given list
    public List<String> getIngredientNames(List<String> ingredientNames) {
        for (Ingredient i : pantry) {
            ingredientNames.add(i.getName());
        }
        return ingredientNames;
    }

    // REQUIRES: pantry is not empty
    // EFFECTS: adds ingredients marked to buy to the given grocery list and returns the grocery list
    public List<String> getGroceryList(List<String> groceryList) {
        for (Ingredient i: pantry) {
            if (i.getToBuy()) {
                groceryList.add(i.getName());
            }
        }
        return groceryList;
    }
}

