package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {
    private Ingredient testIngredient;

    @BeforeEach
    public void setup() {
        testIngredient = new Ingredient("tomatoes", 3);
    }

    @Test
    public void testConstructor() {
        assertEquals("tomatoes", testIngredient.getName());
        assertEquals(3, testIngredient.getAmount());
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

}
