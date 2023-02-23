package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {
    private Ingredient testIngredient;

    @BeforeEach
    public void setup() {
        testIngredient = new Ingredient("Tomatoes", "february 15");
    }

    @Test
    public void testConstructor() {
        assertEquals("Tomatoes", testIngredient.getName());
        assertEquals("february 15", testIngredient.getExpiryDate());
    }

}
