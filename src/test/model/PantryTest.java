package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PantryTest {
    private Pantry testPantry;
    private Ingredient testIngredient1;
    private Ingredient testIngredient2;
    private Ingredient testIngredient3;

    @BeforeEach
    public void setup() {
        testPantry = new Pantry();
        testIngredient1 = new Ingredient("Tomatoes", "February 15");
        testIngredient2 = new Ingredient("Cherries", "August 15");
        testIngredient3 = new Ingredient("Bread", "February 15");
    }

    @Test
    public void testPantryNoIngredientsAdded() {
        assertNull(testPantry.getIngredientAtPosition(0));
        assertEquals(0, testPantry.getPantrySize());
        assertFalse(testPantry.doesPantryContain(testIngredient1));
    }

    @Test
    public void testPantryOneIngredient() {
        testPantry.addIngredient(testIngredient1);
        assertEquals(testIngredient1, testPantry.getIngredientAtPosition(0));
        assertNull(testPantry.getIngredientAtPosition(1));
        assertEquals(1, testPantry.getPantrySize());
        assertTrue(testPantry.doesPantryContain(testIngredient1));
        assertFalse(testPantry.doesPantryContain(testIngredient2));
    }

    @Test
    public void testPantryAddSameIngredientTwice() {
        testPantry.addIngredient(testIngredient1);
        testPantry.addIngredient(testIngredient1);
        assertEquals(testIngredient1, testPantry.getIngredientAtPosition(0));
        assertEquals(testIngredient1, testPantry.getIngredientAtPosition(1));
        assertNull(testPantry.getIngredientAtPosition(2));
        assertEquals(2, testPantry.getPantrySize());
        assertTrue(testPantry.doesPantryContain(testIngredient1));
        assertFalse(testPantry.doesPantryContain(testIngredient2));
    }

    @Test
    public void testPantryAddMultipleIngredients() {
        testPantry.addIngredient(testIngredient1);
        testPantry.addIngredient(testIngredient2);
        testPantry.addIngredient(testIngredient3);
        assertEquals(testIngredient1, testPantry.getIngredientAtPosition(0));
        assertEquals(testIngredient2, testPantry.getIngredientAtPosition(1));
        assertEquals(testIngredient3, testPantry.getIngredientAtPosition(2));
        assertNull(testPantry.getIngredientAtPosition(3));
        assertEquals(3, testPantry.getPantrySize());
        assertTrue(testPantry.doesPantryContain(testIngredient1));
        assertTrue(testPantry.doesPantryContain(testIngredient2));
        assertTrue(testPantry.doesPantryContain(testIngredient3));
    }
}