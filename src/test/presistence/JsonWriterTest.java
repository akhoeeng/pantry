package presistence;

import model.Pantry;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

// JSON Writer Test Class
public class JsonWriterTest extends JsonHelperTest {
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
    void testWriterEmptyPantryEmptyWorklist() {
        try {

        }

    }

}
