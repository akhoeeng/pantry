package presistence;

import model.Ingredient;
import model.Pantry;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads the pantry and grocery list on JSON file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from JSON file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads pantry on file and returns it; throws IO exception if an error occurs
    public Pantry read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parsePantry(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String file) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // MODIFIES: pantry
    // EFFECTS: parses pantry from JSON object and returns it
    private Pantry parsePantry(JSONObject jsonObject) {
        Pantry pantry = new Pantry();
        addAllItemsToPantry(pantry, jsonObject);
        for (String s : pantry.getGroceryList()) {
            if (pantry.doesPantryContain(s)) {
                pantry.getIngredientAtIndex(pantry.getIndex(s)).setToBuyTrue();
            }
        }
        return pantry;
    }

    // MODIFIES: pantry
    // EFFECTS: parses pantry and its grocery list from JSON object and adds them to pantry and/or grocery list
    private void addAllItemsToPantry(Pantry pantry, JSONObject jsonObject) {
        JSONArray pantryArray = jsonObject.getJSONArray("pantry");
        for (Object json : pantryArray) {
            JSONObject ingredient = (JSONObject) json;
            addToPantry(pantry, ingredient);
        }
        JSONArray groceryArray = jsonObject.getJSONArray("grocery list");
        for (Object json : groceryArray) {
            JSONObject name = (JSONObject) json;
            addToGroceryList(pantry, name);
        }
    }


    // MODIFIES: pantry
    // EFFECTS: parses ingredient from JSON object and adds it to pantry
    private void addToPantry(Pantry pantry, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int amount = jsonObject.getInt("amount");
        Ingredient ingredient = new Ingredient(name, amount);
        pantry.addIngredient(ingredient);
    }

    // MODIFIES: pantry
    // EFFECTS: parses ingredient names from JSON object and adds them to the pantry's grocery list
    private void addToGroceryList(Pantry pantry, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        pantry.getGroceryList().add(name);
    }

}
