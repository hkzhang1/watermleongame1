package edu.guilford;

import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.guilford.JThings.fruitsPanel;


class mouseKeyEvents extends JFrame { //sets up the class for mouse + key events --> how the game will function
    public mouseKeyEvents() {
        JPanel fruits;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        MyPanel myPanel = new MyPanel();
        add(myPanel);

        // Add mouse and key listeners to your panel
        myPanel.addMouseListener(new SuikaMouseListener());
        myPanel.addKeyListener(new suikaKeyListener());
        myPanel.setFocusable(true);
    }
}

class MyPanel extends JPanel {
    // Your panel code
}

class SuikaMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle mouse click event
        ballAction.ballAction();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Handle mouse press event
        int mouseX = e.getX();
            int mouseY = e.getY();
            
            for (Fruit fruit : fruits) {
                fruit.setX(mouseX);
                fruit.setY(mouseY);
            }

            // Repaint the panel to update the fruit positions
            //fruitsPanel.repaint();
        }


    @Override
    public void mouseReleased(MouseEvent e) {
        // Handle mouse release event
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Handle mouse enter event
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Handle mouse exit event
    }
}

class suikaKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // Handle key typed event
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle key pressed event
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key released event
    }
}
