package presistence;

import org.json.JSONObject;

// contains a method that its subclasses can use to add things to a JSON object and return it
public interface Writable {
    // EFFECTS: returns this as a JSON object
    JSONObject toJson();
}
