package edu.guilford;

import java.awt.Graphics; 
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class jpanel {
    private JPanel fruits;
    
    public class fruitsMovement extends JFrame {
        private List<Fruit> fruits;
        
        public fruitsMovement() { // for other code in this class
            fruits = new ArrayList<>();
        }
    }

    //put remaining methods for this class
    
    public class fruitsPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            // (remaining code for BallPanel class)
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            fruitsMovement fruitsMovement = new jpanel().new fruitsMovement();
            fruitsMovement.setVisible(true);
        });
    }
}
