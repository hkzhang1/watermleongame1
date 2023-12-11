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


public class FruitPanel {
    //declaring things
    private JPanel fruitMovementPanel; //the box where the balls drop into
    private ArrayList<Fruit> fruits; //holds fruits list
    private Fruit cherry;
    private Fruit strawberry;
    private Fruit grape;
    private Fruit orange;
    private Fruit apple;
    public class fruitsMovementPanel extends JFrame {
        private List<Fruit> fruits;
        
        public void MouseKeyEventPanel(){
            //super();
            initPanel();
        }
        
        
        public fruitsMovementPanel() { // for other code in this class
            fruits = new ArrayList<>();
            //fruits.add(new Fruit(50, 50, 30, "Pineapple", Color.YELLOW, 0)); //change later to specific sizes, more sizes (how many?)
            //fruits.add(new Fruit(150, 100, 40, "Watermelon", Color.GREEN, 0));
            cherry = new Fruit(0, 0, 20, "cherry", Color.PINK, 0);
            strawberry = new Fruit(300, 150, 40, "strawberry", Color.MAGENTA, 0);
            grape = new Fruit(350, 150, 60, "grape", Color.BLUE, 0);
            orange = new Fruit(400, 150, 80, "orange", Color.ORANGE, 0);
            apple = new Fruit(450, 150, 100, "apple", Color.RED, 0);
            
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
            add(new fruitsPanel(fruits));
        }
        public void initPanel(){
            setPreferredSize(new Dimension(1800,900));

            fruitMovementPanel = new JPanel();
            fruitMovementPanel.setOpaque(true);
            fruitMovementPanel.setLayout(new BoxLayout(fruitMovementPanel, BoxLayout.LINE_AXIS));            
            fruitMovementPanel.add(Box.createHorizontalGlue());
        }
    }

    //put remaining methods for this class

    private void generateRandomFruit() { //generates a random fruit
        Random random = new Random();
        int randomX = random.nextInt(300) + 50;  // Random x-coordinate within a range
        int randomY = random.nextInt(300) + 50;  // Random y-coordinate within a range
        int randomRadius = random.nextInt(20) + 20;  // Random radius within a range
        String randomType = "RandomFruit";
        Color randomballColor = Color.CYAN;
        double randomVelocity = random.nextDouble();


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

     private void generateRandomFruit() { //generates a random fruit
        Random random = new Random();
        int randomX = random.nextInt(300) + 50;  // Random x-coordinate within a range
        int randomY = random.nextInt(300) + 50;  // Random y-coordinate within a range
        int randomRadius = random.nextInt(20) + 20;  // Random radius within a range
        String randomType = "RandomFruit";
        Color randomballColor = Color.CYAN;
        double randomVelocity = random.nextDouble();


        Fruit randomFruit = new Fruit(randomX, randomY, randomRadius, randomType, randomballColor, randomVelocity);
        //fruitsPanel.add(randomFruit);

        // Repaint the panel to update the fruit positions
        //fruitsPanel.repaint();
    }
}