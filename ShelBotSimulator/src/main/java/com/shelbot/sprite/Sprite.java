package com.shelbot.sprite;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents a sprite or a character on which the code runs
 * 
 * @author Pallavi Das and  
 * @version 5/16/20
 */
public class Sprite {

    private String imgName;
    public PImage img;
    private float x, y, width, height;

    public boolean isMoved = false;
    private float degrees = 0;

    /**
     * Used to make a sprite
     * @param imgName the name and dir of the file of the image
     * @param x the x of the sprite
     * @param y the y of the sprite
     * @param width the width of the sprite
     * @param height the height of the sprite
     */
    public Sprite(String imgName, float x, float y, float width, float height) {
        this.imgName = imgName;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Used to update attributes of the sprite
     * @param x the new x of the sprite
     * @param y the new y of the sprite
     * @param width the new width of the sprite
     * @param height the new height of the sprite
     */
    public void updateAttr(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        isMoved = true;
    }

    /**
     * Used to setup the sprite
     * @param applet the PApplet object used to setup the sprite
     */
    public void setup(PApplet applet){
        img = applet.loadImage(imgName);
    }

    /**
     * Used to draw the sprite
     * @param applet the PApplet object used to draw the sprite
     */
    public void draw(PApplet applet) {
        applet.pushStyle();
        applet.imageMode(applet.CENTER);
        applet.rotate(applet.radians(degrees));
        applet.image(img, x, y, width, height);
        applet.popStyle();
        // applet.image(img, x - img.width / 2, y - img.height / 2);
    }

    /**
     * Used to rotate the sprite
     * @param degrees the degrees to rotate the sprite to
     */
    public void rotate(float degrees){
        this.degrees = degrees;
    }

    /**
     * Used to move the sprite by certain x and y values
     * @param transX delta x sprite has to move by
     * @param transY delta y sprite has to move by
     */
    public void moveBy(float transX, float transY) {
        this.x += transX;
        this.y += transY;
        isMoved = true;
    }

    /**
     * Used to move the sprite to a new x and y
     * @param x the new x coord for the sprite
     * @param y the new y coord for the sprite
     */
    public void moveTo(float x, float y) {
        this.x = x;
        this.y = y;
        isMoved = true;
    }

    /**
     * Used to get the x coord of the sprite
     * @return x the x of the sprite
     */
    public float getX() {
        return x;
    }

    /**
     * Used to get the y coord of the sprite
     * @return y the y of the sprite
     */
    public float getY() {
        return y;
    }

    /**
     * Used to move the sprrite to new x coord
     * @param x the new x for sprite
     */
    public void moveX(float x) {
        this.x = x;
        isMoved = true;
    }

    /**
     * Used to move the sprrite to new y coord
     * @param y the new x for sprite
     */
    public void moveY(float y) {
        this.y = y;
        isMoved = true;
    }
}