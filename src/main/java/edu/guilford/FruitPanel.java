package edu.guilford;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.AlphaComposite;
import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import java.awt.Graphics;
import java.awt.Image;
//import java.awt.Dimension; 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import javafx.event.ActionEvent;


//plan:
//Fruit Panel = big guy
//inside it, we instantiate our variables, put our actions in methods (like ball action into methods, mouse key events) and organize the look of the panel
//so one method is ballaction, one is randomball (already made), and one needs to be randomgenerate location or something
//one needs to randomly choose a ball from the balls that we have to appear at the top
//we have to first start with just making one ball appear and then making it fall. if we can figure that out today, then tmw will be big dubs

public class FruitPanel extends JPanel{
    //declaring things
    private JPanel FruitPanel;//entire canvas that the ball drops in and the motion is in
    private JPanel backgroundPanel;
    private ArrayList<Fruit> fruits; //holds fruits list
    private Fruit cherry;
    private Fruit strawberry;
    private Fruit grape;
    private Fruit orange;
    private Fruit apple;
    private Fruit bomb;
    private JLabel image1Label;

    private Image backgroundImage;

    private int panelWidth = 1000;
    private int panelHeight = 800;

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
        
    public FruitPanel() {
        //super(); // no idea why this doesnt work.... but all the other code has this uncommented so maybe as chat why it doesnt work?
        initFruits();
        initBackgroundImage();
        
        //no idea how to make backgroundpanel work here....
        backgroundPanel = new JPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.LINE_AXIS));
        backgroundPanel.add(Box.createHorizontalGlue());
        add(backgroundPanel);

        cherry = new Fruit(0, 0, 20, "cherry", Color.PINK, 0);
        strawberry = new Fruit(300, 150, 40, "strawberry", Color.MAGENTA, 0);
        grape = new Fruit(350, 150, 60, "grape", Color.BLUE, 0);
        orange = new Fruit(400, 150, 80, "orange", Color.ORANGE, 0);
        apple = new Fruit(450, 150, 100, "apple", Color.RED, 0);
        bomb = new Fruit(500,120,20,"bomb",Color.GRAY,0);

        List<Fruit> list = new ArrayList<>();
        list.add(cherry);
        list.add(strawberry);
        list.add(grape);
        list.add(orange);
        list.add(apple);
        list.add(bomb);
        
        //fruitsPanel.add(cherry); //trying to add the fruit objects to the main jpanel
        // fruitsPanel.add(strawberry);
        // fruitsPanel.add(grape);
        // fruitsPanel.add(orange);
        // fruitsPanel.add(apple);

        // fruits.add(cherry); //trying to add the fruit objects to the main jpanel
        // fruits.add(strawberry);
        // fruits.add(grape);
        // fruits.add(orange);
        // fruits.add(apple);
        
        
        for (Fruit fruit : list) { //tells the user what type of fruit it is
            System.out.println(fruit.getType());
        }
        
        //in our lab 15 code, we add the arraylist of students here so maybe if we want we can add the fruit list here?
        // students = new ArrayList<Student>();
        // students.add(new Student());        // adds a single random student
        // //not sure where to put the paint part but i think it should be where we initialize the paint
        // @Override //--> put this code here?
        // protected void paintComponent(Graphics g) {
        //     // (remaining code for BallPanel class)
        //     super.paintComponent(g);

        //     // Draw each fruit on the panel
        //     for (Fruit fruit : fruits) {
        //         fruit.draw(g);
        //     }
        // }
        initPanel();
    }

    //for the drawing maybe
    @Override
    protected void paintComponent(Graphics g) { //items drawn later appear on top of the elemetns drawn earlier
        super.paintComponent(g);

        // Set alpha value (0.0f is fully transparent, 1.0f is fully opaque) -- try something for opacity to make the image less bright
        // float alpha = 0.5f;
        // AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        // g.setComposite(alphaComposite);

       // Draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        //draw the container --> add some code to put it at a specific place + height and width
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(1800/4, 0, panelWidth, panelHeight);

        // Draw other elements or images
        //drawFruits(g);

        // Draw additional drawings or images
        //drawAdditionalElements(g);
    }

    private void drawFruits(Graphics g) {
        // Loop through your list of fruits and draw each one
        for (Fruit fruit : fruits) {
            fruit.draw(g);
        }
    }

    private void drawAdditionalElements(Graphics g) {
        // Draw additional elements or images as needed
    }

    private void initBackgroundImage() {
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("cute-brown-aesthetic-abstract-minimal-background-perfect-for-wallpaper-backdrop-postcard-background-vector.jpg"));
        backgroundImage = backgroundIcon.getImage();
    }

    private void initFruits() {
        //maybe add stuff for the fruits this way? not sure
    }



    //in lab 15, // constructor receives student list  look at that line 
    // public StudentPanel(ArrayList<Student> students) {
    //     this.students = students;

    //     initPanel();                        // set up actual panel
    // }

    //methods:
    public void initPanel(){
        setPreferredSize(new Dimension(1800,900));

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
        //wait i think all the initialization stuff needs to happen at line 93 under the constructor Fruit Panel


        //tried to make bombpic synonymous with bomb --> hasnt been tested yet, will help to add pics with the rest of them maybe
        // image1Label = new JLabel("bombpic");
        // add(image1Label);

        // image1Label.setHorizontalTextPosition(SwingConstants.LEFT);
        // image1Label.setVerticalTextPosition(SwingConstants.TOP);

        // ImageIcon bombIcon = 
        //     new ImageIcon(getClass().getResource("bombpic.png"));

        // image1Label.setIcon(bombIcon);
        
        //i made it consistent with the fruit java part
        FruitPanel  = new JPanel(); 
        FruitPanel.setOpaque(true); 
        FruitPanel.setLayout(new BoxLayout(FruitPanel, BoxLayout.LINE_AXIS));            
        FruitPanel.add(Box.createHorizontalGlue()); 
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

    //mousekeyevent (look at lab 14 on how they formatted it)
    class SuikaMouseHelper implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // Handle mouse click event -- whereever you click, the ball drops down at the same x value, maybe if ur feeling fancy, make an if statmeent that if the x value is within the bounds of the box, then it drops, if its not, it sends "System.out.println("Make sure to click within the box!"")"
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
            // Fruit source = (Fruit) e.getSource();
            // source.requestFocus();
        }

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
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
    
    
    // for other code in this class - oh?????
    private void attributesPanel() {//whats the return type right here no clue what does it do again) { 
        List<Fruit> list = new ArrayList<>();
        //fruits.add(new Fruit(50, 50, 30, "Pineapple", Color.YELLOW, 0)); //change later to specific sizes, more sizes (how many?)
        //fruits.add(new Fruit(150, 100, 40, "Watermelon", Color.GREEN, 0));
        Fruit cherry = new Fruit(0, 0, 20, "cherry", Color.PINK, 0);
        Fruit strawberry = new Fruit(300, 150, 40, "strawberry", Color.MAGENTA, 0);
        Fruit grape = new Fruit(350, 150, 60, "grape", Color.BLUE, 0);
        Fruit orange = new Fruit(400, 150, 80, "orange", Color.ORANGE, 0);
        Fruit apple = new Fruit(450, 150, 100, "apple", Color.RED, 0);
        Fruit bomb = new Fruit(500,120,20,"bomb",Color.GRAY,0);
        list.add(cherry);
        list.add(strawberry);
        list.add(grape);
        list.add(orange);
        list.add(apple);
        list.add(bomb);
        
        //fruitsPanel.add(cherry); //trying to add the fruit objects to the main jpanel
        // fruitsPanel.add(strawberry);
        // fruitsPanel.add(grape);
        // fruitsPanel.add(orange);
        // fruitsPanel.add(apple);

        // fruits.add(cherry); //trying to add the fruit objects to the main jpanel
        // fruits.add(strawberry);
        // fruits.add(grape);
        // fruits.add(orange);
        // fruits.add(apple);
        
        
        for (Fruit fruit : list) { //tells the user what type of fruit it is
            System.out.println(fruit.getType());
        }
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

        //not sure what to do with this code? its kinda repetitive but it included the list and the paint together so maybe use it as inspo for where to put the paint stuff int he top part?
    // public class fruitsPanel extends JPanel { //repetitve?
    //     private List<Fruit> fruits;

    //     public fruitsPanel(List<Fruit> fruits) {
    //         this.fruits = fruits;
    //     }
        
    //     //not sure where to put the paint part but i think it should be where we initialize the paint, this is the duplicate
    //     @Override
    //     protected void paintComponent(Graphics g) {
    //         // (remaining code for BallPanel class)
    //         super.paintComponent(g);

    //         // Draw each fruit on the panel
    //         for (Fruit fruit : fruits) {
    //             fruit.draw(g);
    //         }
    //     }
    // }


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
}}

