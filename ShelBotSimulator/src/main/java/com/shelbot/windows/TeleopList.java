package com.shelbot.windows;

import java.awt.Color;
import java.util.ArrayList;

import com.shelbot.comms.NetworkTables;
import com.shelbot.utils.Button;
import com.shelbot.utils.Section;
import com.shelbot.utils.TabbedPane;

import processing.core.PApplet;

/**
 * This represents the teleop list to choose between different ways to control the robot
 * 
 * @author  
 * @version 5/15/20
 */
public class TeleopList extends Section {

    /**
     * Used to make teleop list
     */
    public TeleopList() {
        super(0, 21, Color.white);
        startX = 0;
        buttons = new ArrayList();
        // TODO Auto-generated constructor stub
    }

    private float startX;
    private float minX;
    private ArrayList<Button> buttons;

    private float leftMargin;
    private float topMargin;
    private float size;

    private float spacer, boxWidth;

    /**
     * Used to setup the teleopList
     * @param applet The papplet object used to setup
     */
    public void setup(PApplet applet) {
        spacer = getWidth() / 16;
        boxWidth = getWidth() / 4;
        buttons.add(new Button((int) (startX + spacer), (int) getHeight() / 3, boxWidth, getHeight() / 3,
                "Teleoperated\nControl", false, null));
        buttons.add(new Button((int) (startX + 2 * spacer + 1 * boxWidth), (int) getHeight() / 3, boxWidth,
                getHeight() / 3, "Autonomous\nControl", false, null));
        buttons.add(new Button((int) (startX + 3 * spacer + 2 * boxWidth), (int) getHeight() / 3, boxWidth,
                getHeight() / 3, "Shelby\nMode", false, null));
        buttons.add(new Button((int) (startX + 4 * spacer + 3 * boxWidth), (int) getHeight() / 3, boxWidth,
                getHeight() / 3, "Taylor\nMode", false, null));

    }

    /**
     * draws this window, displays three of the options in the window and one off
     * screen as well as a scroll bar
     * 
     * @param applet the PApplet object
     */
    public void draw(PApplet applet) {
        super.draw(applet);
        leftMargin = getX() + (0.02f * getWidth());
        topMargin = TabbedPane.tabHeight + 0.025f * getHeight();
        size = 0.45f * getWidth();
        int nextX = (int) leftMargin;
        int nextY = (int) topMargin;
        for (Button button : buttons) {
            button.setX(nextX);
            button.setY(nextY);
            button.setWidth(size);
            button.setHeight(size);
            button.draw(applet);
            if ((nextX + 2 * button.getWidth() + (leftMargin - getX())) >= getX() + getWidth()) {
                nextX = (int) leftMargin;
                nextY += button.getWidth() + (topMargin - TabbedPane.tabHeight);
            } else {
                nextX += button.getWidth() + (leftMargin - getX());
            }
            if(button.overButton){
                button.highlight(true);
            }
            else{
                button.highlight(false);
            }
        }
    }

    /**
     * @param mouseX the x of the mouse
     * @param mouseY the y of the mouse
     */
    public void mousePressed(int mouseX, int mouseY) {
        if (buttons.get(0).overButton(mouseX, mouseY)) {
            TeleopWindow.setCurrentView(TeleopWindow.CurrentView.TELEOP);
            NetworkTables.updateControlType(TeleopWindow.CurrentView.TELEOP);
        }
        else if (buttons.get(1).overButton(mouseX, mouseY)) {
            TeleopWindow.setCurrentView(TeleopWindow.CurrentView.AUTON);
            NetworkTables.updateControlType(TeleopWindow.CurrentView.AUTON);
        }
        else if (buttons.get(2).overButton(mouseX, mouseY)) {
            TeleopWindow.setCurrentView(TeleopWindow.CurrentView.SHELBYMODE);
            NetworkTables.updateControlType(TeleopWindow.CurrentView.SHELBYMODE);
        }
        else if (buttons.get(3).overButton(mouseX, mouseY)) {
            TeleopWindow.setCurrentView(TeleopWindow.CurrentView.TAYLORMODE);
            NetworkTables.updateControlType(TeleopWindow.CurrentView.TAYLORMODE);
        }

    }

    /**
     * Deals with mouseMoved events
     * @param mouseX the x of the mouse
     * @param mouseY the y of the mouse
     */
    public void mouseMoved(int mouseX, int mouseY) {
        for (Button button : buttons) {
            if (button.overButton(mouseX, mouseY)) {
                button.overButton = true;
            } else {
                button.overButton = false;
            }
        }
    }

}