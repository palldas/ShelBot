package com.shelbot.windows;

import java.awt.Color;

import com.shelbot.SimulatorWindow;
import com.shelbot.utils.Button;
import com.shelbot.utils.Section;

import processing.core.PApplet;

/**
 * Represents the blocks category window on the left most corner. Used to switch view of the Block Drawer
 * @author  
 * @version 5/12/20
 */
public class BlocksCategoryWindow extends Section {

    private Button motion;
    private Button control;
    private Button events;
    private Button operators;
    private Button sound;

    private boolean motionPressed = true;
    private boolean controlPressed;
    private boolean eventsPressed;
    private boolean soundPressed;
    private boolean operatorPressed;

    public static Color motionColor = new Color(93, 188, 210);
    public static Color controlColor = new Color(255, 171, 26);
    public static Color eventsColor = new Color(255, 213, 0);
    public static Color operatorsColor = new Color(65, 191, 73);
    public static Color soundColor = new Color(214, 92, 214);

    /**
     * Used to create a BlocksCategoryWindow
     */
    public BlocksCategoryWindow() {
        super(0, 4, Color.WHITE);
    }

    /**
     * Used to draw the BlocksCategoryWindow
     * @param applet the PApplet object used to draw
     */
    public void draw(PApplet applet) {
        motion = new Button(0, (int) zero, getWidth(), getWidth(), "Motion", true, motionColor);
        control = new Button(0, (int) getWidth() + zero, getWidth(), getWidth(), "Control", true, controlColor);
        events = new Button(0, (int) getWidth() * 2 + zero, getWidth(), getWidth(), "Events", true, eventsColor);
        operators = new Button(0, (int) getWidth() * 3 + zero, getWidth(), getWidth(), "Operators", true,
                operatorsColor);
        sound = new Button(0, (int) getWidth() * 4 + zero, getWidth(), getWidth(), "Sound", true, soundColor);

        if (motionPressed) {
            motion.highlight(true);
            SimulatorWindow.blockBank.setView(BlocksWindow.motion);
        } else if (controlPressed) {
            control.highlight(true);
            SimulatorWindow.blockBank.setView(BlocksWindow.control);
        } else if (eventsPressed) {
            events.highlight(true);
            SimulatorWindow.blockBank.setView(BlocksWindow.events);
        } else if (operatorPressed) {
            operators.highlight(true);
            SimulatorWindow.blockBank.setView(BlocksWindow.operators);
        } else if (soundPressed) {
            sound.highlight(true);
            SimulatorWindow.blockBank.setView(BlocksWindow.sound);
        }

        super.draw(applet);
        motion.draw(applet);
        control.draw(applet);
        events.draw(applet);
        operators.draw(applet);
        sound.draw(applet);

    }

    /**
     * Deals with mousePressed events 
     * @param mouseX the x of the mouse
     * @param mouseY the y of the mouse
     */
    public void mousePressed(int mouseX, int mouseY) {
        // System.out.println("Pressed");
        if (motion.overButton(mouseX, mouseY)) {
            motionPressed = true;
            eventsPressed = false;
            controlPressed = false;
            operatorPressed = false;
            soundPressed = false;
            // System.out.println("motion");
        } else if (sound.overButton(mouseX, mouseY)) {
            motionPressed = false;
            eventsPressed = false;
            controlPressed = false;
            operatorPressed = false;
            soundPressed = true;
            // System.out.println("sound");
        } else if (control.overButton(mouseX, mouseY)) {
            motionPressed = false;
            eventsPressed = false;
            controlPressed = true;
            operatorPressed = false;
            soundPressed = false;
            // System.out.println("control");
        } else if (events.overButton(mouseX, mouseY)) {
            motionPressed = false;
            eventsPressed = true;
            controlPressed = false;
            operatorPressed = false;
            soundPressed = false;
            // System.out.println("events");
        } else if (operators.overButton(mouseX, mouseY)) {
            motionPressed = false;
            eventsPressed = false;
            controlPressed = false;
            operatorPressed = true;
            soundPressed = false;
            // System.out.println("operators");
        }
    }

    /**
     * Deals with the mouseReleased events
     */
    public void mouseReleased() {
        // motion.highlight(false);
        // events.highlight(false);
        // control.highlight(false);
        // operators.highlight(false);
        // sound.highlight(false);

    }

}