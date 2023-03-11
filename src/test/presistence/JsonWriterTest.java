package presistence;

import model.Ingredient;
import model.Pantry;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// JSON Writer Test Class
public class JsonWriterTest extends JsonHelperTest {
    private Ingredient tiramisu = new Ingredient("tiramisu", 2);
    private Ingredient vanilla = new Ingredient("vanilla", 1);
    private Ingredient avocados = new Ingredient("avocados", 5);

    @Test
    void testWriterInvalidFile() {
    try {
        Pantry pantry = new Pantry();
        JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
        writer.open();
        fail("IOException was expected");
    } catch (IOException e) {
    }
    }

    @Test
    void testWriterEmptyPantryEmptyGroceryList() {
        try {
            Pantry pantry = new Pantry();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPantryEmptyGroceryList.json");
            writer.open();
            writer.write(pantry);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPantryEmptyGroceryList.json");
            pantry = reader.read();
            assertEquals(0, pantry.getPantrySize());
            assertEquals(0, pantry.toBuyToGroceryList().size());
        } catch (IOException e) {
            fail("Was not expecting IOException");
        }
    }

    @Test
    void testWriterFilledPantryEmptyGroceryList() {
        try {
            Pantry pantry = new Pantry();
            pantry.addIngredient(vanilla);
            pantry.addIngredient(tiramisu);
            JsonWriter writer = new JsonWriter("./data/testWriterFilledPantryEmptyGroceryList.json");
            writer.open();
            writer.write(pantry);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterFilledPantryEmptyGroceryList.json");
            pantry = reader.read();
            assertEquals(0, pantry.toBuyToGroceryList().size());
            assertEquals(2, pantry.getPantrySize());
            checkIngredient("tiramisu", 2, pantry.getIngredientAtIndex(1));
            checkIngredient("vanilla", 1, pantry.getIngredientAtIndex(0));
        } catch (IOException e) {
            fail("Was not expecting IOException");
        }
    }

    @Test
    void testWriterEmptyPantryFilledGroceryList() {
        try {
            Pantry pantry = new Pantry();
            pantry.addIngredient(vanilla);
            pantry.addIngredient(tiramisu);
            vanilla.setToBuyTrue();
            tiramisu.setToBuyTrue();
            assertEquals(2, pantry.toBuyToGroceryList().size());
            pantry.removeIngredient("vanilla", 1);
            pantry.removeIngredient("tiramisu", 2);
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPantryFilledGroceryList.json");
            writer.open();
            writer.write(pantry);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPantryFilledGroceryList.json");
            pantry = reader.read();
            assertEquals(0, pantry.getPantrySize());
            assertEquals(2, pantry.toBuyToGroceryList().size());
            assertTrue(pantry.toBuyToGroceryList().contains("vanilla"));
            assertTrue(pantry.toBuyToGroceryList().contains("tiramisu"));
        } catch (IOException e) {
            fail("Was not expecting IOException");
        }
    }


    @Test
    void testWriterFilledPantryFilledGroceryList() {
        try {
        Pantry pantry = new Pantry();
        pantry.addIngredient(vanilla);
        pantry.addIngredient(tiramisu);
        pantry.addIngredient(avocados);
        vanilla.setToBuyTrue();
        tiramisu.setToBuyTrue();
        avocados.setToBuyTrue();
        assertEquals(3, pantry.toBuyToGroceryList().size());
        pantry.removeIngredient("avocados", 5);
        JsonWriter writer = new JsonWriter("./data/testWriterFilledPantryFilledGroceryList.json");
        writer.open();
        writer.write(pantry);
        writer.close();

        JsonReader reader = new JsonReader("./data/testWriterFilledPantryFilledGroceryList.json");
        pantry = reader.read();
        assertEquals(2, pantry.getPantrySize());
        checkIngredient("vanilla", 1, pantry.getIngredientAtIndex(0));
        checkIngredient("tiramisu", 2, pantry.getIngredientAtIndex(1));
        assertFalse(pantry.doesPantryContain("avocados"));
        assertEquals(3, pantry.toBuyToGroceryList().size());
        assertTrue(pantry.toBuyToGroceryList().contains("vanilla"));
        assertTrue(pantry.toBuyToGroceryList().contains("tiramisu"));
        assertTrue(pantry.toBuyToGroceryList().contains("avocados"));
    } catch (IOException e) {
        fail("Was not expecting IOException");
    }
    }

}
