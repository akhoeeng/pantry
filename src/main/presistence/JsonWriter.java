package presistence;

import model.Pantry;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Represents a writer that writes a JSON representation of the current pantry and grocery list into file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter printWriter;
    private String destination;

    // EFFECTS: constructs writer to write to JSON file
    public JsonWriter(String destination) {
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFound exception if file cannot be opened
    public void open() throws FileNotFoundException {
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of pantry and grocery list to file
    public void write(Pantry pantry) {
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
    }
}
