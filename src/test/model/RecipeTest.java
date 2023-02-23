package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static model.Category.*;
import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {
    private Recipe lobsterPasta;
    private Recipe tofuSalad;
    private Recipe tiramisu;
    private Recipe eggsBenedict;
    private List<Ingredient> pastaIngredients;
    private List<Ingredient> saladIngredients;
    private List<Ingredient> tiramisuIngredients;
    private List<Ingredient> benedictIngredients;
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
        tofu = new Ingredient("Tofu", "june 1");
        tomatoes = new Ingredient("Tomatoes", "may 12");
        avocados = new Ingredient("Avocados", "may 1");
        spaghetti = new Ingredient("Spaghetti", "december 1");
        lobster = new Ingredient("Lobster", "may 2");
        bacon = new Ingredient("Bacon", "june 4");
        lettuce = new Ingredient("Lettuce", "may 4");
        eggs = new Ingredient("Eggs", "may 14");
        cheese = new Ingredient("Cheese", "july 6");
        coffee = new Ingredient("Lettuce", "may 4");
        ladyfingers = new Ingredient("Ladyfingers", "may 2");
        englishMuffins = new Ingredient("English Muffins", "june 1");
        hollandaiseSauce = new Ingredient("Hollandaise Sauce", "may 7");
        pastaIngredients = new ArrayList<>();
        pastaIngredients.add(spaghetti);
        pastaIngredients.add(lobster);
        pastaIngredients.add(bacon);
        saladIngredients = new ArrayList<>();
        saladIngredients.add(tofu);
        saladIngredients.add(lettuce);
        saladIngredients.add(avocados);
        saladIngredients.add(tomatoes);
        tiramisuIngredients = new ArrayList<>();
        tiramisuIngredients.add(eggs);
        tiramisuIngredients.add(cheese);
        tiramisuIngredients.add(coffee);
        tiramisuIngredients.add(ladyfingers);
        benedictIngredients = new ArrayList<>();
        benedictIngredients.add(eggs);
        benedictIngredients.add(avocados);
        benedictIngredients.add(englishMuffins);
        benedictIngredients.add(hollandaiseSauce);
        lobsterPasta = new Recipe("Dairy-free Lobster Pasta", PASTA, 120, pastaIngredients);
        tofuSalad = new Recipe("Vegan, dairy-free and gluten-free Tofu Salad",
                SALADS, 30, saladIngredients);
        tiramisu = new Recipe ("Tiramisu", DESSERTS, 180, tiramisuIngredients);
        eggsBenedict = new Recipe("Vegetarian Eggs Benedict", BREAKFAST, 40, benedictIngredients);
    }

    @Test
    public void testConstructor() {
        assertEquals("Dairy-free Lobster Pasta", lobsterPasta.getName());
        assertEquals(PASTA, lobsterPasta.getCategory());
        assertEquals(120, lobsterPasta.getCookTime());
        assertEquals(0, lobsterPasta.getRating());
        assertEquals(pastaIngredients, lobsterPasta.getIngredients());
        assertFalse(lobsterPasta.getIsItLocked());
        assertTrue(tiramisu.getIsItLocked());
    }

    @Test
    public void testSetRatingAndSetUnlocked() {
        assertEquals(0, tiramisu.getRating());
        tiramisu.setRating(5);
        assertEquals(5, tiramisu.getRating());
        assertTrue(tiramisu.getIsItLocked());
        tiramisu.setUnlocked();
        assertFalse(tiramisu.getIsItLocked());
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
        assertTrue(tofuSalad.isGlutenFree());
        assertFalse(tiramisu.isGlutenFree());
        assertFalse(eggsBenedict.isGlutenFree());
    }

    @Test
    public void testIsDairyFree() {
        assertTrue(lobsterPasta.isDairyFree());
        assertTrue(tofuSalad.isDairyFree());
        assertFalse(tiramisu.isDairyFree());
        assertFalse(eggsBenedict.isDairyFree());
    }

}


