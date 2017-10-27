package frogger;

import java.awt.Color;

public class Car {
	// cars
    private double x;
    private double y;
    private double size;
    private double dx;
    private Color color;
    
    // construct a car at the given location (x,y) with size and velocity
    public Car(double x, double y, double size, double dx) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.dx = dx;
        // choose a random color for the car
        color = new Color((float) Math.random(), 
                          (float) Math.random(), 
                          (float) Math.random());
    }
    
    // getter for x-coordinate
    public double getX() { return x; }
        
    // draw the car
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledRectangle(x, y, size, size / 3);
    }
    
    // move the car
    public void move() {
        x += dx;
    }
    
    // detect an impact with the frog
    public boolean detectImpact(Frog f) {
        double fx = f.getX();
        double fy = f.getY();
        
        double minX = x - size;
        double maxX = x + size;
        double minY = y - size / 3;
        double maxY = y + size / 3;
        
        return (minX <= fx && fx <= maxX && minY <= fy && fy <= maxY);
    }

}
