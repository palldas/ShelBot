package com.shelbot.blocks;

import java.awt.Color;
import java.util.ArrayList;

import com.shelbot.windows.BlocksCategoryWindow;

/**
 * This class models the blocks in a Events window. It contains each block in
 * the category and the execution method of each block.
 * 
 * @author Pallavi Das
 * @version 5/17/20
 */
public class Events extends BlocksDrawer {

    private static final Color COLOR = new Color(255, 213, 0);

    /**
     * The whenStart block is the first block in the program that will execute the
     * following actions when the start button is pressed/activated
     */
    protected Block whenStart = new Block(BlocksDrawer.leftMargin, 75, BlocksCategoryWindow.eventsColor,
            "When Flag Clicked", "", true, false, Block.BlockType.NORMAL, Block.ParamType.NONE,
            Block.SecondaryBlock.BABY) {
        public void run() {
        }

        public void callParams() {
            // none
        }

        public double calc() {
            // nope
            return 0;
        }

        public boolean calcBoolean() {
            // TODO Auto-generated method stub
            return false;
        }

        public ArrayList<Block> getBabies() {
            // TODO Auto-generated method stub
            return null;
        }
    };

    // /**
    // * The whenKeyClicked block is the first block in the program that will
    // execute
    // * the following actions when the inputed key from the user is
    // pressed/activated
    // */
    // protected Block whenKeyClicked = new Block(BlocksDrawer.leftMargin, 150,
    // BlocksCategoryWindow.eventsColor,
    // "When Key Clicked", "", true, false, false, true) {
    // String key;
    // PApplet applet;

    // public void run() {
    // // TODO use keyPressed and set keyCode to key
    // }

    // public void callParams() {
    // key = JOptionPane
    // .showInputDialog("What key should be clicked (must be lexicographic; no
    // space, up, down, etc");
    // whenKeyClicked.setParams(key);
    // }

    // public void calc() {
    // // nope
    // }
    // };

    // /**
    // * The whenClicked block is the first block in the program that will execute
    // the
    // * following actions when the sprite is clicked on
    // */
    // protected Block whenClicked = new Block(BlocksDrawer.leftMargin, 225,
    // BlocksCategoryWindow.eventsColor,
    // "When Clicked", "String", true, false, false, false) {
    // public void run() {
    // // TODO figure how to take in block
    // }

    // public void callParams() {
    // // none
    // // TODO see if it can take in multiple blocks
    // }

    // public void calc() {
    // // nope
    // }
    // };

    protected static ArrayList<Block> blocks = new ArrayList<Block>();

    /**
     * Creates a new instance of the Events object, adding each of the blocks to an
     * ArrayList to be drawn
     */
    public Events() {
        super("Events", blocks, BlocksCategoryWindow.eventsColor);
        blocks.add(whenStart);
        // blocks.add(whenKeyClicked);
        // blocks.add(whenClicked);
    }

    /**
     * Returns all the blocks from the Events category
     * 
     * @return the blocks from the Events ArrayList
     */
    public ArrayList<Block> getBlocks() {
        return blocks;
    }

}
