package edu.guilford;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.guilford.JThings.fruitsMovementPanel;
import edu.guilford.JThings.fruitsPanel;

class mouseKeyEvents extends JFrame { // sets up the class for mouse + key events --> how the game will function
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
        // ballaction.ballaction();
        Point currentLocation = e.getPoint();
        System.out.println(currentLocation);

        Point screenLocation = e.getLocationOnScreen();
        System.out.println("Mouse: " + screenLocation);
        // add code that redirects the action to ballaction which will basically make
        // the balls drop down

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Handle mouse press event
        // int mouseX = e.getX();
        // int mouseY = e.getY();

        // for (Fruit fruit : fruits) {
        // fruit.setX(mouseX);
        // fruit.setY(mouseY);
        // }

        // // Repaint the panel to update the fruit positions
        // fruitsMovementPanel.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Handle mouse release event
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Handle mouse enter event
        Fruit source = (Fruit) e.getSource();
        source.requestFocus();
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
        // Fruit source = (Fruit) e.getSource();
        // int getlocationX = source.getX();
        // int getlocationY = source.getY();
        // int setlocationX = source.setX();
        // int setlocationY = source.getY();

        // if (e.getKeyCode() == KeyEvent.VK_LEFT) { // checks whether event has "k" key
        // code + if so, moves the object
        // // down by 5 pixels
        // Point newLocation = new Point(getlocationX - 5, getlocationY);
        // source.setLocation(newLocation);
        // }
        // if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // checks whether event has "k"
        // key code + if so, moves the object
        // // down by 5 pixels
        // Point newLocation = new Point(getlocationX + 5, getlocationY);
        // source.setLocation(newLocation);
        // }

        // else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        // requestFocus();
        // }

        // this is for the event in which the user wants to press keys to direct the
        // drop location of the fruit

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key released event
    }
}