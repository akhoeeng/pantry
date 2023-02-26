package model;

import java.util.ArrayList;
import java.util.List;

// Represents a pantry that has a list of ingredients
public class Pantry {
    private final List<Ingredient> pantry;

    // EFFECTS: creates a new pantry with no ingredients added
    public Pantry() {
        pantry = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds amount of given ingredient to amount of the ingredient already in
    //  the pantry if an ingredient with the same name
    //  is already in the pantry; adds given ingredient to pantry otherwise
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

    // REQUIRES: pantry must not be empty; an ingredient with the given name must be in the pantry;
    // ingredientName has a non-zero length; amount > 0
    // EFFECTS: returns true if amount of ingredient with same name in pantry >= amount,
    // otherwise returns false
    public boolean doesPantryHaveEnough(String ingredientName, int amount) {
        if (getIngredientAtIndex(getIndex(ingredientName)).getAmount() >= amount) {
            return true;
        } else {
            return false;
        }
    }
}

