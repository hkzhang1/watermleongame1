package edu.guilford;

import java.awt.Color;

import java.awt.Graphics; 
import java.awt.Dimension; 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//plan:
//Fruit Panel = big guy
//inside it, we instantiate our variables, put our actions in methods (like ball action into methods, mouse key events) and organize the look of the panel
//so one method is ballaction, one is randomball (already made), and one needs to be randomgenerate location or something
//one needs to randomly choose a ball from the balls that we have to appear at the top
//we have to first start with just making one ball appear and then making it fall. if we can figure that out today, then tmw will be big dubs


public class FruitPanel extends JPanel{
    //declaring things
    private JPanel fruitMovementPanel; //the box where the balls drop into
    private ArrayList<Fruit> fruits; //holds fruits list
    private Fruit cherry;
    private Fruit strawberry;
    private Fruit grape;
    private Fruit orange;
    private Fruit apple;
    private Fruit bomb;

    //vector code (but maybe not necessary? goes from 36 to 67)
    // class Vector { //is this supposed to be in the ball falling part? or should it be separate? this feels like some basic stuff  that should be above or smth not in the loop
    //     private double x;
    //     private double y;
    //     private double z;

    //     public Vector(double x, double y, double z) {
    //         this.x = x;
    //         this.y = y;
    //         this.z = z;
    //     }

    //     public double getX() {
    //         return x;
    //     }

    //     public double getY() {
    //         return y;
    //     }

    //     public double getZ() {
    //         return z;
    //     }

    //     public Vector add(Vector other) {
    //         return new Vector(x + other.x, y + other.y, z + other.z);
    //     }

    //     public Vector multiply(double scalar) {
    //         return new Vector(x * scalar, y * scalar, z * scalar);
    //     }
    // }

    //mousekeyevent (look at lab 14 on how they formatted it)
        
    public void MouseKeyEventPanel(){
        //super();
        initPanel();
    }
    
    //ball action event (somehow move it from ballaction.java) --> will be easier to call upon things
    public void ballFalling() {

        double g = -9.81;
        //double dropheight = 20;
        double height = 15;
        //double width = 15;
        double t = 0;
        double dt = 0.01;

        // Sphere cherry = new Sphere(dropheight, 0.5, Color.RED, g);
        // Sphere strawberry = new Sphere(dropheight, 1, Color.MAGENTA, g);
        // Sphere grape = new Sphere(dropheight, 1.5, Color.BLUE, g);
        // Sphere orange = new Sphere(dropheight, 2, Color.ORANGE, g);
        // Sphere apple = new Sphere(dropheight, 2.5, Color.RED, g);
        // Sphere bomb = new Sphere(dropheight, 1, Color.BLACK, g);

        // Box bottom = new Box(new Vector(0, -height, 0), new Vector(width, 0, 1), Color.WHITE);
        // Box left = new Box(new Vector(-width / 2, 0, 0), new Vector(0.1, height, 0.1), Color.WHITE);
        // Box right = new Box(new Vector(width / 2, 0, 0), new Vector(0.1, height, 0.1), Color.WHITE);

        List<Fruit> list = new ArrayList<>();
        list.add(cherry);
        list.add(strawberry);
        list.add(grape);
        list.add(orange);
        list.add(apple);
        list.add(bomb);

        for (Fruit fruit : list) {
            while (fruit.getY() - fruit.getRadius() > -height) {
                double droprate = fruit.getY() + (g * dt);
                fruit.setY((int)droprate);
                t += dt;
                if (fruit.getY() + fruit.radius == bomb.getY() + bomb.radius) {
                    fruit.color = Color.DARK_GRAY;
                    System.out.println("exploded!");
                }
            }
        }
    }

    
    
    // for other code in this class
    private void attributesPanel() {//whats the return type right here no clue what does it do again) {  << we gotta change this name what im confusing it w the fruitmovement in initpanel
        fruits = new ArrayList<>();
        //fruits.add(new Fruit(50, 50, 30, "Pineapple", Color.YELLOW, 0)); //change later to specific sizes, more sizes (how many?)
        //fruits.add(new Fruit(150, 100, 40, "Watermelon", Color.GREEN, 0));
        // cherry = new Fruit(0, 0, 20, "cherry", Color.PINK, 0);
        // strawberry = new Fruit(300, 150, 40, "strawberry", Color.MAGENTA, 0);
        // grape = new Fruit(350, 150, 60, "grape", Color.BLUE, 0);
        // orange = new Fruit(400, 150, 80, "orange", Color.ORANGE, 0);
        // apple = new Fruit(450, 150, 100, "apple", Color.RED, 0);
        
        //fruitsPanel.add(cherry); //trying to add the fruit objects to the main jpanel
        // fruitsPanel.add(strawberry);
        // fruitsPanel.add(grape);
        // fruitsPanel.add(orange);
        // fruitsPanel.add(apple);

        fruits.add(cherry); //trying to add the fruit objects to the main jpanel
        fruits.add(strawberry);
        fruits.add(grape);
        fruits.add(orange);
        fruits.add(apple);
        
        
        for (Fruit fruit : fruits) { //tells the user what type of fruit it is
            System.out.println(fruit.getType());
        }

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new fruitPanel(fruits)); //bruh what does this even mean 
        //the code does nothing like i:A????? ok wtv can i delete or change
    }
    public void initPanel(){
        setPreferredSize(new Dimension(1800,900));
        cherry = new Fruit(0, 0, 20, "cherry", Color.PINK, 0);
        strawberry = new Fruit(300, 150, 40, "strawberry", Color.MAGENTA, 0);
        grape = new Fruit(350, 150, 60, "grape", Color.BLUE, 0);
        orange = new Fruit(400, 150, 80, "orange", Color.ORANGE, 0);
        apple = new Fruit(450, 150, 100, "apple", Color.RED, 0);
        bomb = new Fruit (500, 120, 20, "bomb", Color.GRAY, 0);

        fruitMovementPanel = new JPanel();
        fruitMovementPanel.setOpaque(true);
        fruitMovementPanel.setLayout(new BoxLayout(fruitMovementPanel, BoxLayout.LINE_AXIS));            
        fruitMovementPanel.add(Box.createHorizontalGlue());
        //fruitMovement. 
    }



    public void generateRandomFruit() { //generates a random fruit
        Random random = new Random();
        int randomX = random.nextInt(300) + 50;  // Random x-coordinate within a range
        int randomY = random.nextInt(300) + 50;  // Random y-coordinate within a range
        int randomRadius = random.nextInt(20) + 20;  // Random radius within a range
        String randomType = "RandomFruit";
        Color randomballColor = Color.CYAN;
        double randomVelocity = (random.nextDouble() * 10);
        Fruit randomFruit = new Fruit(randomX, randomY, randomRadius, randomType, randomballColor, randomVelocity);

    public class fruitsPanel extends JPanel {
        private List<Fruit> fruits;

        public fruitsPanel(List<Fruit> fruits) {
            this.fruits = fruits;
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            // (remaining code for BallPanel class)
            super.paintComponent(g);

            // Draw each fruit on the panel
            for (Fruit fruit : fruits) {
                fruit.draw(g);
            }
        }
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> {
    //         fruitsMovement fruitsMovement = new FruitPanel().new fruitsMovement();
    //         fruitsMovement.setVisible(true);
    //         //fruitsMovement fruitsMovement = new jpanel().new fruitsMovement();

    //         new mouseKeyEvents(fruits).setVisible(true);


    //     });
    // }

    //  private void generateRandomFruit() { //generates a random fruit
    //     Random random = new Random();
    //     int randomX = random.nextInt(300) + 50;  // Random x-coordinate within a range
    //     int randomY = random.nextInt(300) + 50;  // Random y-coordinate within a range
    //     int randomRadius = random.nextInt(20) + 20;  // Random radius within a range
    //     String randomType = "RandomFruit";
    //     Color randomballColor = Color.CYAN;
    //     double randomVelocity = random.nextDouble();


    //     Fruit randomFruit = new Fruit(randomX, randomY, randomRadius, randomType, randomballColor, randomVelocity);
        //fruitsPanel.add(randomFruit);

        // Repaint the panel to update the fruit positions
        //fruitsPanel.repaint();
}
}
