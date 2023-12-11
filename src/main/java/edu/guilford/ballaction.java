package edu.guilford;

import java.awt.Color;

import java.util.ArrayList;
import java.util.List;

public class ballaction {
    public ballaction() {

    Vector g = new Vector(0, -9.81, 0);
    Vector dropheight = new Vector(0, 20, 0);
    double height = 15;
    double width = 15;
    double t = 0;
    double dt = 0.01;

    Sphere cherry = new Sphere(dropheight, 0.5, Color.RED, g);
    Sphere strawberry = new Sphere(dropheight, 1, Color.MAGENTA, g);
    Sphere grape = new Sphere(dropheight, 1.5, Color.BLUE, g);
    Sphere orange = new Sphere(dropheight, 2, Color.ORANGE, g);
    Sphere apple = new Sphere(dropheight, 2.5, Color.RED, g);
    Sphere bomb = new Sphere(dropheight, 1, Color.BLACK, g);

    Box bottom = new Box(new Vector(0, -height, 0), new Vector(width, 0, 1), Color.WHITE);
    Box left = new Box(new Vector(-width / 2, 0, 0), new Vector(0.1, height, 0.1), Color.WHITE);
    Box right = new Box(new Vector(width / 2, 0, 0), new Vector(0.1, height, 0.1), Color.WHITE);

    List<Sphere> list = new ArrayList<>();
    list.add(cherry);
    list.add(strawberry);
    list.add(grape);
    list.add(orange);
    list.add(apple);
    list.add(bomb);


    for (Sphere fruit : list) {
        while (fruit.getPos().getY() - fruit.getRadius() > -height) {
            fruit.setPos(fruit.getPos().add(g.multiply(dt)));
            t += dt;
            if (fruit.pos.y + fruit.radius == bomb.pos.y + bomb.radius) {
                fruit.color = Color.DARK_GRAY;
                System.out.println("exploded!");}
            }
        }
    }

    //add ball merging code here


class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector add(Vector other) {
        return new Vector(x + other.x, y + other.y, z + other.z);
    }

    public Vector multiply(double scalar) {
        return new Vector(x * scalar, y * scalar, z * scalar);
    }
}

class Sphere {
    private Vector pos;
    private double radius;
    private Color color;
    private Vector v;

    public Sphere(Vector pos, double radius, Color color, Vector v) {
        this.pos = pos;
        this.radius = radius;
        this.color = color;
        this.v = v;
    }

    public Vector getPos() {
        return pos;
    }

    public void setPos(Vector pos) {
        this.pos = pos;
    }

    public double getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public Vector getV() {
        return v;
    }
}

class Box {
    private Vector pos;
    private Vector size;
    private Color color;

    public Box(Vector pos, Vector size, Color color) {
        this.pos = pos;
        this.size = size;
        this.color = color;
    }

    public Vector getPos() {
        return pos;
    }

    public Vector getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }
}

}