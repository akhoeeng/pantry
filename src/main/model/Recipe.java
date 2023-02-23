package model;

import java.util.List;

// Represents a recipe that has a name, category, cooking time and rating and is either locked or unlocked
public class Recipe {
    private String name;                         // recipe name
    private Category category;                   // category the recipe falls under
    private List<Ingredient> recipeIngredients;  // list of ingredients needed for recipe
    private int rating;                          // recipe rating from 1 to 5; 0 means it has not yet been rated
    private int cookTime;                        // estimated cooking time for recipe in minutes
    private boolean isItLocked;                  // if recipe is locked, it is not accessible to the user

    // REQUIRES: recipe name has a non-zero length, cookTime > 0 and recipeIngredients is a non-empty list
    // EFFECTS: creates a new recipe; sets recipe name, category, cookTime and recipeIngredients
    // to the given name, category, cooking time and list of ingredients; sets rating to 0;
    // sets isItLocked to true if recipe's category is desserts and false otherwise
    public Recipe(String name, Category category, int cookTime, List<Ingredient> ingredients) {

    }

    public String getName() {
        return null;
    }

    public Category getCategory() {
        return null;
    }

    public int getCookTime() {
        return -1;
    }

    public int getRating() {
        return -1;
    }

    public List<Ingredient> getIngredients() {
        return null;
    }

    public boolean getIsItLocked() {
        return false;
    }

    public void setRating(int rating) {

    }

    public void setUnlocked() {

    }

    // EFFECTS: returns true if recipe name contains the strings "vegetarian" or "vegan"
    // and returns false otherwise
    public boolean isVegetarian() {
        return false;
    }

    // EFFECTS: returns true if recipe name contains the string "vegan"
    // and returns false otherwise
    public boolean isVegan() {
        return false;
    }

    // EFFECTS: returns true if recipe name contains the string "gluten-free"
    // and returns false otherwise
    public boolean isGlutenFree() {
        return false;
    }

    // EFFECTS: returns true if recipe name contains the string "dairy-free"
    // and returns false otherwise
    public boolean isDairyFree() {
        return false;
    }

}
