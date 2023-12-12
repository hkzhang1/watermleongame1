package edu.guilford;

import java.awt.Graphics;
import javax.swing.JFrame;


//import edu.guilford.FruitPanel.SuikaMouseHelper;
import java.awt.Color;

public class Fruit {
   
    // to define the proportions of the fruits using x, y, and the radius (becuase
    // they are all circles)
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

        // g.setColor(Color.RED); // need to make it so that it changes colors based on
        // type
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

        // IMPORTNAT : still need to draw teh container, make the entire thing actually
        // look good....... (so aesthetic, using colors, etc)

        // Draw the type of fruit next to the circle
        // g.setColor(Color.BLACK);
        // g.drawString(type, x - radius, y - radius - 5);
    }

    public static void main(String[] args) { //look at lab 15 studentProject file for more help on this part
        // JPanel fruitPanel = new JPanel(); //cant make jpanel have a name--jframe can have a name
        // fruitPanel.setDefaultCloseOperation(JPanel.EXIT_ON_CLOSE);

        JFrame fruitFrame = new JFrame("Suika Game"); //creates a frame for the game titled suika game

        FruitPanel FruitPanel = new FruitPanel(); //creates a fruitpanel from the FruitPanel

        FruitPanel.setBackground(Color.BLACK); //color of the window

        fruitFrame.getContentPane().add(FruitPanel); //adds the fruitpanel to the frame for the game
        //fruitFrame.getContentPane().add(backgroundPanel); 
        //BackgroundPanel backgroundPanel = new BackgroundPanel(Color.MAGENTA, 800, 600);

        fruitFrame.setSize(1800,900);

        fruitFrame.pack();
        fruitFrame.setVisible(true);
        };

    // add more stuff for the behaviors of the fruits -- i think falling, the scoreboard, etc

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

    public void setVisible(boolean b) {
    }



}
