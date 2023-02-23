package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static model.Category.*;
import static org.junit.jupiter.api.Assertions.*;

public class MealTest {
    private Meal lobsterPasta;
    private Meal tofuSalad;
    private Meal tiramisu;
    private Meal eggsBenedict;
    private final List<Ingredient> pastaIngredients = new ArrayList<>();
    private final List<Ingredient> saladIngredients = new ArrayList<>();
    private final List<Ingredient> tiramisuIngredients = new ArrayList<>();
    private final List<Ingredient> benedictIngredients = new ArrayList<>();
    private Ingredient tofu;
    private Ingredient tomatoes;
    private Ingredient lettuce;
    private Ingredient avocados;
    private Ingredient spaghetti;
    private Ingredient lobster;
    private Ingredient bacon;
    private Ingredient eggs;
    private Ingredient cheese;
    private Ingredient coffee;
    private Ingredient ladyfingers;
    private Ingredient englishMuffins;
    private Ingredient hollandaiseSauce;

    @BeforeEach
    public void setup() {
        tofu = new Ingredient("tofu", 4);
        tomatoes = new Ingredient("tomatoes", 6);
        avocados = new Ingredient("avocados", 7);
        spaghetti = new Ingredient("spaghetti", 3);
        lobster = new Ingredient("lobster", 10);
        bacon = new Ingredient("bacon", 7);
        lettuce = new Ingredient("lettuce", 8);
        eggs = new Ingredient("eggs", 9);
        cheese = new Ingredient("cheese", 5);
        coffee = new Ingredient("coffee", 4);
        ladyfingers = new Ingredient("ladyfingers", 2);
        englishMuffins = new Ingredient("english muffins", 1);
        hollandaiseSauce = new Ingredient("hollandaise sauce", 1);
        lobsterPasta = new Meal("dairy-free Lobster Pasta", PASTA, 120);
        tofuSalad = new Meal("vegan Tofu Salad",
                SALADS, 30);
        tiramisu = new Meal("Tiramisu", DESSERTS, 180);
        eggsBenedict = new Meal("vegetarian Eggs Benedict", BREAKFAST, 40);
        pastaIngredients.add(spaghetti);
        pastaIngredients.add(lobster);
        pastaIngredients.add(bacon);
        saladIngredients.add(tofu);
        saladIngredients.add(lettuce);
        saladIngredients.add(avocados);
        saladIngredients.add(tomatoes);
        tiramisuIngredients.add(eggs);
        tiramisuIngredients.add(cheese);
        tiramisuIngredients.add(coffee);
        tiramisuIngredients.add(ladyfingers);
        benedictIngredients.add(eggs);
        benedictIngredients.add(avocados);
        benedictIngredients.add(englishMuffins);
        benedictIngredients.add(hollandaiseSauce);
    }

    @Test
    public void testConstructor() {
        assertEquals("dairy-free Lobster Pasta", lobsterPasta.getName());
        assertEquals(PASTA, lobsterPasta.getCategory());
        assertEquals(120, lobsterPasta.getCookTime());
        assertEquals(0, lobsterPasta.getRating());
        assertFalse(lobsterPasta.getIsItLocked());
        assertTrue(tiramisu.getIsItLocked());
    }

    @Test
    public void testSetRating() {
        assertEquals(0, tiramisu.getRating());
        tiramisu.setRating(5);
        assertEquals(5, tiramisu.getRating());
        assertEquals(0, lobsterPasta.getRating());
        lobsterPasta.setRating(10);
        assertEquals(0, lobsterPasta.getRating());
    }

    @Test
    public void testSetUnlocked() {
        assertTrue(tiramisu.getIsItLocked());
        tiramisu.setUnlocked();
        assertFalse(tiramisu.getIsItLocked());
    }

    @Test
    public void testSetMealIngredients() {
        tiramisu.setMealIngredients(tiramisuIngredients);
        assertEquals(tiramisuIngredients, tiramisu.getIngredients());
    }

    @Test
    public void testIsVegetarian() {
        assertFalse(lobsterPasta.isVegetarian());
        assertTrue(tofuSalad.isVegetarian());
        assertFalse(tiramisu.isVegetarian());
        assertTrue(eggsBenedict.isVegetarian());
    }

    @Test
    public void testIsVegan() {
        assertFalse(lobsterPasta.isVegan());
        assertTrue(tofuSalad.isVegan());
        assertFalse(tiramisu.isVegan());
        assertFalse(eggsBenedict.isVegan());
    }

    @Test
    public void testIsGlutenFree() {
        assertFalse(lobsterPasta.isGlutenFree());
        assertFalse(tofuSalad.isGlutenFree());
        assertFalse(tiramisu.isGlutenFree());
        assertFalse(eggsBenedict.isGlutenFree());
    }

    @Test
    public void testIsDairyFree() {
        assertTrue(lobsterPasta.isDairyFree());
        assertFalse(tofuSalad.isDairyFree());
        assertFalse(tiramisu.isDairyFree());
        assertFalse(eggsBenedict.isDairyFree());
    }

}


