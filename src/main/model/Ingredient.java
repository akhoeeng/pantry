package model;

// Represents an ingredient with a name and an expiry date
public class Ingredient {
    private String name;    // name of ingredient
    private String expiryDate; // date of expiration of ingredient in the year 2023

    // REQUIRES: ingredient name has a non-zero length, expiryDate > 0101 and is in the year 2023
    // EFFECTS: creates a new ingredient; sets name of ingredient to given name; sets expiry date of
    // ingredient to given expiry date
    public Ingredient(String name, String expiryDate) {

    }

    public String getName() {
        return null;
    }

    public String getExpiryDate() {
        return null;
    }

}
