package frogger;

public class Frog {
	// fields
    private double x;
    private double y;
    private double size;
    private double stepSize;
    private int numLives;
    
    // static constants for movement
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int UP = 2;
    public static final int DOWN = 3;
    
    // construct a frog at location (x,y)
    public Frog(double x, double y) {
        this.x = x;
        this.y = y;
        size = 0.01;
        stepSize = 0.005;
        numLives = 3;
    }
    
    // getter for x-coordinate
    public double getX() { return x; }
    
    // getter for y-coordinate
    public double getY() { return y; }
    
    // draw the frog
    public void draw() {
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(x, y, size);
    }
    
    // move the frog
    // direction = up/down/left/right
    public void move(int direction) {
        switch (direction) {
            case LEFT:  
                if (x > 0) x -= stepSize; 
                break;
            case RIGHT: 
                if (x < 1) x += stepSize; 
                break;
            case UP:    
                if (y < 1) y += stepSize; 
                break;
            case DOWN:  
                if (y > 0) y -= stepSize; 
                break;
        }
            
    }
    
    // get the number of lives remaining
    public int getNumLives() { return numLives; }
    
}
