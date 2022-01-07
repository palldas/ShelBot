package com.shelbot.sprite;

import processing.core.PImage;

/** 
 * Represents a cat that could run the code
 * 
 * @author 
 */
public class Cat extends Sprite {

    private PImage img;

    /**
     * used to make a cat
     * @param x x for the cat
     * @param y y for the cat
     * @param width width for the cat
     * @param height height for the cat
     */
    public Cat(float x, float y, float width, float height) {
        super("cat.png", x, y, width, height);
        // TODO Auto-generated constructor stub
    }

}