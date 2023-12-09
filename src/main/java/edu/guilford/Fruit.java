package edu.guilford;

import java.awt.Graphics;
import java.awt.Color;

public class Fruit {
    //to define the proportions of the fruits using x, y, and the radius (becuase they are all circles)
        int x, y, radius;
        String type;
    
    //constructors to initialize each fruit
        public Fruit(int x, int y, int radius, String type) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.type = type;
        }
    
        public void draw(Graphics g) {
        // Draw the fruit as a circle on the panel
            g.setColor(Color.RED);  // changing colors based on type
            g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);

        //IMPORTNAT : still need to draw teh container, make the entire thing actually look good....... (so aesthetic, using colors, etc)

            // Draw the type of fruit next to the circle
            // g.setColor(Color.BLACK);
            // g.drawString(type, x - radius, y - radius - 5);
    }
        

    //add more stuff for the behaviors of the fruits -- i think falling, the scoreboard, etc
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}