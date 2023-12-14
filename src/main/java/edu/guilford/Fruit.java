package edu.guilford;

import java.awt.Graphics;
import javax.swing.JFrame;


//import edu.guilford.FruitPanel.SuikaMouseHelper;
import java.awt.Color;

public class Fruit {
   
    // to define the proportions of the fruits using x, y, radius
    int x, y, radius;
    String type;
    Color color;
    double velocity;

    // constructors to initialize each fruit with the parameteres x, y (for the
    // position), the radius of the ball, the type (so the name), the color to
    // differentiate, and the velocity of the ball
    public Fruit(int x, int y, int radius, String type, Color color, double velocity) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.type = type;
        this.color = color;
        this.velocity = velocity;
    }

    public void draw(Graphics g) {
        // Draw the fruit as a circle on the panel

        if (type == "cherry")
            g.setColor(Color.PINK);
        else if (type == "strawberry")
            g.setColor(Color.MAGENTA);
        else if (type == "grape")
            g.setColor(Color.BLUE);
        else if (type == "orange")
            g.setColor(Color.ORANGE);
        else if (type == "apple")
            g.setColor(Color.RED);
        else if (type == "bomb")
            g.setColor(Color.GRAY);
        else
            g.setColor(Color.CYAN);

        
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

    }

    public static void main(String[] args) { 

        JFrame fruitFrame = new JFrame("Suika Game"); //creates a frame for the game titled suika game

        FruitPanel FruitPanel = new FruitPanel(); //creates a fruitpanel from the FruitPanel

        FruitPanel.setBackground(Color.BLACK); //color of the window

        fruitFrame.getContentPane().add(FruitPanel); //adds the fruitpanel to the frame for the game

        fruitFrame.setSize(1800,900); //size of panel

        fruitFrame.pack();
        fruitFrame.setVisible(true);
        };


    // getters and setters for X
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    // getters and setters for Y
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // getters and setters for radius
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    // getters and setters for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // getters and setters for color
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    // getters and setters for velocity
    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    //mouse and key listeners
	public void addMouseListener(SuikaMouseHelper suikaMouseHelper) {
	}

    public void addKeyListener(suikaKeyListener suikaKeyListener) {
    }

    //setvisible method
    public void setVisible(boolean b) {
    }



}
