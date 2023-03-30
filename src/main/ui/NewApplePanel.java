package ui;

import model.Pantry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class for each JPanel with apple image, remove button and label
public class NewApplePanel extends JPanel implements ActionListener {
    private String name;
    private JLabel label = new JLabel();
    private JButton removeButton;

    // MODIFIES: this
    // EFFECTS: constructs new JPanel with label, apple image and remove button
    public NewApplePanel() {
        super();
        this.setBackground(Color.red);
        this.label = label;
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
    // EFFECTS: makes "this" not visible when removeButton is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeButton) {
            this.setVisible(false);
        }
    }

//    public void removeGuiFromPantry(String name, Pantry pantry) {
//
//    }

}
