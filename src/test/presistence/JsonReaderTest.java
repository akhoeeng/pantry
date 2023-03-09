package presistence;

import model.Pantry;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// JSON Reader Test Class
public class JsonReaderTest extends JsonHelperTest {
    private List<String> groceryList1 = new ArrayList<>();
    private List<String> groceryList2 = new ArrayList<>();
    private List<String> groceryList3 = new ArrayList<>();

    @Test
    void testReaderNoFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Pantry pantry = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
        }
    }

    @Test
    void testReaderEmptyPantryEmptyGroceryList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPantryEmptyGroceryList.json");
        try {
            Pantry pantry = reader.read();
            assertEquals(0, pantry.getPantrySize());
            assertEquals(0, pantry.getGroceryList(groceryList1).size());
        } catch (IOException e) {
            fail("Couldn't read from file!");
        }
    }

    @Test
    void testReaderFilledPantryEmptyGroceryList() {
        JsonReader reader = new JsonReader("./data/testReaderFilledPantryEmptyGroceryList.json");
        try {
            Pantry pantry = reader.read();
            assertEquals(2, pantry.getPantrySize());
            assertEquals(0, pantry.getGroceryList(groceryList2));
            checkIngredient("tomatoes", 3, pantry.getIngredientAtIndex(0));
            checkIngredient("pesto", 4, pantry.getIngredientAtIndex(1));
        } catch (IOException e) {
            fail("Couldn't read from file!");
        }
    }

    @Test
    void testReaderEmptyPantryFilledGroceryList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPantryFilledGroceryList.json");
        try {
            Pantry pantry = reader.read();
            assertEquals(0, pantry.getPantrySize());
            assertEquals(2, pantry.getGroceryList(groceryList3).size());
            assertEquals("milk", pantry.getGroceryList(groceryList3).get(0));
            assertEquals("cheese", pantry.getGroceryList(groceryList3).get(1));
        } catch (IOException e) {
            fail("Couldn't read from file!");
        }
    }

    @Test
    void testReaderFilledPantryFilledGroceryList() {
        JsonReader reader = new JsonReader("./data/testReaderFilledPantryFilledGroceryList.json");
        try {
            Pantry pantry = reader.read();
            assertEquals(2,pantry.getPantrySize());
            checkIngredient("tomatoes", 3, pantry.getIngredientAtIndex(0));
            checkIngredient("pesto", 4, pantry.getIngredientAtIndex(1));
            assertEquals(2, pantry.getGroceryList(groceryList3).size());
            assertEquals("milk", pantry.getGroceryList(groceryList3).get(0));
            assertEquals("cheese", pantry.getGroceryList(groceryList3).get(1));
        } catch (IOException e) {
            fail("Couldn't read from file!");
        }
    }
}
