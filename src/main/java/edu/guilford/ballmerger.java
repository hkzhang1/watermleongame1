<<<<<<< HEAD
// import java.util.HashMap; //idk what hash mpa or map is oops
// import java.util.Map;
=======
// package edu.guilford;
>>>>>>> 6d5eedcf0803ca4468f5ae6f983e4c98754f5714

<<<<<<< HEAD
// public class Main {
//     public static void main(String[] args) {
//         Map<String, Sphere> ball_types = new HashMap<>();
//         ball_types.put("red", new Sphere(new Vector(-3, 0, 0), 0.5, Color.RED, new Vector(0.1, 0, 0)));
//         ball_types.put("red1", new Sphere(new Vector(3, 0, 0), 0.5, Color.RED, new Vector(-0.1, 0, 0)));
=======
// import java.util.List;
// //import java.util.HashMap; //idk what hash mpa or map is oops
// import java.util.Map;
// import edu.guilford.ballaction;
>>>>>>> 6d5eedcf0803ca4468f5ae6f983e4c98754f5714

<<<<<<< HEAD
//         boolean collisionOccurred = checkCollisionAndMerge(ball_types);
//         if (collisionOccurred) {
//             Scene.pause();
//         }
//     }
=======
// public class ballmerger {
//     public static void ballmerger(String[] args) {
//         /*private List fruit_types = fruits;
//         list.add(cherry);
//         list.add(strawberry);
//         list.add(grape);
//         list.add(orange);
//         list.add(apple);
//         list.add(bomb);*/
//         public checkCollisionAndMerge(List fruit_types);{
//         boolean collisionOccurred;
//         if (collisionOccurred) {
//             Scene.pause();
//         }
//     }}
>>>>>>> 6d5eedcf0803ca4468f5ae6f983e4c98754f5714

//     public static boolean checkCollisionAndMerge(Map<String, Sphere> ball_types) {
//         for (Map.Entry<String, Sphere> entry1 : ball_types.entrySet()) {
//             String type1 = entry1.getKey();
//             Sphere ball1 = entry1.getValue();
//             for (Map.Entry<String, Sphere> entry2 : ball_types.entrySet()) {
//                 String type2 = entry2.getKey();
//                 Sphere ball2 = entry2.getValue();
//                 if (!type1.equals(type2)) {
//                     if (ball1.pos.subtract(ball2.pos).mag() < ball1.radius + ball2.radius) {
//                         if (ball1.color.equals(ball2.color)) {
//                             Color merged_color = Color.WHITE;
//                             Vector merged_pos = ball1.pos.add(ball2.pos).divide(2);
//                             Sphere merged_ball = new Sphere(merged_pos, ball1.radius + ball2.radius,
//                                     merged_color, ball1.velocity.add(ball2.velocity).divide(2));
//                             ball1.visible = false;
//                             ball2.visible = false;
//                             ball_types.put(type1, merged_ball);
//                             return true;
//                         }
//                     }
//                 }
//             }
//         }
//         return false;
//     }

//     static class Sphere {
//         Vector pos;
//         double radius;
//         Color color;
//         Vector velocity;
//         boolean visible;

//         public Sphere(Vector pos, double radius, Color color, Vector velocity) {
//             this.pos = pos;
//             this.radius = radius;
//             this.color = color;
//             this.velocity = velocity;
//             this.visible = true;
//         }
//     }

//     static class Vector {
//         double x;
//         double y;
//         double z;

//         public Vector(double x, double y, double z) {
//             this.x = x;
//             this.y = y;
//             this.z = z;
//         }

//         public Vector add(Vector other) {
//             return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
//         }

//         public Vector subtract(Vector other) {
//             return new Vector(this.x - other.x, this.y - other.y, this.z - other.z);
//         }

//         public Vector divide(double scalar) {
//             return new Vector(this.x / scalar, this.y / scalar, this.z / scalar);
//         }

//         public double mag() {
//             return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
//         }
//     }

//     static class Color {
//         public static final Color RED = new Color();
//         public static final Color WHITE = new Color();
//     }

<<<<<<< HEAD
//     static class Scene {
//         public static void pause() {
//             // Pause the scene
//         }
//     }
//     while (true) {
//     rate(30);
=======
//     static class Scene {
//         public static void pause() {
//             // Pause the scene
//         }
//     }
//     while (true) {
>>>>>>> 6d5eedcf0803ca4468f5ae6f983e4c98754f5714
    
<<<<<<< HEAD
//     for (Ball ball : ball_types.values()) {
//         ball.pos.add(ball.velocity);
//     }
=======
//     for (Fruit fruit : fruit_types.values()) {
//         fruit.getX().add(Fruit.getVelocity());
//     }
>>>>>>> 6d5eedcf0803ca4468f5ae6f983e4c98754f5714
    
//     if (check_collision_and_merge()) {
//         continue;
//     }
    
<<<<<<< HEAD
//     for (Map.Entry<String, Ball> entry1 : ball_types.entrySet()) {
//         String type1 = entry1.getKey();
//         Ball ball1 = entry1.getValue();
=======
//     for (Map.Entry<String, Fruit> entry1 : fruit_types.entrySet()) {
//         String type1 = entry1.getKey();
//         Fruit ball1 = entry1.getValue();
>>>>>>> 6d5eedcf0803ca4468f5ae6f983e4c98754f5714
        
<<<<<<< HEAD
//         for (Map.Entry<String, Ball> entry2 : ball_types.entrySet()) {
//             String type2 = entry2.getKey();
//             Ball ball2 = entry2.getValue();
=======
//         for (Map.Entry<String, Fruit > entry2 : fruit_types.entrySet()) {
//             String type2 = entry2.getKey();
//             Fruit ball2 = entry2.getValue();
>>>>>>> 6d5eedcf0803ca4468f5ae6f983e4c98754f5714
            
<<<<<<< HEAD
//             if (!type1.equals(type2)) {
//                 if (ball1.pos.x < ball2.pos.x) {
//                     ball1.pos.x += 0.01;
//                     ball2.pos.x -= 0.01;
//                 }
//             }
//         }
//     }
// }
=======
//             if (!type1.equals(type2)) {
//                 if (ball1.getX() < ball2.getX()) {
//                     ball.setX() = ball1.getX() + 0.01;
//                     ball2.getX() -= 0.01;
//                 }
//             }
//         }
//     }
// }
>>>>>>> 6d5eedcf0803ca4468f5ae6f983e4c98754f5714



// }



