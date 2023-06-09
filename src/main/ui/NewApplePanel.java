package ui;

import model.Pantry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// JPanel representing an Ingredient; contains a label, remove button and image of an apple
public class NewApplePanel extends JPanel implements ActionListener {
    private JLabel label;
    private JButton removeButton;
    private Pantry pantry;

    // MODIFIES: this
    // EFFECTS: constructs new JPanel with label, apple image and remove button
    public NewApplePanel(Pantry pantry) {
        super();
        this.pantry = pantry;
        this.setBackground(Color.red);
        label = new JLabel();
        this.add(label);
        ImageIcon apple = new ImageIcon("data/210Project-Apple.jpeg");
        Image appleImg = apple.getImage();
        Image appleScaled = appleImg.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon newApple = new ImageIcon(appleScaled);
        label.setIcon(newApple);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        removeButton = new JButton("X");
        removeButton.addActionListener(this);
        this.add(removeButton);
    }

    public JLabel getLabel() {
        return this.label;
    }

    // MODIFIES: this
    // EFFECTS: makes "this" not visible if removeButton is pressed and removes 1 of ingredient with the same name from
    // pantry, otherwise it does nothing
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeButton) {
            for (Component panelComp : this.getComponents()) {
                if (panelComp instanceof JLabel) {
                    JLabel currentLabel = (JLabel) panelComp;
                    String name = currentLabel.getText();
                    pantry.removeIngredient(name, 1);
                    this.setVisible(false);
                }
            }
        }
    }
}
