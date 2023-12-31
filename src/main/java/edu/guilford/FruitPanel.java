package edu.guilford;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
// import java.util.Timer;
// import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.SwingUtilities;

public class FruitPanel extends JPanel{
    //declaring things
    private JPanel FruitPanel;//entire canvas that the ball drops in and the motion is in
    private JPanel backgroundPanel;
    private Image backgroundImage; 
    private int panelWidth = 1000;
    private int panelHeight = 800;

    private ArrayList<Fruit> fruits; //holds fruits list
    private Fruit cherry;
    private Fruit strawberry;
    private Fruit grape;
    private Fruit orange;
    private Fruit apple;
    private Fruit bomb;
    
    private JPanel buttonPane; //to put the buttons in
    private JButton RandomFruit; //randomfruit button
    private JButton dropButton; //drop button
    private JButton startButton; //start button
    private JButton nextFruitButton; //next fruit displaying button
    private int currentFruitIndex = -1;
	private JLabel randomQuote; //for making a random quote appear on the screen

    public FruitPanel() {
        super(); 
        initFruits();
        //drawFruits(g);
        initBackgroundImage();
       
       
        //background image
        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.LINE_AXIS));
        backgroundPanel.add(Box.createHorizontalGlue());
        add(backgroundPanel);

	//make a jlabel for randomquote and add it to the bakcgroundpanel
	randomQuote = new JLabel();
        randomQuote.setForeground(Color.WHITE); // Set text color to white
        randomQuote.setFont(new Font("Arial", Font.BOLD, 20)); // Set font
        backgroundPanel.add(randomQuote); // Add the label to the backgroundPanel

        initPanel();

        // this is some code that checks if there is any fruit moving but it needs some work, just a start
        // public void setFruitMoving(boolean isMoving) {
        //     for (Fruit fruit : fruits) {
        //         fruit.addMouseListener(new SuikaMouseHelper());
        //         fruit.addKeyListener(new SuikaKeyListener());
        //     }
        //     ((SuikaMouseHelper)cherry.getMouseListeners()[0]).setFruitMoving(isMoving); //would have to do this fro all the fruits
        //     ((SuikaMouseHelper)strawberry.getMouseListeners()[0]).setFruitMoving(isMoving);
        //     ((SuikaMouseHelper)grape.getMouseListeners()[0]).setFruitMoving(isMoving);
        //     ((SuikaMouseHelper)orange.getMouseListeners()[0]).setFruitMoving(isMoving);
        //     ((SuikaMouseHelper)apple.getMouseListeners()[0]).setFruitMoving(isMoving);
        //     ((SuikaMouseHelper)bomb.getMouseListeners()[0]).setFruitMoving(isMoving);
        // }
    }
        
    //for shuffling fruits: so we have different orders of the fruits when they get dropped
    private void shuffleFruits() { 
        Collections.shuffle(fruits);
    }
    

    //for the drawing maybe
    @Override
    protected void paintComponent(Graphics g) { //items drawn later appear on top of the elemetns drawn earlier
        super.paintComponent(g);

       // Draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        //draw the container --> add some code to put it at a specific place + height and width
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(328, 0, panelWidth, panelHeight);

        //Draw other elements or images
        drawFruits(g);
        
        // Draw additional drawings or images
        drawAdditionalElements(g);
    
    }

    private void drawFruits(Graphics g) { 
        // Loop through your list of fruits and draw each one
        for (Fruit fruit : fruits) {
            fruit.draw(g);
        }
    }

    private void drawAdditionalElements(Graphics g) {
        // Draw additional elements or images as needed
	String randomString = getRandomString(); //to get the random quote from an array of strings
        g.setColor(Color.WHITE);
        g.drawString(randomString, 1500, 400);
    }

private String getRandomString() {
        // to get the random string from the array
        String[] stringsArray = {"String1", "String2", "String3", "String4"};
        Random random = new Random();
        int randomIndex = random.nextInt(stringsArray.length);
        return stringsArray[randomIndex];
    }

	
    //putting in a background image to be aesthetic so it doesn't look sad and boring
    private void initBackgroundImage() {
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("cute-brown-aesthetic-abstract-minimal-background-perfect-for-wallpaper-backdrop-postcard-background-vector.jpg"));
        backgroundImage = backgroundIcon.getImage();
    }

    //initialized the fruits and added them to the arraylist
    private void initFruits() {
        //maybe add stuff for the fruits this way? not sure
        fruits = new ArrayList<>();

        //initializes the fruits here
        cherry = new Fruit(840, 100, 20, "cherry", Color.PINK, 0);
        strawberry = new Fruit(840, 100, 40, "strawberry", Color.MAGENTA, 0);
        grape = new Fruit(840, 100, 60, "grape", Color.BLUE, 0);
        orange = new Fruit(840, 100, 75, "orange", Color.ORANGE, 0);
        apple = new Fruit(840, 100, 80, "apple", Color.RED, 0);
        bomb = new Fruit(840, 100, 20, "bomb", Color.GRAY, 0);

        //adds fruits to the fruits list
        fruits.add(cherry);
        fruits.add(strawberry);
        fruits.add(grape);
        fruits.add(orange);
        fruits.add(apple);
        fruits.add(bomb);

        //shuffled order of fruits here
        shuffleFruits();
        
    }

    //method that randomly selects a fruit and draws it at/near a designated point
    public void randomFruitSelected() {
        Random random = new Random();
        int randomIndex = random.nextInt(fruits.size());
        Fruit selectedFruit = fruits.get(randomIndex);

        selectedFruit.setX(840); //x coordinate that we want the balls to start at
        selectedFruit.setY(100); //y coordinate that we want the balls to start at

        repaint(); //draw the fruit
    }

   
    //methods initpanel
    public void initPanel() {
        setPreferredSize(new Dimension(1800,900)); //sets how big the window will get

        //fruit adding mouse listener + key listener
        cherry.addMouseListener(new SuikaMouseHelper());
        strawberry.addMouseListener(new SuikaMouseHelper());
        grape.addMouseListener(new SuikaMouseHelper());
        orange.addMouseListener(new SuikaMouseHelper());
        apple.addMouseListener(new SuikaMouseHelper());
        bomb.addMouseListener(new SuikaMouseHelper());
        
        cherry.addKeyListener(new suikaKeyListener());
        strawberry.addKeyListener(new suikaKeyListener());
        grape.addKeyListener(new suikaKeyListener());
        orange.addKeyListener(new suikaKeyListener());
        apple.addKeyListener(new suikaKeyListener());
        bomb.addKeyListener(new suikaKeyListener());
        
        //fruitpanel creation
        FruitPanel  = new JPanel(); 
        FruitPanel.setOpaque(true); 
        FruitPanel.setLayout(new BoxLayout(FruitPanel, BoxLayout.LINE_AXIS));            
        FruitPanel.add(Box.createHorizontalGlue()); 

        //panel to put the random fruit button
        buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(Box.createHorizontalGlue());

        //to make the randomfruit button
        RandomFruit = new JButton("Random Fruit?");
        RandomFruit.addActionListener(new RandomFruitListener());
        buttonPane.add(RandomFruit);
        
         //to make the start button
        startButton = new JButton("Start Game");
        startButton.addActionListener(new StartButtonListener());
        buttonPane.add(startButton); 

         //to make the drop button
        dropButton = new JButton("Drop");
        dropButton.addActionListener(new DropButtonListener());
        buttonPane.add(dropButton);

        nextFruitButton = new JButton("Show Next Fruit");
        nextFruitButton.addActionListener(new NextFruitListener());
        buttonPane.add(nextFruitButton);


        add(buttonPane);

        shuffleFruits();
    
    }

    //calls randommethod when random button is clicked
    private class RandomFruitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            generateRandomFruit();
            repaint();
        }
    }

    //calls oneatatime method when start button is clicked
    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            oneAtATime();
        }
    }

    //calls ballfalling method when drop button is clicked
    private class DropButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ballFalling();
        }
    }

    //calls shownextfruit method when next button is clicked
     private class NextFruitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            showNextFruit();
        }
    }

    private void oneAtATime(){
        //show one fruit at a time
        fruits.clear(); // Remove any existing fruits
        
        Random random = new Random();
        List<Fruit> remainingFruits = new ArrayList<>(Arrays.asList(cherry, strawberry, grape, orange, apple, bomb));

        while (!remainingFruits.isEmpty()) {
            int randomIndex = random.nextInt(remainingFruits.size());
            Fruit selectedFruit = remainingFruits.get(randomIndex);
            
            selectedFruit.setX(840); 
            selectedFruit.setY(100); 
            
            selectedFruit.setVisible(true); // Set the fruit visible

            fruits.add(selectedFruit); // Add the selected fruit to the list
            remainingFruits.remove(selectedFruit); // Remove the fruit from the remaining list

            ballFalling();
            
            repaint(); // Redraw the panel with the updated fruit position
            
        }
}

//shows the next fruit to be dropped
private void showNextFruit() {
    if (currentFruitIndex >= 0 && currentFruitIndex < fruits.size()) {
        Fruit currentFruit = fruits.get(currentFruitIndex);
        currentFruit.setVisible(false); // Hide the current fruit
	randomQuote.setText("");
    }

    // Choose a random fruit and show it
    Random random = new Random();
    int randomIndex = random.nextInt(fruits.size());
    Fruit nextFruit = fruits.get(randomIndex);
    nextFruit.setX(840); // Initial X position
    nextFruit.setY(100); // Initial Y position
    nextFruit.setVisible(true); // Show the new random fruit

    currentFruitIndex = randomIndex; // Update the current fruit index
    repaint(); // Redraw the panel
}

    public void generateRandomFruit() { //generates a random fruit
        Random random = new Random();
        int randomX = random.nextInt(10) + 840;  // Random x-coordinate within a range
        int randomY = random.nextInt(10) + 100;  // Random y-coordinate within a range
        int randomRadius = random.nextInt(20) + 20;  // Random radius within a range
        String randomType = "RandomFruit";
        Color randomballColor = Color.CYAN;
        double randomVelocity = (random.nextDouble() * 10);
        Fruit randomFruit = new Fruit(randomX, randomY, randomRadius, randomType, randomballColor, randomVelocity);        

        fruits.add(randomFruit);
    }

    
    //controls ball movement
    public void ballFalling() {

        double grav = 9.81;
        double height = 790;
        double rate = 0.1;
        double dt = 0.01;

        List<Fruit> list = new ArrayList<>();
        list.add(cherry);
        list.add(strawberry);
        list.add(grape);
        list.add(orange);
        list.add(apple);
        list.add(bomb);

        for (Fruit fruit : list) {
            while (fruit.getY() + fruit.getRadius() < height) {
                double droprate = fruit.getY() + (grav * rate);
                fruit.setY((int)droprate);
                repaint();
                System.out.println(fruit.getY());

		String randomString = getRandomString();
                randomQuote.setText(randomString);
		    
                rate += dt;
                // if (fruit.getY() + fruit.radius == bomb.getY() + bomb.radius) {
                //     fruit.color = Color.DARK_GRAY;
                //     System.out.println("exploded!");
                }
            }
        }
    }

    class SuikaMouseHelper implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // Handle mouse click event -- whereever you click, the ball drops down at the same x value, maybe if ur feeling fancy, make an if statmeent that if the x value is within the bounds of the box, then it drops, if its not, it sends "System.out.println("Make sure to click within the box!"")"
            // ballaction.ballaction();
            Point currentLocation = e.getPoint();
            System.out.println(currentLocation);

            // if (!isFruitMoving) {
            //     // If no fruit is moving, select a random fruit at the initial position
            //     //randomFruitSelected();
            // } else {
            //     // If a fruit is already moving, teleport the clicked fruit to the clicked x position
            //     //should just not do anything
            // }
    
            //int x = e.getX();
            //int y = e.getY();

            // Check if the click is inside the container
            // if (x >= 328 && x <= 1000 && y >= 0 && y <= 800) {
            //     // Find the fruit at (300, 10) and execute ballFalling
            //     for (Fruit fruit : fruits) {
            //         if (fruit.getX() == 300 && fruit.getY() == 10) {
            //             ballFalling(fruit);
            //             break;
            //         }
            //     }
            // }
             // Redraw the panel with the updated fruit positions
        }
            // add code that redirects the action to ballaction which will basically make
            // the balls drop down

        @Override
        public void mousePressed(MouseEvent e) {
            // Handle mouse press event
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // Handle mouse release event
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // Handle mouse enter event
            // Fruit source = (Fruit) e.getSource();
            // source.requestFocus();
        }

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

        //this is connected code to the is there a fruit moving? 
        // public void setFruitMoving(boolean isMoving) {
        //     this.isFruitMoving = isMoving;
        // }
    }


    class suikaKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            // Handle key typed event
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // // Handle key pressed event
            // if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            //     // Close the window when Escape key is pressed
            //     JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(FruitPanel.this);
            //     frame.dispose();
            // }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // Handle key released event
        }
    
    }


