package com.shelbot.windows;

import java.awt.Color;
import java.util.ArrayList;

import com.shelbot.utils.Section;
import com.shelbot.utils.TabbedPane;
import com.shelbot.utils.VideoButton;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents the tutorial tab
 * 
 * @author  
 * @version 5/15/20
 */
public class Tutorials extends Section {

    private float leftMargin;
    private float topMargin;

    public ArrayList<VideoButton> vids = new ArrayList();

    /**
     * Used to make the tutorials tab
     */
    public Tutorials() {
        super(0, 100, Color.white);
    }

    /**
     * Used to setup the window
     * 
     * @param applet the PApplet object used to setup
     */
    public void setup(PApplet applet) {
        leftMargin = getX() + (0.006f * applet.width);
        topMargin = 0.025f * applet.height;
        PImage img = applet.loadImage("popup.png");
        img.filter(applet.BLUR, 15);
        vids.add(new VideoButton(leftMargin, TabbedPane.tabHeight + topMargin, 0.1f * getWidth(), 0.25f * getHeight(),
                img, "Quick Start Guide", "https://www.youtube.com/watch?v=Cumqtocl4v4&feature=youtu.be"));
    }

    /**
     * Used to draw the window
     * 
     * @param applet The PApplet object used to draw
     */
    public void draw(PApplet applet) {
        super.draw(applet);
        leftMargin = getX() + (0.02f * getWidth());
        topMargin = TabbedPane.tabHeight + 0.025f * getHeight();
        float nextX = leftMargin;
        float nextY = topMargin;
        for (VideoButton vid : vids) {
            vid.setX(nextX);
            vid.setY(nextY);
            vid.setWidth(0.24f * getWidth());
            vid.setHeight(0.18f * getHeight());
            vid.draw(applet);
            if ((nextX + 2 * vid.getWidth() + (leftMargin - getX())) >= getX() + getWidth()) {
                nextX = leftMargin;
                nextY += vid.getWidth() + (topMargin - TabbedPane.tabHeight);
            } else {
                nextX += vid.getWidth() + (leftMargin - getX());
            }
            if (vid.overButton) {
                vid.highlight(true);
            } else {
                vid.highlight(false);
            }
        }
    }

    /**
     * Deals with mouseMoved events
     * 
     * @param mouseX the x of the mouse
     * @param mouseY the y of the mouse
     */
    public void mouseMoved(int mouseX, int mouseY) {
        for (VideoButton vid : vids) {
            if (vid.overButton(mouseX, mouseY)) {
                vid.overButton = true;
            } else {
                vid.overButton = false;
            }
        }
    }

    /**
     * Deals with mousePressed events
     * 
     * @param applet the PApplet object
     * @param mouseX the x of the mouse
     * @param mouseY the y of the mouse
     */
    public void mousePressed(PApplet applet, int mouseX, int mouseY) {
        for (VideoButton vid : vids) {
            if (vid.overButton(mouseX, mouseY)) {
                vid.openLink(applet);
            }
        }
    }

}