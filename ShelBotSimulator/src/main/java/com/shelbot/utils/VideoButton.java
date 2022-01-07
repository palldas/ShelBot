package com.shelbot.utils;

import java.awt.Color;

import com.shelbot.SimulatorWindow;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class models a Button. It can be used to switch between different tabs
 * and is drawn using Processing PApplet.
 * 
 * @author  
 * @version 5/10/20
 */
public class VideoButton {

    private float x;
    private float y;
    private float width;
    private float height;
    private String text, link;

    private PImage img;

    protected boolean isHighlight;

    public boolean overButton;

    protected Color highlightColor = new Color(233, 238, 242);

    /**
     * Creates a new instance of a Button object with a starting x and y coordinate, a
     * button width and height, the text representing the button, the color of the
     * button, and whether or not the button has an icon
     * 
     * @param x       main x-coordinate of the button
     * @param y       main y-coordinate of the button
     * @param width   the width of the button
     * @param height  the height/length of the button
     * @param img   the snapshot of the video
     * @param text    the title of the video
     * @param link the link to redirect the VideoButton to
     */
    public VideoButton(float x, float y, float width, float height, PImage img, String text, String link) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.img = img;
        this.link = link;
    }

    /**
     * Draws a new instance of a Button object
     * 
     * @param applet the PApplet to be used to draw the button
     */
    public void draw(PApplet applet) {
        applet.pushStyle();
        if (isHighlight) {
            applet.fill(highlightColor.getRGB());
        }
        applet.rect(x, y, width, height);
        applet.popStyle();

        applet.pushStyle();
        float border =   0.08f*height;
        // img.filter(applet.BLUR, 6);
        applet.image(img, x+border, y+border, width-2*border, height-2*border);
        applet.popStyle();

        applet.pushStyle();
        applet.textAlign(applet.CENTER, applet.CENTER);
        float textHeight = y + height / 2.0f;
        applet.fill(Color.black.getRGB());
        applet.textSize(SimulatorWindow.textSize);
        applet.text(text, x + width / 2.0f, textHeight);
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
     * @return overButton true if overbutton
     */
    public boolean overButton(int mouseX, int mouseY) {
        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Used to get the width of the VideoButton
     * @return width the width of the videoButton
     */
    public float getWidth(){
        return width;
    }

    /**
     * Used to get the height of the VideoButton
     * @return height the height of the videoButton
     */
    public float getHeight(){
        return height;
    }

    /**
     * Used to get the y of the VideoButton
     * @return y the y of the videoButton
     */
    public float getY(){
        return y;
    }

    /**
     * Used to set the x of the VideoButton
     * @param x the new x of the videoButton
     */
    public void setX(float x){
        this.x = x;
    }

    /**
     * Used to set the y of the VideoButton
     * @param y the new y of the videoButton
     */
    public void setY(float y){
        this.y = y;
    }

    /**
     * Used to set the width of the VideoButton
     * @param width the new width of the videoButton
     */
    public void setWidth(float width){
        this.width = width;
    }

    /**
     * Used to set the height of the VideoButton
     * @param height the new height of the videoButton
     */
    public void setHeight(float height){
        this.height = height;
    }

    /**
     * Used to open the link of the videoButton
     * @param applet the PApple object used to open the link
     */
    public void openLink(PApplet applet){
        applet.link(link);
    }
}