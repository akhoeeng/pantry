package model;

// Represents an ingredient with a name and the amount of it
public class Ingredient {
    private final String name;    // name of ingredient
    private int amount;           // amount of ingredient

    // REQUIRES: ingredient name has a non-zero length, amount > 0
    // EFFECTS: creates a new ingredient; sets name of ingredient to given name; sets amount
    // of ingredient to given amount
    public Ingredient(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
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
}
