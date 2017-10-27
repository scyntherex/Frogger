package frogger;

import java.awt.event.KeyEvent;
import java.awt.Color;
import java.util.ArrayList;

public class Frogger {
	// use this main method verbatim
    public static void main(String[] args) {
        // setup the sketch
        setup();
        // drawing and interaction loop
        boolean justPressedMouse = false;
        while(true) {
            draw();
            if (StdDraw.mousePressed()) {
                if (!justPressedMouse) mouseClicked();
                mousePressed();
                justPressedMouse = true;
            } else {
                justPressedMouse = false;
            }
            StdDraw.show(20);
        }
    }
    
    
    ///////////////////////////////////////////////
    //   Objects in game
    ///////////////////////////////////////////////
    static Frog frog = null;
    static Lane[] lanes = null;
    
    
    ///////////////////////////////////////////////
    //   Methods to run game
    ///////////////////////////////////////////////
    
    // setup is called once to initialize everything
    public static void setup() {
        frog = new Frog(0.5, 0);
        lanes = new Lane[9];
        lanes[0] = new Lane(0.1);
        lanes[1] = new Lane(0.2);
        lanes[2] = new Lane(0.3);   
        lanes[3] = new Lane(0.4);
        lanes[4] = new Lane(0.5);
        lanes[5] = new Lane(0.6);   
        lanes[6] = new Lane(0.7);
        lanes[7] = new Lane(0.8);
        lanes[8] = new Lane(0.9);
    }
    
    // draw one frame of animation
    public static void draw() {
        StdDraw.clear(StdDraw.WHITE);
        
        // draw and move the frog based on the pressed key
        frog.draw();
        // handle frog movement
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) { // Left arrow
            frog.move(Frog.LEFT);
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) { // right arrow
            frog.move(Frog.RIGHT);
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) { // up arrow
            frog.move(Frog.UP);
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) { // down arrow
            frog.move(Frog.DOWN);
        }
        
        // draw and step all lanes
        for (int i = 0; i < lanes.length; i++) {
            lanes[i].draw();
            lanes[i].step();
        }
        
        // check for the frog impacting anything in a lane
        for (int i = 0; i < lanes.length; i++) {
            if (lanes[i].detectImpact(frog))
                StdDraw.clear(StdDraw.RED);
        }
    }
    
    // called whenever the mouse is pressed
    public static void mousePressed() {
        // empty
    }
    
    // called once when the mouse is clicked
    public static void mouseClicked() {
        // empty
    }
    
}
