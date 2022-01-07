package com.shelbot.sprite;

import processing.core.PImage;

/**
 * Represents a humanoid that could run the code
 * 
 * @author  
 * @version 5/16/20
 */
public class Humanoid extends Sprite {

    private PImage img;

    /**
     * Creates a new instance of the Humanoid Sprite
     * 
     * @param x      the main x-coordinate of the humanoid
     * @param y      the main y-coordinate of the humanoid
     * @param width  the width of humanoid img
     * @param height the height of the humanoid img
     */
    public Humanoid(float x, float y, float width, float height) {
        super("humanoid.png", x, y, width, height);
    }

}