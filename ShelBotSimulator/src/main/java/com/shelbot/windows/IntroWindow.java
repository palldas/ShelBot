package com.shelbot.windows;

import java.awt.Color;

import com.shelbot.utils.Button;
import com.shelbot.utils.Section;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

/**
 * The first window that shows up when the program starts. Shows a loading bar.
 * 
 * @author 
 * @version 5/16/20
 */
public class IntroWindow extends Section {

    private PImage img;
    private double barPercent;
    //private boolean overHelp;

    /**
     * Creates the IntroWindow
     */
    public IntroWindow() {
        super(100, 100, Color.white);
        barPercent = 0;
       
    }

    /**
     * Runs at the start of the program
     * @param marker PApplet used to draw the IntroWindow
     */
    public void setup(PApplet marker) {
        img = marker.loadImage("src/main/resources/icon.png");
    }

    /**
     * Draws this IntroWindow, includes: title, icon of program, and a loading bar.
     * 
     * @param marker PApplet used to draw the IntroWindow
     */
    public void draw(PApplet marker) {
        super.draw(marker);

        marker.pushStyle();
        barPercent = (marker.millis() - 8000) / (1000 * 5.0);
        if (barPercent < 0)
            barPercent = 0;
        if (barPercent > 1.001)
            barPercent = 1;

        float w = marker.width;
        float h = marker.height;
        marker.image(img, (w - h/4) / 2, h / 8, h / 4, h / 4);
        marker.textAlign(PConstants.CENTER, PConstants.CENTER);
        marker.fill(0);
        marker.textSize(0.08f*w);;
        marker.text("SHELBOT", w/2, h/2);

        marker.rectMode(PConstants.CENTER);
        marker.fill(255);
        marker.rect(w/2, 3*h/4, w/3, h/10);
        marker.fill(52, 235, 120);
        marker.stroke(52, 235, 125);
        marker.rectMode(PConstants.CORNER);
        marker.rect(w/2 - (w/3 - 10)/2, 3*h/4 - (h/10 - 10)/2, (float)((w/3 - 10)*barPercent), h/10 - 10);

        marker.popStyle();
    }

    /**
     * Tracks progress of the loading bar. 
     * @return true if the bar is loaded.
     */
    public boolean isLoaded() {
        return barPercent >= 1;
    }

}