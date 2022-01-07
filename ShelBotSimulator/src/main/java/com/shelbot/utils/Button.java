package com.shelbot.utils;

import java.awt.Color;

import com.shelbot.SimulatorWindow;

import processing.core.PApplet;

/**
 * This class models a Button. It can be used to switch between different tabs
 * and is drawn using Processing PApplet.
 * 
 * @author  
 * @version 5/10/20
 */
public class Button {

    private int x;
    private int y;
    private float width;
    private float height;
    private String text;

    private Color color;
    private Color textColor = null;
    private int textSize = 0;
    private boolean hasIcon;
    protected boolean isHighlight;

    protected Color highlightColor = new Color(233, 238, 242);

    public boolean overButton;

    public Button() {

    }

    /**
     * Creates a new instance of a Button object with a starting x and y coordinate, a
     * button width and height, the text representing the button, and not having an
     * icon or color
     * 
     * @param x      main x-coordinate of the button
     * @param y      main y-coordinate of the button
     * @param width  the width of the button
     * @param height the height/length of the button
     * @param text   states what the button represents
     */
    public Button(int x, int y, float width, float height, String text) {
        new Button(x, y, width, height, text, false, null);
    }

    /**
     * Creates a new instance of a Button object with a starting x and y coordinate, a
     * button width and height, the text representing the button, the color of the
     * button, and whether or not the button has an icon
     * 
     * @param x       main x-coordinate of the button
     * @param y       main y-coordinate of the button
     * @param width   the width of the button
     * @param height  the height/length of the button
     * @param text    states what the button represents
     * @param hasIcon states whether or not the button is represented by an icon or
     *                not
     * @param color   the color the button will be filled with
     * 
     */
    public Button(int x, int y, float width, float height, String text, boolean hasIcon, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.hasIcon = hasIcon;
        this.color = color;
    }

    /**
     * Creates a new instance of a Button object with a starting x and y coordinate, a
     * button width and height, the text representing the button, the color of the
     * button, and whether or not the button has an icon
     * 
     * @param x       main x-coordinate of the button
     * @param y       main y-coordinate of the button
     * @param width   the width of the button
     * @param height  the height/length of the button
     * @param text    states what the button represents
     * @param textColor the color of the text
     * @param textSize   the size of the text
     * 
     */
    public Button(int x, int y, float width, float height, String text, Color textColor, int textSize) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.textColor = textColor;
        this.textSize = textSize;
    }

    /**
     * Draws a new instance of a Button object
     * 
     * @param applet the PApplet to be used to draw the button
     */
    public void draw(PApplet applet) {
        applet.pushStyle();
        applet.textAlign(applet.CENTER, applet.CENTER);
        if (isHighlight) {
            applet.fill(highlightColor.getRGB());
        }
        applet.rect(x, y, width, height);
        // System.out.println(1222 + " " + x + " " + width + " " + height + "");
        float textHeight;
        if (hasIcon) {
            applet.ellipseMode(applet.CENTER);
            applet.fill(color.getRGB());
            applet.ellipse(x + width / 2.0f, y + height / 3.0f, 0.3f * width, 0.3f * height);
            textHeight = y + height / 4.0f * 3;
        } else {
            textHeight = y + height / 2.0f;
            applet.fill(Color.black.getRGB());
        }
        if (textColor != null) {
            applet.fill(textColor.getRGB());
        }
        if (textSize == 0) {
            applet.textSize(SimulatorWindow.textSize);
        } else {
            applet.textSize(textSize);
        }
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
     * @return overButton true if over the button
     */
    public boolean overButton(int mouseX, int mouseY) {
        if (mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + height) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Used to get the width of the button
     * 
     * @return width the width of the button
     */
    public float getWidth() {
        return width;
    }

    /**
     * Used to get the height of the button
     * 
     * @return height the height of the button
     */
    public float getHeight() {
        return height;
    }

    /**
     * Used to get the y of the button
     * 
     * @return y the y of the button
     */
    public int getY() {
        return y;
    }

    /**
     * Used to get the x of the button
     * 
     * @return x the x of the button
     */
    public float getX() {
        return x;
    }

    /**
     * Used to set the x of the button
     * 
     * @param x the x of the button
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Used to set the y of the button
     * 
     * @param y the y of the button
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Used to set the width of the button
     * 
     * @param width the width of the button
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     * Used to set the height of the button
     * 
     * @param height the height of the button
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     * Used to set the text of the button
     * 
     * @param newText the text of the button
     */
    public void setText(String newText) {
        this.text = newText;
    }

    /**
     * Used to set the textColor of the button
     * 
     * @param newColor the textColor of the button
     */
    public void setTextColor(Color newColor) {
        this.textColor = newColor;
    }

    /**
     * Used to set the textSize of the button
     * 
     * @param size the textSize of the button
     */
    public void setTextSize(int size) {
        this.textSize = size;
    }
}