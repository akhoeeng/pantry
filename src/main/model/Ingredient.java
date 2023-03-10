package model;

import org.json.JSONObject;
import presistence.Writable;

// Represents an ingredient with a name and the amount of it; it can be marked as to buy
public class Ingredient implements Writable {
    private final String name;    // name of ingredient
    private int amount;           // amount of ingredient
    private boolean toBuy;        // true if ingredient is marked as toBuy; false otherwise

    // REQUIRES: ingredient name has a non-zero length, amount > 0
    // EFFECTS: creates a new ingredient; sets name of ingredient to given name; sets amount
    // of ingredient to given amount; sets toBuy to false
    public Ingredient(String name, int amount) {
        this.name = name;
        this.amount = amount;
        this.toBuy = false;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getToBuy() {
        return toBuy;
    }

    public void setToBuyTrue() {
        this.toBuy = true;
    }

    // REQUIRES: add > 0
    // MODIFIES: this
    // EFFECTS: adds given amount to ingredient's amount
    public void addAmount(int add) {
        this.amount += add;
    }

    // REQUIRES: 0 < subtract < amount
    // MODIFIES: this
    // EFFECT: subtracts given amount from ingredient's amount
    public void subtractAmount(int subtract) {
        this.amount -= subtract;
    }

    // REQUIRES: name must have a non-empty length and amount > 0
    // EFFECTS: adds the ingredient name and its amount to a new JSON object, then returns it
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("amount", amount);
        return json;
    }
}
