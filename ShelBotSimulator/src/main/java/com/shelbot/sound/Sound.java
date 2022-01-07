package com.shelbot.sound;

import java.awt.Color;

import com.shelbot.SimulatorWindow;

import ddf.minim.Minim;
import processing.core.PApplet;

/**
 * Represents a sound
 * 
 * @author  
 * @version 5/13/20
 */
public class Sound {

    private float x, y, size;
    private Player player;
    private boolean isHighlight = false;

    public boolean overButton = false;

    protected Color highlightColor = new Color(233, 238, 242);

    public static Minim minim;

    /**
     * Used to make a sound
     * 
     * @param x      the x coor of the sound
     * @param y      the y coord of the sound
     * @param size   the size of the sound button
     * @param player the player behind the sound button
     */
    public Sound(float x, float y, float size, Player player) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.player = player;
    }

    /**
     * Used to draw the sound button
     * 
     * @param applet PApplet object
     */
    public void draw(PApplet applet) {
        applet.pushStyle();
        applet.textAlign(applet.CENTER, applet.CENTER);
        if (isHighlight) {
            applet.fill(highlightColor.getRGB());
        }
        applet.rect(x, y, size, size);
        float textHeight = y + size / 2.0f;
        applet.fill(Color.black.getRGB());
        applet.textSize(SimulatorWindow.textSize);
        applet.text(player.getFileName(), x + size / 2.0f, textHeight);
        applet.popStyle();
    }

    /**
     * Changes the color of the button in order to show that it has been highlighted
     * 
     * @param isHighlight states whether or not the button is highlighted
     */
    public void highlight(boolean isHighlight) {
        this.isHighlight = isHighlight;
    }

    /**
     * Determines if the point (x,y) is contained inside a Button object
     * 
     * @param mouseX the x-coordinate tested for being over the button
     * @param mouseY the y-coordinate tested for being over the button
     * @return overButton true if overButton
     */
    public boolean overButton(int mouseX, int mouseY) {
        if (mouseX >= x && mouseX <= x + size && mouseY >= y && mouseY <= y + size) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * used to get width
     * 
     * @return width the width of the button
     */
    public float getWidth() {
        return size;
    }

    /**
     * used to get y
     * 
     * @return y the y of the button
     */
    public float getY() {
        return y;
    }

    /**
     * used to set x
     * 
     * @param newX the x of the button
     */
    public void setX(float newX) {
        this.x = newX;
    }

    /**
     * used to set y
     * 
     * @param newY the y of the button
     */
    public void setY(float newY) {
        this.y = newY;
    }

    /**
     * used to set size
     * 
     * @param newSize the size of the button
     */
    public void setSize(float newSize) {
        this.size = newSize;
    }

    /**
     * used to get player
     * 
     * @return player the player of the button
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * used to convert toString
     * 
     * @return the name of the file this button plays
     */
    public String toString() {
        return player.getFileName();
    }

}