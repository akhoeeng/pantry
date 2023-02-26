package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PantryTest {
    private Pantry testPantry;
    private Ingredient testIngredient1;
    private Ingredient testIngredient2;
    private Ingredient testIngredient3;
    private final List<String> ingredientNames = new ArrayList<>();
    private final List<String> groceryList = new ArrayList<>();


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
    public void testGetIngredientNamesAddOneIngredient() {
        testPantry.addIngredient(testIngredient1);
        assertEquals(ingredientNames, testPantry.getIngredientNames(ingredientNames));
        assertEquals(1, ingredientNames.size());
        assertEquals("tomatoes", ingredientNames.get(0));
    }

    @Test
    public void testGetIngredientNamesAddSameIngredientTwice() {
        testPantry.addIngredient(testIngredient1);
        testPantry.addIngredient(testIngredient1);
        assertEquals(ingredientNames, testPantry.getIngredientNames(ingredientNames));
        assertEquals(1, ingredientNames.size());
        assertEquals("tomatoes", ingredientNames.get(0));
    }

    @Test
    public void testGetIngredientNamesAddMultipleIngredients() {
        testPantry.addIngredient(testIngredient1);
        testPantry.addIngredient(testIngredient2);
        testPantry.addIngredient(testIngredient3);
        assertEquals(ingredientNames, testPantry.getIngredientNames(ingredientNames));
        assertEquals(3, ingredientNames.size());
        assertEquals("tomatoes", ingredientNames.get(0));
        assertEquals("cherries", ingredientNames.get(1));
        assertEquals("bread", ingredientNames.get(2));
    }

    @Test
    public void testGetGroceryList() {
        testPantry.addIngredient(testIngredient1);
        testPantry.addIngredient(testIngredient2);
        testPantry.addIngredient(testIngredient3);
        testIngredient1.setToBuyTrue();
        testIngredient2.setToBuyTrue();
        assertEquals(groceryList, testPantry.getGroceryList(groceryList));
        assertEquals(2, groceryList.size());
        assertEquals("tomatoes", groceryList.get(0));
        assertEquals("cherries", groceryList.get(1));
    }
}