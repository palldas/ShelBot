package com.shelbot.windows;

import java.awt.Color;

import com.shelbot.comms.ConnectionVerifier;
import com.shelbot.controller.Joycons;
import com.shelbot.controller.Xbox;
import com.shelbot.utils.Button;
import com.shelbot.utils.Section;
import com.studiohartman.jamepad.ControllerManager;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents a menu with options- Control, Auton, Taylor Mode, Shelby Mode The
 * menu can also shift to the left or right
 * 
 * @author  
 * @version 5/15/20
 */
public class TeleopWindow extends Section {

	private static CurrentView view;

	private boolean autonActivated = false;
	private boolean taylorModeActivated = false;
	private boolean shelbyModeActivated = false;

	private boolean isConnected = false;

	private Button enable;

	private Joycons joycons = new Joycons();

	ControllerManager controllers = new ControllerManager();

	/**
	 * Represents the currentView of the teleop window
	 * TELEOP - for teleop control
	 * AUTON - for autonomous control
	 * SHELBYMODE - sets robot to shelby mode
	 * TAYLORMODE - sets robot to taylor mode
	 */
	public enum CurrentView{
		TELEOP, 
		AUTON, 
		SHELBYMODE, 
		TAYLORMODE
	}

	/**
	 * Used to make a teleopWindow
	 */
	public TeleopWindow() {
		super(21, 100, Color.white);
		view = CurrentView.TELEOP;
		controllers.initSDLGamepad();
		enable = new Button((int)(getX() + (int)0.2*getWidth()), (int)(getY() + (int)0.8*getHeight()), 0.6f*getWidth(), 0.1f*getHeight(), "Enable", Color.gray, (int)(0.8*0.8*getHeight()));
	}

	/**
	 * Used to get the currentview of the teleop window
	 * @return view the currrent view of the window
	 */
	public static CurrentView getCurrentView(){
		return view;
	}

	/**
	 * Used to set the currentview of the teleop window
	 * @param newView view of the window to be set
	 */
	public static void setCurrentView(CurrentView newView){
		view = newView;
	}

	/**
	 * Used to draw the teleopWindow
	 * @param applet the PApplet object used to draw
	 */
	public void draw(PApplet applet){
		super.draw(applet);
		applet.pushStyle();
		applet.textAlign(applet.CENTER, applet.CENTER);
		applet.textSize(0.08f*getWidth());
		if(ConnectionVerifier.isConnected()){
			applet.fill(Color.green.getRGB());
			applet.text("Robot Connected", getX() + getWidth()/2, 0.12f*getHeight());
			isConnected = true;
		}
		else{
			applet.fill(Color.red.getRGB());
			applet.text("Robot Disconnected", getX() + getWidth()/2, 0.12f*getHeight());
			isConnected = false;
		}		

		applet.fill(Color.red.getRGB());
		applet.text("Robot Disconnected", getX() + getWidth()/2, 0.12f*getHeight());

		PImage xbox = applet.loadImage("xbox.png");
		PImage joycon = applet.loadImage("joycon.png");


		if(!joycons.leftJoycon.isConnected || !joycons.rightJoycon.isConnected){
			joycon.filter(applet.GRAY);
		}
		else if(!controllers.getControllerIndex(0).isConnected()){
			xbox.filter(applet.GRAY);
		}
		else{
			new Xbox();
		}

		if(getCurrentView().equals(CurrentView.TELEOP)){
			applet.imageMode(applet.CENTER);
			applet.image(xbox, getX()+0.25f*getWidth(), getY()+0.5f*getHeight(), 0.5f*getWidth(), 0.3f*getWidth());
			applet.image(joycon, getX()+0.75f*getWidth(), getY()+0.5f*getHeight(), 0.5f*getWidth(), 0.3f*getWidth());
		}
		else if(getCurrentView().equals(CurrentView.AUTON)){
			applet.textSize(0.05f*getWidth());;
			applet.fill(Color.black.getRGB());
			String state;
			if(autonActivated){
				state = "Activated";
				applet.fill(Color.green.getRGB());
			}
			else{
				state = "Deactivated";
				applet.fill(Color.red.getRGB());
			}
			applet.text("Autonomous Control " + state, getX()+getWidth()/2, getY()+getHeight()/2);
		}
		else if(getCurrentView().equals(CurrentView.TAYLORMODE)){
			applet.textSize(0.05f*getWidth());;
			applet.fill(Color.black.getRGB());
			String state;
			if(taylorModeActivated){
				state = "Activated";
				applet.fill(Color.green.getRGB());
			}
			else{
				state = "Deactivated";
				applet.fill(Color.red.getRGB());
			}
			applet.text("Taylor Mode " + state, getX()+getWidth()/2, getY()+getHeight()/2);
		}
		else if(getCurrentView().equals(CurrentView.SHELBYMODE)){
			applet.textSize(0.05f*getWidth());;
			applet.fill(Color.black.getRGB());
			String state;
			if(shelbyModeActivated){
				state = "Activated";
				applet.fill(Color.green.getRGB());
			}
			else{
				state = "Deactivated";
				applet.fill(Color.red.getRGB());
			}
			applet.text("Shelby Mode " + state, getX()+getWidth()/2, getY()+getHeight()/2);
		}

		applet.popStyle();

		applet.pushStyle();
		enable.setX((int)(getX()+0.25f*getWidth()));
		enable.setY((int)(getHeight()-enable.getHeight()-0.025f*getHeight()));
		enable.setWidth(0.5f*getWidth());
		enable.setHeight(0.1f*getWidth());
		int textSize = ((0.08*enable.getWidth()>0.08*enable.getHeight()) ? (int)(0.08*enable.getWidth()) : (int)(0.08*enable.getHeight()));
		// enable.setTextSize((int)(0.08f*getWidth()));
		enable.setTextSize(textSize);

		if(enable.overButton){
			enable.highlight(true);
		}
		else{
			enable.highlight(false);
		}
		
		if(isConnected){
			enable.setTextColor(Color.green);
		}
		else{
			enable.setTextColor(Color.gray);
		}

		enable.draw(applet);
		applet.popStyle();
	}

	/**
	 * Deals with mouseMoved events
	 * @param mouseX the x of the mouse
	 * @param mouseY the y of the mouse
	 */
	public void mouseMoved(int mouseX, int mouseY){
		if(enable.overButton(mouseX, mouseY)){
			enable.overButton = true;
		}
		else{
			enable.overButton = false;
		}
    }

}
