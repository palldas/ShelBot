package com.shelbot.windows;

import java.awt.Color;

import com.shelbot.blocks.BlocksDrawer;
import com.shelbot.blocks.Control;
import com.shelbot.blocks.Events;
import com.shelbot.blocks.Motion;
import com.shelbot.blocks.Operators;
import com.shelbot.blocks.SoundBlocks;
import com.shelbot.utils.Section;

import processing.core.PApplet;

/**
 * Used to draw the blocks. This is where the user gets the new blocks from
 * 
 * @author  
 * @version 5/13/20
 */
public class BlocksWindow extends Section {

    /**
     * The motion blocks
     */
    public static Motion motion = new Motion();

    /**
     * The control blocks
     */
    public static Control control = new Control();

    /**
     * The event blocks
     */
    public static Events events = new Events();

    /**
     * The operator blocks
     */
    public static Operators operators = new Operators();

    /**
     * The sound blocks
     */
    public static SoundBlocks sound = new SoundBlocks();

    private static BlocksDrawer currentView = motion;

    /**
     * Used to create the blocks window where the blocks are displayed
     */
    public BlocksWindow() {
        super(4, 22, Color.white);
        setView(motion);
    }

    /**
     * Used to draw the blocks window
     * 
     * @param applet The PApplet object used to draw
     */
    public void draw(PApplet applet) {
        super.draw(applet);

        currentView.draw(applet, getX());
    }

    /**
     * Deals with mouseDragged events
     * 
     * @param x the x of mouse
     * @param y the y of mouse
     */
    public void mouseDragged(float x, float y) {
        motion.mouseDragged(x, y);
        control.mouseDragged(x, y);
        events.mouseDragged(x, y);
        operators.mouseDragged(x, y);
        sound.mouseDragged(x, y);
    }

    /**
     * Deals with mouseReleased events
     */
    public void mouseReleased() {
        motion.mouseReleased();
        control.mouseReleased();
        events.mouseReleased();
        sound.mouseReleased();
        operators.mouseReleased();

    }

    /**
     * Used to set the view of the blocks window
     * 
     * @param blockCategory the type of blocks to draw
     */
    public void setView(BlocksDrawer blockCategory) {
        this.currentView = blockCategory;
    }

    /**
     * Used to get the current view of the BlocksWindow
     * 
     * @return blockDrawer the current type of blocks being displayed
     */
    public static BlocksDrawer getView() {
        return currentView;
    }
}
