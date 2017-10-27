package frogger;

import java.util.ArrayList;

public class Lane {
	// fields
    private int direction;  // LEFT or RIGHT
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    
    private ArrayList<Car> cars = new ArrayList<Car>();
    private double yPosition;
    private double width;
    private double speed;
    private boolean generateNewCars;
    
    // construct the lane at the given y-position
    public Lane(double yPosition) {
        this.yPosition = yPosition;
        width = 0.2;
        direction = (int) Math.round(Math.random()); 
        speed = 0.02;
        generateNewCars = true;
    }
    
    // draw the lane, including all cars
    public void draw() {
        // draw all cars in lane
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            c.draw();
        }
    }
    
    // step cars in all lane
    public void step() {
        
        // add new cars with some probability
        if (generateNewCars && Math.random() < 0.05) {
            
            double x = 0, dx = 0;
            if (direction == LEFT) {
                x = 1.2;
                dx = -speed;
            } else {
                x = -0.2;
                dx = speed;
            }
            
            Car c = new Car(x, yPosition, width / 2, dx);
            cars.add(c);
        }
        
        // move all cars
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            c.move();
            if (c.getX() < -0.5 || c.getX() > 1.5) {
                cars.remove(i);
                i--;
            }
        }
       
        // switch lane direction
        if (Math.random() < 0.01) {
            // switch direction
            direction = (direction + 1) % 2;
            generateNewCars = false;  // temporarily disable new cars
        }
        
        // test to see if it is ok to resume car generation
        if (cars.isEmpty()) {
            generateNewCars = true;
        }
    }
    
    // detect impacts with the given frog
    public boolean detectImpact(Frog f) {
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.get(i);
            if (c.detectImpact(f)) return true;
        }
        return false;
    }
        
}
