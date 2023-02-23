package model;

import java.util.ArrayList;
import java.util.List;

// Represents a pantry that has a list of ingredients
public class Pantry {
    private List<Ingredient> pantry;

    // EFFECTS: creates a new pantry with no ingredients added
    public Pantry() {
    }

    // MODIFIES: this
    // EFFECTS: adds given ingredient to pantry
    public void addIngredient(Ingredient ingredient) {

    }

    // EFFECTS: returns ingredient with the given position in the pantry
    // and returns null otherwise
    public Ingredient getIngredientAtPosition(int index) {
        return null;
    }

    // EFFECTS: returns number of ingredients currently in the pantry
    public int getPantrySize() {
        return -1;
    }

    // EFFECTS: returns true if given ingredient is currently in the pantry
    // and returns false otherwise
    public boolean doesPantryContain(Ingredient ingredient) {
        return false;
    }

}
