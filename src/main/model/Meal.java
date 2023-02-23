package model;

import java.util.ArrayList;
import java.util.List;

import static model.Category.*;

// Represents a meal that has a name, category, cooking time, rating and
// list of ingredients; meal is either locked or unlocked
public class Meal {
    private final String name;                      // meal name
    private final Category category;                // category the meal falls under
    private List<Ingredient> mealIngredients = new ArrayList<>();  // list of ingredients needed for meal
    private int rating;                             // meal rating from 1 to 5; 0 means it has not yet been rated
    private final int cookTime;                     // estimated cooking time for meal in minutes
    private boolean isItLocked;                     // if meal is locked, it is not accessible to the user

    // REQUIRES: meal name has a non-zero length and cookTime > 0
    // EFFECTS: creates a new meal; sets meal name, category and cookTime to
    // the given name, category and cooking time; sets rating to 0;
    // sets isItLocked to true if meal's category is desserts and false otherwise
    public Meal(String name, Category category, int cookTime) {
        this.name = name;
        this.category = category;
        this.rating = 0;
        this.cookTime = cookTime;
        if (this.category == DESSERTS) {
            this.isItLocked = true;
        }
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getCookTime() {
        return cookTime;
    }

    public int getRating() {
        return rating;
    }

    public List<Ingredient> getIngredients() {
        return mealIngredients;
    }

    public boolean getIsItLocked() {
        return isItLocked;
    }

    public void setRating(int newRating) {
        if (newRating < 0 || newRating > 5) {
            this.rating = 0;
        } else {
            this.rating = newRating;
        }
    }

    public void setUnlocked() {
        this.isItLocked = false;
    }


    public void setMealIngredients(List<Ingredient> mealIngredients) {
        this.mealIngredients = mealIngredients;
    }

    // EFFECTS: returns true if meal name contains the strings "vegetarian" or "vegan"
    // and returns false otherwise
    public boolean isVegetarian() {
        return this.getName().contains("vegetarian") || this.getName().contains("vegan");

    }

    // EFFECTS: returns true if meal name contains the string "vegan"
    // and returns false otherwise
    public boolean isVegan() {
        return this.getName().contains("vegan");
    }

    // EFFECTS: returns true if meal name contains the string "gluten-free"
    // and returns false otherwise
    public boolean isGlutenFree() {
        return this.getName().contains("gluten-free");
    }


    // EFFECTS: returns true if meal name contains the string "dairy-free"
    // and returns false otherwise
    public boolean isDairyFree() {
        return this.getName().contains("dairy-free");
    }
}
