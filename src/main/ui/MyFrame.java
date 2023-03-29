package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// JFrame for Pantry
public class MyFrame extends JFrame implements ActionListener, MouseListener {
    private JButton submit;
    private JButton addButton;
    private JTextField textField;
    private String ingredientName;

    // MODIFIES: this
    // EFFECTS: displays new JFrame window with buttons and an empty pantry
    MyFrame() {
        this.setVisible(true);
        this.setSize(800, 800);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addButtons();
    }

    // MODIFIES: this
    // EFFECTS: adds buttons to JFrame
    private void addButtons() {
        addButton = new JButton("Add Ingredient");
        addButton.setBounds(25, 25, 150, 50);
        addButton.addActionListener(this);
        this.add(addButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            JFrame nameFrame = new JFrame();
            initializeFrame(nameFrame);
            textField = new JTextField();
            textField.setPreferredSize(new Dimension(200, 30));
            nameFrame.add(textField);
            textField.setText("Enter name of ingredient");
        } else if (e.getSource() == submit) {
            ingredientName = textField.getText();
            addPantryItemWithImage();
        }
    }

    public void initializeFrame(JFrame jframe) {
        jframe.setSize(2000, 200);
        jframe.setLayout(new FlowLayout());
        jframe.setVisible(true);
        jframe.pack();
        submit = new JButton("Submit Name");
        submit.addActionListener(this);
        jframe.add(submit);
    }

    public void addPantryItemWithImage() {
        JLabel label = new JLabel();
        label.setText(ingredientName);
        this.add(label);
        ImageIcon apple = new ImageIcon("src/210Project-Apple.jpeg");
        Image appleImg = apple.getImage();
        Image appleScaled = appleImg.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon newApple = new ImageIcon(appleScaled);
        label.setIcon(newApple);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent m) {

    }

    @Override
    public void mousePressed(MouseEvent m) {

    }

    @Override
    public void mouseReleased(MouseEvent m) {

    }

    @Override
    public void mouseEntered(MouseEvent m) {

    }

    @Override
    public void mouseExited(MouseEvent m) {

    }




}
