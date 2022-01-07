package com.shelbot.utils;

import java.awt.Color;

import com.shelbot.SimulatorWindow;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Used to make a popup
 * 
 * @author  
 * @version 5/17/20
 */
public class Popup {

    private int x, y;
    private float width, height;

    private Bar bar;

    private Button tutorials;
    private Button close;

    private boolean isClosed;

    private PImage img;
    private VideoButton link;

    private PApplet applet;

    /**
     * Used to create a popup
     * 
     * @param x      the x coord of the popup
     * @param y      the y coorrd of the popup
     * @param width  the width of the popup
     * @param height the height of the popup
     */
    public Popup(int x, int y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bar = new Bar(new Color(96, 207, 146));
        tutorials = new Button((int) (x + 0.08f * width), (int) (y + 0.08f * bar.getHeight()), 0.1f * width,
                0.8f * bar.getHeight(), "Tutorials", false, null);
        close = new Button((int) (x + width - 0.08f * width - 0.1f * width), (int) (y + 0.08f * bar.getHeight()),
                0.1f * width, 0.8f * bar.getHeight(), "Close", false, null);

    }

    /**
     * Used to setup the popup
     * 
     * @param applet the PApplet object
     */
    public void setup(PApplet applet) {
        img = applet.loadImage("popup.png");
        link = new VideoButton((float) x, (float) y, width, height, img, "Click Here to\nWatch the Quick\nStart Guide",
                "https://www.youtube.com/watch?v=Cumqtocl4v4&feature=youtu.be");

    }

    /**
     * Used to start the video of the popup
     */
    public void startVideo() {
    }

    /**
     * Used to draw the popup
     * 
     * @param applet the PApplet object used to draw the popup
     */
    public void draw(PApplet applet) {
        this.applet = applet;
        applet.pushStyle();
        applet.fill(new Color(199, 199, 199).getRGB());
        applet.rect(x, y, width, height);
        bar.draw(applet);

        applet.fill(Color.white.getRGB());
        tutorials.setX((int) (x + 0.008f * width));
        tutorials.setY((int) (y + 0.08f * bar.getHeight()));
        tutorials.setWidth(0.2f * width);
        tutorials.setHeight(0.8f * bar.getHeight());
        if (tutorials.overButton) {
            tutorials.highlight(true);
        } else {
            tutorials.highlight(false);
        }
        tutorials.draw(applet);

        close.setX((int) ((x + width) - (0.2f * width)));
        close.setY((int) (y + 0.08f * bar.getHeight()));
        close.setWidth(0.2f * width);
        close.setHeight(0.8f * bar.getHeight());
        if (close.overButton) {
            close.highlight(true);
        } else {
            close.highlight(false);
        }
        close.draw(applet);

        link.setX(x);
        link.setY(y + bar.getHeight());
        link.setWidth(width);
        link.setHeight(height);
        if (link.overButton) {
            link.highlight(true);
        } else {
            link.highlight(false);
        }
        link.draw(applet);

        applet.popStyle();
    }

    /**
     * Used to deal with mouseClicks in the popup
     * 
     * @param mouseX the x coord of the mouse
     * @param mouseY the y coord of the mouse
     */
    public void mouseClicked(int mouseX, int mouseY) {
        if (tutorials.overButton(mouseX, mouseY)) {
            SimulatorWindow.tabs.setCurrentView(TabbedPane.CurrentView.TUTORIAL);
        }
        if (close.overButton(mouseX, mouseY)) {
            isClosed = true;
        }
        if (link.overButton(mouseX, mouseY)) {
            link.openLink(applet);
        }
    }

    /**
     * Used to deal with mouse movements in the popup
     * 
     * @param mouseX the x coord of the mouse
     * @param mouseY the y coord of the mouse
     */
    public void mouseMoved(int mouseX, int mouseY) {
        if (tutorials.overButton(mouseX, mouseY)) {
            tutorials.overButton = true;
        } else {
            tutorials.overButton = false;
        }
        if (close.overButton(mouseX, mouseY)) {
            close.overButton = true;
        } else {
            close.overButton = false;
        }
        if (link.overButton(mouseX, mouseY)) {
            link.overButton = true;
        } else {
            link.overButton = false;
        }
    }

    /**
     * Used to check if the popup has been closed by the user
     * 
     * @return isClosed true if the user has pressed close
     */
    public boolean isClosed() {
        return isClosed;
    }

    /**
     * Used to update the attributes of the popup
     * 
     * @param x      the new x of the popup
     * @param y      the new y of the popup
     * @param width  the new width of the popup
     * @param height the new height of the popup
     */
    public void updateAttr(int x, int y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    private class Bar {

        private Color color;

        public Bar(Color color) {
            this.color = color;
        }

        public void draw(PApplet applet) {
            applet.pushStyle();
            applet.fill(color.getRGB());
            applet.rect(x, y, width, 0.15f * height);
            applet.popStyle();
        }

        public float getHeight() {
            return 0.15f * height;
        }
    }

}