package com.shelbot;

import java.io.File;

import com.shelbot.sound.Player;
import com.shelbot.sound.Sound;
import com.shelbot.utils.TabbedPane;
import com.shelbot.windows.BlocksCategoryWindow;
import com.shelbot.windows.BlocksWindow;
import com.shelbot.windows.IntroWindow;
import com.shelbot.windows.ProgrammingWindow;
import com.shelbot.windows.SoundList;
import com.shelbot.windows.Sounds;
import com.shelbot.windows.SpriteWindow;
import com.shelbot.windows.TeleopList;
import com.shelbot.windows.TeleopWindow;
import com.shelbot.windows.Tutorials;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class is the DrawingSurface. It is where all the Windows and Blocks are
 * drawn using Processing PApplet.
 * 
 * @author Pallavi Das,  , 
 * @version 5/1/20
 */
public class SimulatorWindow extends PApplet {

	private IntroWindow introWindow;
	private TeleopWindow teleWindow;
	private TeleopList teleList;
	private ProgrammingWindow proWindow;
	private BlocksCategoryWindow blockCategories;
	private Sounds soundBar;
	private SoundList soundList;

	private Tutorials tutorials;
	
	public static SpriteWindow spriteWindow;
	public static BlocksWindow blockBank;

	public static TabbedPane tabs;

	public static float textSize = 1000*0.008f;

	/**
	 * Used to make simulator window
	 */
	public SimulatorWindow() {
		this.introWindow = new IntroWindow();
		this.proWindow = new ProgrammingWindow();
		this.teleList = new TeleopList();
		this.teleWindow = new TeleopWindow();
		this.blockCategories = new BlocksCategoryWindow();
		blockBank = new BlocksWindow();
		spriteWindow = new SpriteWindow();
		this.tabs = new TabbedPane();
		this.soundBar = new Sounds();
		this.soundList = new SoundList();
		this.tutorials = new Tutorials();
	}

	/**
	 * Deals with mouseDragged events
	 */
	public void mouseDragged() {
		if (introWindow.isLoaded()) {
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.CODE)){
				blockBank.mouseDragged((this.mouseX), (this.mouseY));
				proWindow.mouseDragged((this.mouseX), (this.mouseY));
			}
		}
	}

	/**
	 * Deals with mousePressed events
	 */
	public void mousePressed() {
		if (introWindow.isLoaded()) {
			tabs.mousePressed(mouseX, mouseY);
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.CODE)){
				blockCategories.mousePressed(mouseX, mouseY);
			}
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.SOUND)){
				soundList.mousePressed(mouseX, mouseY);
				soundBar.mousePressed(mouseX, mouseY);
			}
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.TUTORIAL)){
				tutorials.mousePressed(this, mouseX, mouseY);
			}
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.CONTROL)){
				teleList.mousePressed(mouseX, mouseY);
			}
		}
	}

	/**
	 * Deals with mouseReleased events
	 */
	public void mouseReleased() {
		if (introWindow.isLoaded()) {
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.CODE)){
				blockCategories.mouseReleased();
				blockBank.mouseReleased();
				proWindow.mouseReleased();
			}
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.SOUND)){
				soundList.mouseReleased();
			}
		}
	}

	/**
	 * Deals with mouseMoved events
	 */
	public void mouseMoved(){
		if (introWindow.isLoaded()) {
			tabs.mouseMoved(mouseX, mouseY);
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.SOUND)){
				soundBar.mouseMoved(mouseX, mouseY);
				soundList.mouseMoved(mouseX, mouseY);
			}
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.TUTORIAL)){
				tutorials.mouseMoved(mouseX, mouseY);
			}
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.CONTROL)){
				teleList.mouseMoved(mouseX, mouseY);
				teleWindow.mouseMoved(mouseX, mouseY);
			}
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.CODE)){
				proWindow.mouseMoved(mouseX, mouseY);
			}
		}
	}

	/**
	 * Deals with mouseClicked events
	 */
	public void mouseClicked(){
		if(introWindow.isLoaded()) {
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.CODE)){
				proWindow.mouseClicked(mouseX, mouseY);
			}
		}
	}

	/**
	 * Deals with the file once it is selected
	 * @param selection the selected file
	 */
	public void fileSelected(File selection) {
        if (selection == null) {
          System.out.println("Window was closed or the user hit cancel.");
        } else {
          System.out.println("User selected " + selection.getAbsolutePath());
          SoundList.sounds.add(new Sound(700, 100, 100, new Player(this, selection.getName().substring(0, 5)+"\n...", selection.getPath())));
        }
    }

	/**
	 * Used to setup
	 */
	public void setup(){
		PImage icon = this.loadImage("icon.png");
		ShelBot.surf.setIcon(icon);
		PApplet applet = this;
		Thread thread = new Thread(){
			public void run(){
				tutorials.setup(applet); 
			}
		};
		thread.start();
		proWindow.setup(this);
		soundList.setup(this);
		teleList.setup(this);
		introWindow.setup(this);
		spriteWindow.setup(this);
	}

	/**
	 * Used to draw
	 */
	public void draw() {
		textSize = this.width*0.008f;
		background(255, 255, 255);
		if (!introWindow.isLoaded())
			introWindow.draw(this);
		else {
			tabs.draw(this);
			if(tabs.getCurrentView().equals(TabbedPane.CurrentView.CODE)){
				blockCategories.draw(this);
				blockBank.draw(this);
				proWindow.draw(this);
				spriteWindow.draw(this);
			}
			else if(tabs.getCurrentView().equals(TabbedPane.CurrentView.CONTROL)){
				teleWindow.draw(this);
				teleList.draw(this);
			}
			else if(tabs.getCurrentView().equals(TabbedPane.CurrentView.SOUND)){
				soundBar.draw(this);
				spriteWindow.draw(this);
				soundList.draw(this);
			}
			else if(tabs.getCurrentView().equals(TabbedPane.CurrentView.TUTORIAL)){
				tutorials.draw(this);			
			}
		}
		
	}
}
