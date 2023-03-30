package ui;

import model.Ingredient;
import model.Pantry;
import presistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// JFrame for Pantry
public class MyFrame extends JFrame implements ActionListener {
    private JButton submit;
    private JButton addButton;
    private JTextField textField;
    private String ingredientName;
    private JButton saveButton;
    private Pantry pantry;
    private static final String JSON_STORE = "./data/gui.json";
    private JsonWriter jsonWriter;

    // MODIFIES: this
    // EFFECTS: displays new JFrame window with buttons and an empty pantry
    MyFrame() {
        this.setSize(800, 800);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addButtons();
        this.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: adds buttons to JFrame
    private void addButtons() {
        addButton = new JButton("Add Ingredient");
        addButton.setBounds(25, 25, 150, 50);
        addButton.addActionListener(this);
        this.add(addButton);
        saveButton = new JButton("Save Pantry");
        saveButton.setBounds(25, 50, 150, 50);
        saveButton.addActionListener(this);
        this.add(saveButton);
    }

    // REQUIRES: ActionEvent is not null
    // MODIFIES: this
    // EFFECTS: performs different actions based on which buttons are pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            JFrame nameFrame = new JFrame();
            initializeFramePantryAndWriter(nameFrame);
            textField = new JTextField();
            textField.setPreferredSize(new Dimension(200, 30));
            nameFrame.add(textField);
            textField.setText("Enter name of ingredient");
        } else if (e.getSource() == submit) {
            ingredientName = textField.getText();
            NewApplePanel applePanel = new NewApplePanel();
            applePanel.getLabel().setText(ingredientName);
            this.add(applePanel);
            this.setVisible(true);
            // addGuiToPantry(ingredientName);
        } else if (e.getSource() == saveButton) {
            saveGUItoFile();
        }
    }

    // MODIFIES: this
    // EFFECTS: sets up the new window to enter ingredient name
    public void initializeFramePantryAndWriter(JFrame jframe) {
        jframe.setSize(2000, 200);
        jframe.setLayout(new FlowLayout());
        jframe.setVisible(true);
        jframe.pack();
        submit = new JButton("Submit Name");
        submit.addActionListener(this);
        jframe.add(submit);
        pantry = new Pantry();
        jsonWriter = new JsonWriter(JSON_STORE);
    }
//
//    // MODIFIES: this
//    // EFFECTS: adds ingredient from GUI to pantry
//    public void addGuiToPantry(String name) {
//        Ingredient ingredient = new Ingredient(name, 1);
//        pantry.addIngredient(ingredient);
//    }
//

    //MODIFIES: this
    // EFFECTS: saves ingredients in GUI to a new pantry, then saves that pantry to a JSON file
    public void saveGUItoFile() {
        for (Component c : this.getComponents()) {
            if (c instanceof JLabel) {
                String name = ((JLabel) c).getText();
                Ingredient ingredient = new Ingredient(name, 1);
                pantry.addIngredient(ingredient);
            }
        }
        try {
            jsonWriter.open();
            jsonWriter.write(pantry);
            jsonWriter.close();
            System.out.println("Your pantry and grocery list were successfully saved to file: " + JSON_STORE + " !");
        } catch (FileNotFoundException e) {
            System.out.println("Oops! Unable to save pantry and grocery list to file " + JSON_STORE);
        }
    }
}
