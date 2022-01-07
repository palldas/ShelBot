package com.shelbot.utils;

import java.awt.Color;

import processing.core.PApplet;

/**
 * This class models a Section. It is used to display different windows
 * throughout the program using Processing PApplet.
 * 
 * @author  
 * @version 5/10/20
 */
public class Section {

	private int sP, eP;
	private Color bg;

	private float width;
	private float height;
	private float x;

	public static int zero;

	/**
	 * Creates a new instance of a Section object with how much space it will take
	 * up, determined by the startingPercent and endingPercent of the window,and the
	 * color the window will be
	 * 
	 * @param startingPercent startingPercent of the window
	 * @param endingPercent   endingPercent of the window
	 * @param color           Color of the window
	 */
	public Section(int startingPercent, int endingPercent, Color color) {
		this.sP = startingPercent;
		this.eP = endingPercent;
		this.bg = color;
	}

	/**
	 * Draws a new instance of a Section object
	 * 
	 * @param applet the PApplet to be used to draw the section
	 */
	public void draw(PApplet applet) {
		zero = (int) TabbedPane.tabHeight;
		float ePX = (float) ((eP / 100.0) * applet.width);
		float sPX = (float) ((sP / 100.0) * applet.width);
		this.x = sPX;
		this.width = (ePX - sPX);
		this.height = applet.height;
		applet.pushStyle();
		applet.fill(bg.getRGB());
		applet.rect(sPX, zero, (ePX - sPX), applet.height);
		applet.line(ePX, zero, ePX, applet.height);
		applet.popStyle();
	}

	/**
	 * Returns the width of the section
	 * 
	 * @return the width the section takes up of the window
	 */
	public float getWidth() {
		return width;
	}

	public float getHeight(){
		return height;
	}

	/**
	 * Returns the starting main x-coordinate of the section
	 * 
	 * @return the starting x-coordinate of the section
	 */
	public float getX() {
		return x;
	}

	/**
	 * Returns the starting main x-coordinate of the section
	 * 
	 * @return the starting x-coordinate of the section
	 */
	public float getY() {
		return TabbedPane.tabHeight;
	}

	/**
	 * Used to check if an x and y point is within the section
	 * @param objX the x that has to be checked
	 * @param objY the y that has to be checked
	 * @return doesContain true if the section contains the point
	 */
	public boolean contains(float objX, float objY){
		if(objX > x && objX < x+width && objY > 0 && objY < height){
			return true;
		}
		else{
			return false;
		}
	}

}