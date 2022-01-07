package com.shelbot.utils;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Used to make a button with an image in the background that is blurred
 * 
 * @author  
 * @version 5/12/20
 */
public class ImageButton extends Button {

    private PImage img;
    private String imgFileName;

    private float x, y, width, height;

    /**
     * Used to create an image button
     * 
     * @param fileName The name of the file of the image in the button
     * @param x        The x coord of the imageButton
     * @param y        the y coord of the imageButton
     * @param width    The width of the imageButton
     * @param height   The height of the imageButton
     */
    public ImageButton(String fileName, float x, float y, float width, float height) {
        this.imgFileName = fileName;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Used to draw the imageButton
     * 
     * @param applet the PApplet object used to draw
     */
    public void draw(PApplet applet) {
        applet.pushStyle();
        applet.textAlign(applet.CENTER, applet.CENTER);
        applet.noStroke();
        if (isHighlight) {
            applet.fill(highlightColor.getRGB());
        }
        applet.rect(x, y, width, height);
        applet.imageMode(applet.CENTER);
        img = applet.loadImage(imgFileName);
        try {
            img.resize((int) (0.8 * width), (int) (0.8 * height));
            applet.image(img, x + width / 2, y + height / 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        applet.popStyle();
    }

    /**
     * Used to get the x coorrd of the imageButton
     * 
     * @return x the x of the imageButton
     */
    public float getX() {
        return x;
    }

    /**
     * Used to get the width coorrd of the imageButton
     * 
     * @return width the width of the imageButton
     */
    public float getWidth() {
        return width;
    }

    /**
     * Used to get the height coorrd of the imageButton
     * 
     * @return height the height of the imageButton
     */
    public float getHeight() {
        return height;
    }

    /**
     * Used to check if the mouse is over the button
     * 
     * @param mouseX the x of the mouse
     * @param mouseY the y of the mouse
     */
    public boolean overButton(int mouseX, int mouseY) {
        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            return true;
        } else {
            return false;
        }
    }

}