package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presistence.JsonReader;
import presistence.JsonWriter;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

// Ingredient Test Class
public class IngredientTest {
    private Ingredient testIngredient;
    private Pantry testPantry;

    @BeforeEach
    public void setup() {
        testIngredient = new Ingredient("tomatoes", 3);
        testPantry = new Pantry();
    }

    @Test
    public void testConstructor() {
        assertEquals("tomatoes", testIngredient.getName());
        assertEquals(3, testIngredient.getAmount());
        assertFalse(testIngredient.getToBuy());
    }

    @Test
    public void testAddOneAmount() {
        testIngredient.addAmount(5);
        assertEquals(8, testIngredient.getAmount());
    }

    @Test
    public void testAddSeveralAmounts() {
        testIngredient.addAmount(5);
        testIngredient.addAmount(8);
        assertEquals(16, testIngredient.getAmount());
    }

    @Test
    public void testSubtractOneAmount() {
        testIngredient.subtractAmount(1);
        assertEquals(2, testIngredient.getAmount());
    }

    @Test
    public void testSubtractSeveralAmounts() {
        testIngredient.subtractAmount(1);
        testIngredient.subtractAmount(1);
        assertEquals(1, testIngredient.getAmount());
    }

    @Test
    public void testSetToBuyTrue() {
        testIngredient.setToBuyTrue();
        assertTrue(testIngredient.getToBuy());
    }

    @Test
    public void testToJson() {
        try {
            testPantry.addIngredient(testIngredient);
            JsonWriter writer = new JsonWriter("./data/ingredientTestToJson.json");
            writer.open();
            writer.write(testPantry);
            writer.close();

            JsonReader reader = new JsonReader("./data/ingredientTestToJson.json");
            testPantry = reader.read();
            assertEquals("tomatoes", testPantry.getIngredientAtIndex(0).getName());
            assertEquals(3, testPantry.getIngredientAtIndex(0).getAmount());
        } catch (IOException e) {
            fail("Was not expecting IOException");
        }

    }



}
