package presistence;

import model.Ingredient;

import static org.junit.jupiter.api.Assertions.assertEquals;

// contains a testing helper method for the Json Reader and Json Writer Test Classes
public class JsonHelperTest {
    // REQUIRES: name has a non-empty length, amount > 0 and ingredient is not null
    // EFFECTS: method runs if name of given ingredient is the same as given name and amount of given ingredient
    // is the same as given amount, otherwise the method fails
    protected void checkIngredient(String name, int amount, Ingredient ingredient) {
        assertEquals(name, ingredient.getName());
        assertEquals(amount, ingredient.getAmount());
    }
}
