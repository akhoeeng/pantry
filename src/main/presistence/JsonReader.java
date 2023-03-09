package presistence;

import model.Pantry;
import org.json.JSONObject;

import java.io.IOException;

// Represents a reader that reads the pantry and grocery list on JSON file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from JSON file
    public JsonReader(String source) {
    }

    // EFFECTS: reads pantry on file and returns it; throws IO exception if an error occurs
    public Pantry read() throws IOException {
        // add grocery list method here
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String file) throws IOException {
        return null;
    }

    // MODIFIES: pantry
    // EFFECTS: parses pantry from JSON object and returns it
    private Pantry parsePantry(JSONObject jsonObject) {
        return null;
    }

    // MODIFIES: pantry
    // EFFECTS: parses ingredients from JSON object and adds them to pantry
    private void parseIngredientsAdd(Pantry pantry, JSONObject jsonObject) {

    }

    // MODIFIES: pantry
    // EFFECTS: marks ingredients listed in grocery list on file as 'TO BUY'
    private void readGroceryListAndMark() {

    }

}
