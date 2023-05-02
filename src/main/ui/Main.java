package ui;

import java.io.FileNotFoundException;

// runs the pantry application
public class Main {
    // EFFECTS: runs a program that allows the user to perform various operations on a pantry with
    // graphics-based and console-based user interaction; prints out
    // "Oops! Could not run application: file not found" otherwise
    public static void main(String[] args) {
        try {
            new MyFrame();
            new PantryApp();
        } catch (FileNotFoundException e) {
            System.out.println("Oops! Could not run application: file not found");
        }
    }

}


