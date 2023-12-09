package edu.guilford;

import java.awt.Graphics; 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class jpanel {
    private JPanel fruits;
    
    public class fruitsMovement extends JFrame {
        private List<Fruit> fruits;
        
        public fruitsMovement() { // for other code in this class
            fruits = new ArrayList<>();
            fruits.add(new Fruit(50, 50, 30, "Pineapple")); //change later to specific sizes, more sizes (how many?)
            fruits.add(new Fruit(150, 100, 40, "Watermelon"));
            fruits.add(new Fruit(250, 150, 20, "Cherry"));

            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            add(new fruitsPanel(fruits));
        }
    }

    //put remaining methods for this class
    
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            fruitsMovement fruitsMovement = new jpanel().new fruitsMovement();
            fruitsMovement.setVisible(true);
            //fruitsMovement fruitsMovement = new jpanel().new fruitsMovement();

            new mouseKeyEvents(fruits).setVisible(true);


        });
    }

     private void generateRandomFruit() { //generates a random fruit
        Random random = new Random();
        int randomX = random.nextInt(300) + 50;  // Random x-coordinate within a range
        int randomY = random.nextInt(300) + 50;  // Random y-coordinate within a range
        int randomRadius = random.nextInt(20) + 20;  // Random radius within a range
        String randomType = "RandomFruit";

        Fruit randomFruit = new Fruit(randomX, randomY, randomRadius, randomType);
        fruits.add(randomFruit);

        // Repaint the panel to update the fruit positions
        fruitsPanel.repaint();
    }
}
