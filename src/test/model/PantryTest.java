package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presistence.JsonReader;
import presistence.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Pantry Test Class
public class PantryTest {
    private Pantry testPantry;
    private Ingredient testIngredient1;
    private Ingredient testIngredient2;
    private Ingredient testIngredient3;
    private List<String> ingredientNames = new ArrayList<>();


    @BeforeEach
    public void setup() {
        testPantry = new Pantry();
        testIngredient1 = new Ingredient("tomatoes", 3);
        testIngredient2 = new Ingredient("cherries", 2);
        testIngredient3 = new Ingredient("bread", 1);
    }

    @Test
    public void testPantryNoIngredientsAdded() {
        assertEquals(0, testPantry.getPantrySize());
        assertFalse(testPantry.doesPantryContain("tomatoes"));
        assertEquals(-1, testPantry.getIndex("tomatoes"));
    }

    @Test
    public void testPantryAddOneIngredient() {
        testPantry.addIngredient(testIngredient1);
        assertEquals(0, testPantry.getIndex("tomatoes"));
        assertEquals(testIngredient1, testPantry.getIngredientAtIndex(0));
        assertEquals(1, testPantry.getPantrySize());
        assertTrue(testPantry.doesPantryContain("tomatoes"));
    }

    @Test
    public void testPantryAddSameIngredientTwice() {
        testPantry.addIngredient(testIngredient1);
        testPantry.addIngredient(testIngredient1);
        assertEquals(0, testPantry.getIndex("tomatoes"));
        assertEquals(testIngredient1, testPantry.getIngredientAtIndex(0));
        assertEquals(1, testPantry.getPantrySize());
        assertTrue(testPantry.doesPantryContain("tomatoes"));
        assertEquals(6, testPantry.getIngredientAtIndex(0).getAmount());
    }

    @Test
    public void testPantryAddMultipleIngredients() {
        testPantry.addIngredient(testIngredient1);
        testPantry.addIngredient(testIngredient2);
        testPantry.addIngredient(testIngredient3);
        assertEquals(0, testPantry.getIndex("tomatoes"));
        assertEquals(1, testPantry.getIndex("cherries"));
        assertEquals(2, testPantry.getIndex("bread"));
        assertEquals(testIngredient1, testPantry.getIngredientAtIndex(0));
        assertEquals(testIngredient2, testPantry.getIngredientAtIndex(1));
        assertEquals(testIngredient3, testPantry.getIngredientAtIndex(2));
        assertEquals(3, testPantry.getPantrySize());
        assertTrue(testPantry.doesPantryContain("tomatoes"));
        assertTrue(testPantry.doesPantryContain("cherries"));
        assertTrue(testPantry.doesPantryContain("bread"));
    }

    @Test
    public void testRemoveIngredientRemoveOneUnit() {
        testPantry.addIngredient(testIngredient1);
        testPantry.removeIngredient("tomatoes", 1);
        assertEquals(1, testPantry.getPantrySize());
        assertEquals(testIngredient1, testPantry.getIngredientAtIndex(0));
        assertEquals(2, testPantry.getIngredientAtIndex(0).getAmount());
        assertTrue(testPantry.doesPantryContain("tomatoes"));
    }

    @Test
    public void testRemoveIngredientRemoveEntireIngredient() {
        testPantry.addIngredient(testIngredient1);
        testPantry.removeIngredient("tomatoes", 3);
        assertEquals(0, testPantry.getPantrySize());
        assertFalse(testPantry.doesPantryContain("tomatoes"));
        assertEquals(-1, testPantry.getIndex("tomatoes"));
    }


    @Test
    public void testGetIndexNoSuchIngredientWithName() {
        testPantry.addIngredient(testIngredient1);
        testPantry.addIngredient(testIngredient2);
        testPantry.addIngredient(testIngredient3);
        assertEquals(0, testPantry.getIndex("tomatoes"));
        assertEquals(1, testPantry.getIndex("cherries"));
        assertEquals(2, testPantry.getIndex("bread"));
        assertEquals(-1, testPantry.getIndex("arugula"));
        assertEquals(-1, testPantry.getIndex("hungry"));

    }

    @Test
    public void testGetIngredientAtIndex() {
        testPantry.addIngredient(testIngredient1);
        assertEquals(testIngredient1, testPantry.getIngredientAtIndex(0));
        testPantry.addIngredient(testIngredient2);
        assertEquals(testIngredient1, testPantry.getIngredientAtIndex(0));
        assertEquals(testIngredient2, testPantry.getIngredientAtIndex(1));
        testPantry.addIngredient(testIngredient3);
        assertEquals(testIngredient1, testPantry.getIngredientAtIndex(0));
        assertEquals(testIngredient2, testPantry.getIngredientAtIndex(1));
        assertEquals(testIngredient3, testPantry.getIngredientAtIndex(2));
    }

    @Test
    public void testGetPantrySize() {
        testPantry.addIngredient(testIngredient1);
        assertEquals(1, testPantry.getPantrySize());
        testPantry.addIngredient(testIngredient1);
        testPantry.addIngredient(testIngredient1);
        assertEquals(1, testPantry.getPantrySize());
        testPantry.addIngredient(testIngredient2);
        assertEquals(2, testPantry.getPantrySize());
        testPantry.addIngredient(testIngredient2);
        testPantry.addIngredient(testIngredient3);
        assertEquals(3, testPantry.getPantrySize());
    }

    @Test
    public void testDoesPantryContainDoesNotContain() {
        testPantry.addIngredient(testIngredient1);
        testPantry.addIngredient(testIngredient2);
        testPantry.addIngredient(testIngredient3);
        assertTrue(testPantry.doesPantryContain("tomatoes"));
        assertTrue(testPantry.doesPantryContain("cherries"));
        assertTrue(testPantry.doesPantryContain("bread"));
        assertFalse(testPantry.doesPantryContain("hungry"));
        assertFalse(testPantry.doesPantryContain("arugula"));
    }

    @Test
    public void testToBuyToGroceryList() {
        testPantry.addIngredient(testIngredient1);
        testPantry.addIngredient(testIngredient2);
        testPantry.addIngredient(testIngredient3);
        testIngredient1.setToBuyTrue();
        testIngredient2.setToBuyTrue();
        assertEquals(testPantry.getGroceryList(), testPantry.toBuyToGroceryList());
        assertEquals(2, testPantry.getGroceryList().size());
        assertEquals("tomatoes", testPantry.getGroceryList().get(0));
        assertEquals("cherries", testPantry.getGroceryList().get(1));
    }

    @Test
    public void testMakeListOfNames() {
        testPantry.addIngredient(testIngredient1);
        testPantry.addIngredient(testIngredient2);
        ingredientNames = testPantry.makeListOfNames();
        assertEquals(2, ingredientNames.size());
        assertTrue(ingredientNames.contains("tomatoes"));
        assertTrue(ingredientNames.contains("cherries"));
    }

    @Test
    public void testToJson() {
        try {
            testPantry.addIngredient(testIngredient1);
            testPantry.addIngredient(testIngredient2);
            testPantry.addIngredient(testIngredient3);
            testIngredient1.setToBuyTrue();
            testIngredient2.setToBuyTrue();
            testIngredient3.setToBuyTrue();
            assertEquals(3, testPantry.toBuyToGroceryList().size());
            testPantry.removeIngredient("bread", 1);
            JsonWriter writer = new JsonWriter("./data/pantryTestToJson.json");
            writer.open();
            writer.write(testPantry);
            writer.close();

            JsonReader reader = new JsonReader("./data/pantryTestToJson.json");
            testPantry = reader.read();
            assertEquals(2, testPantry.getPantrySize());
            assertTrue(testPantry.doesPantryContain("tomatoes"));
            assertTrue(testPantry.doesPantryContain("cherries"));
            assertFalse(testPantry.doesPantryContain("bread"));
            assertEquals(3, testPantry.toBuyToGroceryList().size());
            assertTrue(testPantry.toBuyToGroceryList().contains("tomatoes"));
            assertTrue(testPantry.toBuyToGroceryList().contains("cherries"));
            assertTrue(testPantry.toBuyToGroceryList().contains("bread"));
        } catch (IOException e) {
            fail("Was not expecting IOException");
        }
    }

    @Test
    public void testPantryToJson() {
        try {
            testPantry.addIngredient(testIngredient1);
            testPantry.addIngredient(testIngredient2);
            testPantry.addIngredient(testIngredient3);
            JsonWriter writer = new JsonWriter("./data/pantryTestPantryToJson.json");
            writer.open();
            writer.write(testPantry);
            writer.close();

            JsonReader reader = new JsonReader("./data/pantryTestPantryToJson.json");
            testPantry = reader.read();
            assertEquals(3, testPantry.getPantrySize());
            assertTrue(testPantry.doesPantryContain("tomatoes"));
            assertTrue(testPantry.doesPantryContain("cherries"));
            assertTrue(testPantry.doesPantryContain("bread"));
            assertEquals(0, testPantry.toBuyToGroceryList().size());
        } catch (IOException e) {
            fail("Was not expecting IOException");
        }
    }

    @Test
    public void testGroceryListToJson() {
        try {
            testPantry.addIngredient(testIngredient1);
            testPantry.addIngredient(testIngredient2);
            testPantry.addIngredient(testIngredient3);
            testIngredient1.setToBuyTrue();
            testIngredient2.setToBuyTrue();
            testIngredient3.setToBuyTrue();
            assertEquals(3, testPantry.toBuyToGroceryList().size());
            testPantry.removeIngredient("bread", 1);
            JsonWriter writer = new JsonWriter("./data/pantryTestGroceryListToJson.json");
            writer.open();
            writer.write(testPantry);
            writer.close();

            JsonReader reader = new JsonReader("./data/pantryTestGroceryListToJson.json");
            testPantry = reader.read();
            assertEquals(3, testPantry.toBuyToGroceryList().size());
            assertTrue(testPantry.toBuyToGroceryList().contains("tomatoes"));
            assertTrue(testPantry.toBuyToGroceryList().contains("cherries"));
            assertTrue(testPantry.toBuyToGroceryList().contains("bread"));
        } catch (IOException e) {
            fail("Was not expecting IOException");
        }
    }
}