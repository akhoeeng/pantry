package ui;

import model.Ingredient;
import model.Pantry;
import presistence.JsonReader;
import presistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// JFrame representing the Pantry
public class MyFrame extends JFrame implements ActionListener {
    private JButton submit;
    private JButton addButton;
    private JTextField textField;
    private String ingredientName;
    private JButton saveButton;
    private JButton loadButton;
    private Pantry pantry;
    private static final String JSON_STORE = "./data/gui.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // MODIFIES: this
    // EFFECTS: displays new JFrame window with buttons and an empty pantry
    MyFrame() {
        this.setSize(800, 800);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addWindowListener(new MyWindowAdapter());
        addButtons();
        initializePantryReaderAndWriter();
        this.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: adds buttons to JFrame
    private void addButtons() {
        addButton = new JButton("Add Ingredient");
        addButton.setBounds(25, 25, 150, 50);
        addButton.addActionListener(this);
        this.add(addButton);
        saveButton = new JButton("Save Current Pantry");
        saveButton.setBounds(25, 50, 150, 50);
        saveButton.addActionListener(this);
        this.add(saveButton);
        loadButton = new JButton("Load Previously Saved Pantry");
        loadButton.setBounds(25, 75, 150, 50);
        loadButton.addActionListener(this);
        this.add(loadButton);
    }

    // MODIFIES: this
    // EFFECTS: performs different actions based on which buttons are pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            JFrame nameFrame = new JFrame();
            setUpNewWindow(nameFrame);
            textField = new JTextField();
            textField.setPreferredSize(new Dimension(200, 30));
            nameFrame.add(textField);
            textField.setText("Enter name of ingredient");
        } else if (e.getSource() == submit) {
            ingredientName = textField.getText();
            Ingredient ingredient = new Ingredient(ingredientName, 1);
            pantry.addIngredient(ingredient);
            NewApplePanel applePanel = new NewApplePanel(pantry);
            applePanel.getLabel().setText(ingredientName);
            this.add(applePanel);
            this.setVisible(true);
        } else if (e.getSource() == saveButton) {
            saveGUItoFile();
        } else if (e.getSource() == loadButton) {
            loadGuiFromFile();
        }
    }

    // MODIFIES: this
    // EFFECTS: sets up the new window for entering ingredient name
    public void setUpNewWindow(JFrame jframe) {
        jframe.setSize(2000, 200);
        jframe.setLayout(new FlowLayout());
        jframe.setVisible(true);
        jframe.setBounds(0, 0, 200, 200);
        submit = new JButton("Submit Name");
        submit.addActionListener(this);
        jframe.add(submit);
    }

    //MODIFIES: this
    //EFFECTS: initializes the pantry, JSON writer and JSON reader
    public void initializePantryReaderAndWriter() {
        pantry = new Pantry();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    //MODIFIES: this
    //EFFECTS: saves pantry to JSON file
    public void saveGUItoFile() {
        try {
            jsonWriter.open();
            jsonWriter.write(pantry);
            jsonWriter.close();
            System.out.println("Your pantry and grocery list were successfully saved to file: " + JSON_STORE + " !");
        } catch (FileNotFoundException e) {
            System.out.println("Oops! Unable to save pantry and grocery list to file " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads pantry from JSON file and displays ingredients in GUI
    public void loadGuiFromFile() {
        try {
            pantry = jsonReader.read();
            int n = 0;
            while (n < pantry.getPantrySize()) {
                String name = pantry.getIngredientAtIndex(n).getName();
                int amount = pantry.getIngredientAtIndex(n).getAmount();
                int numberOfPanels = 0;
                while (numberOfPanels < amount) {
                    NewApplePanel applePanel = new NewApplePanel(pantry);
                    applePanel.getLabel().setText(name);
                    this.add(applePanel);
                    this.setVisible(true);
                    numberOfPanels++;
                }
                n++;
            }
            this.revalidate();
            this.repaint();
            System.out.println("Your pantry and grocery list were successfully loaded from file: " + JSON_STORE + " !");
        } catch (IOException e) {
            System.out.println("Oops! Unable to load pantry and grocery list from file: " + JSON_STORE);
        }
    }

}

