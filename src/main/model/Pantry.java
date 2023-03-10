package model;

import org.json.JSONArray;
import org.json.JSONObject;
import presistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a pantry that has a list of ingredients
public class Pantry implements Writable {
    private final List<Ingredient> pantry;                           // a pantry which stores ingredients
    private final List<String> groceryList;                          // list of names of ingredients marked
                                                                     // 'TO BUY' by the user; ingredients do not
                                                                     //  have to currently be in the pantry

    // EFFECTS: creates a new pantry with no ingredients added and a new grocery list with no
    // ingredient names added
    public Pantry() {
        pantry = new ArrayList<>();
        groceryList = new ArrayList<>();
    }

    public List<String> getGroceryList() {
        return this.groceryList;
    }

    // REQUIRES: ingredient name must have non-zero length and amount > 0
    // MODIFIES: this
    // EFFECTS: adds amount of given ingredient to amount of the ingredient already in
    //  the pantry if an ingredient with the same name
    //  is already in the pantry; otherwise it adds new ingredient with given name and amount to pantry
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
    // EFFECTS: subtracts given amount from amount of ingredient with the same name from pantry
    // if amount of ingredient in pantry > given amount, otherwise it removes the ingredient from
    // the pantry altogether
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

    // MODIFIES: this
    // EFFECTS: adds ingredients marked to buy to the given grocery list without duplicates and returns it
    public List<String> toBuyToGroceryList() {
        for (Ingredient i: pantry) {
            if (i.getToBuy() && !this.groceryList.contains(i.getName())) {
                this.groceryList.add(i.getName());
            }
        }
        return this.groceryList;
    }

    // EFFECTS: adds JSON array of ingredients currently in pantry and
    // JSON array of names of ingredients currently marked as 'TO BUY' to a new JSON object then returns it
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("pantry", pantryToJson());
        json.put("grocery list", groceryListToJson());
        return json;
    }

    // EFFECTS: returns ingredients in this pantry as a JSON array
    private JSONArray pantryToJson() {
        JSONArray pantryArray = new JSONArray();
        for (Ingredient i : pantry) {
            pantryArray.put(i.toJson());
        }
        return pantryArray;
    }

    // EFFECTS: returns grocery list as a JSON array
    private JSONArray groceryListToJson() {
        JSONArray groceryListArray = new JSONArray();
        for (String s : this.getGroceryList()) {
            JSONObject groceryListItem = new JSONObject();
            groceryListItem.put("name", s);
            groceryListArray.put(groceryListItem);
        }
        return groceryListArray;
    }
}

