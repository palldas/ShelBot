package com.shelbot.blocks;

import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PShape;

/**
 * This class models a Block. It can be used in the ProgrammingWindow to have
 * drag and drop programming with Processing PApplet.
 * 
 * @author Pallavi Das
 * @version 5/17/20
 */
public abstract class Block {

    private boolean isFirstBlock, isLastBlock;
    private String text, params;
    private Color color;
    private float x, y;
    private BlockType blockType;
    private ParamType paramType;
    private SecondaryBlock secondary;
    private PShape block;
    private ArrayList<Block> babies;

    private ShadowBlock shadow;

    private boolean movedFirstTime = true;

    public static float blockWidth = 45;

    public static float daddyWidth = 100;

    /**
     * Creates a new instance of a Block object with a starting x and y coordinate, a
     * Color for the block (based on category), the text representing the block, the
     * input that will act as parameters for the block, whether the block is for
     * starting or ending, the type of block it is, the parameter type it will take
     * in, and the block's heirarchy.
     * 
     * @param x            main x-coordinate of the block
     * @param y            main y-coordinate of the block
     * @param color        the color the block will be filled with
     * @param text         states what the block does
     * @param params       the input given into the block from the user
     * @param isFirstBlock defines whether the block is the first block in script
     * @param isLastBlock  defines whether the block is the last block in script
     * @param blockType    the block type that will be drawn
     * @param paramType    the parameter type of the block
     * @param secondary    the hierarchy stance of the block (includes control
     *                     blocks)
     */
    public Block(float x, float y, Color color, String text, String params, boolean isFirstBlock, boolean isLastBlock,
            BlockType blockType, ParamType paramType, SecondaryBlock secondary) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.text = text;
        this.params = params;
        this.isFirstBlock = isFirstBlock;
        this.isLastBlock = isLastBlock;
        this.blockType = blockType;
        this.paramType = paramType;
        this.secondary = secondary;
    }

    /**
     * Draws a new instance of a Block object inside the BlocksWindow
     * 
     * @param applet the PApplet to be used to draw the block
     */
    public void draw(PApplet applet) {
        if (blockType.equals(BlockType.NORMAL)) {
            applet.pushStyle();
            applet.pushMatrix();
            applet.beginShape();
            applet.vertex(x, y);
            applet.vertex(x, y + 30);
            if (!isLastBlock) {
                applet.vertex(x + 15, y + 30);
                applet.vertex(x + 15, y + 40);
                applet.vertex(x + 30, y + 40);
                applet.vertex(x + 30, y + 30);
            }
            applet.vertex(x + 100, y + 30);
            applet.vertex(x + 100, y);
            if (!isFirstBlock) {
                applet.vertex(x + 30, y);
                applet.vertex(x + 30, y + 10);
                applet.vertex(x + 15, y + 10);
                applet.vertex(x + 15, y);
            }
            applet.fill(color.getRGB());
            applet.endShape(applet.CLOSE);
            if (paramType.equals(ParamType.STRING)) {
                applet.stroke(Color.black.getRGB());
                applet.fill(Color.white.getRGB());
                applet.ellipseMode(applet.CENTER);
                applet.ellipse(x + 70, y + 15, 30, 20);
                applet.textSize(8);
                applet.textAlign(applet.CENTER);
                applet.fill(Color.black.getRGB());
                if (params != null) {
                    applet.text(params, x + 70, y + 17);
                }
            }
            applet.textSize(10);
            applet.textAlign(applet.CORNER);
            applet.fill(Color.black.getRGB());
            applet.text(text, x + 8, y + 25);
            applet.popStyle();
            applet.popMatrix();
        }

        else if (blockType.equals(BlockType.OPERATOR)) {
            applet.pushStyle();
            applet.pushMatrix();
            applet.beginShape();
            applet.vertex(x, y + 15);
            applet.vertex(x + 15, y + 30);
            applet.vertex(x + 85, y + 30);
            applet.vertex(x + 100, y + 15);
            applet.vertex(x + 85, y);
            applet.vertex(x + 15, y);
            applet.fill(color.getRGB());
            applet.endShape(applet.CLOSE);
            if (paramType.equals(ParamType.STRING)) {
                applet.stroke(Color.black.getRGB());
                applet.fill(Color.white.getRGB());
                applet.ellipseMode(applet.CENTER);
                applet.ellipse(x + 70, y + 15, 30, 20);
                applet.textSize(8);
                applet.textAlign(applet.CENTER);
                applet.fill(Color.black.getRGB());
                if (params != null) {
                    applet.text(params, x + 70, y + 17);
                }
            }
            if (paramType.equals(ParamType.OPERATOR)) {
                applet.beginShape();
                applet.stroke(Color.black.getRGB());
                applet.fill(Color.white.getRGB());
                applet.vertex(x + 55, y + 15);
                applet.vertex(x + 65, y + 25);
                applet.vertex(x + 75, y + 25);
                applet.vertex(x + 85, y + 15);
                applet.vertex(x + 75, y + 5);
                applet.vertex(x + 65, y + 5);
                applet.endShape();
                applet.textSize(8);
                applet.textAlign(applet.CENTER);
                applet.fill(Color.black.getRGB());
                applet.text(params, x + 70, y + 17);

            }
            applet.textSize(10);
            applet.textAlign(applet.CORNER);
            applet.fill(Color.black.getRGB());
            applet.text(text, x + 17, y + 25);
            applet.popStyle();
            applet.popMatrix();
        }

        else if (blockType.equals(BlockType.DADDY)) {
            applet.pushStyle();
            applet.pushMatrix();
            applet.beginShape();
            applet.vertex(x, y);
            applet.vertex(x + 15, y);
            applet.vertex(x + 15, y + 10);
            applet.vertex(x + 30, y + 10);
            applet.vertex(x + 30, y);
            applet.vertex(x + 100, y);
            applet.vertex(x + 100, y + 30);
            applet.vertex(x + 30, y + 30);
            applet.vertex(x + 30, y + 40);
            applet.vertex(x + 15, y + 40);
            applet.vertex(x + 15, y + 30);
            applet.vertex(x + 5, y + 30);
            applet.vertex(x + 5, y + 60);
            applet.vertex(x + 15, y + 60);
            applet.vertex(x + 15, y + 70);
            applet.vertex(x + 30, y + 70);
            applet.vertex(x + 30, y + 60);
            applet.vertex(x + 100, y + 60);
            applet.vertex(x + 100, y + 90);
            applet.vertex(x + 30, y + 90);
            applet.vertex(x + 30, y + 100);
            applet.vertex(x + 15, y + 100);
            applet.vertex(x + 15, y + 90);
            applet.vertex(x, y + 90);
            applet.fill(color.getRGB());
            applet.endShape(applet.CLOSE);
            if (paramType.equals(ParamType.STRING)) {
                applet.stroke(Color.black.getRGB());
                applet.fill(Color.white.getRGB());
                applet.ellipseMode(applet.CENTER);
                applet.ellipse(x + 70, y + 15, 30, 20);
                applet.textSize(8);
                applet.textAlign(applet.CENTER);
                applet.fill(Color.black.getRGB());
                applet.text(params, x + 70, y + 17);
            }
            applet.textSize(10);
            applet.textAlign(applet.CORNER);
            applet.fill(Color.black.getRGB());
            applet.text(text, x + 17, y + 25);
            applet.popStyle();
            applet.popMatrix();
        }

    }

    /**
     * Runs the block based on its category/type
     */
    public abstract void run();

    /**
     * Calls the blocks parameters that will be used when running
     */
    public abstract void callParams();

    /**
     * Calculates the paramaters passed in by the user based on operation
     * 
     * @return the value calculated by the operation performed
     */
    public abstract double calc();

    /**
     * Calculates the boolean paramaters passed in by the user based on the boolean
     * operation
     * 
     * @return the value calculated by the boolean operators
     */
    public abstract boolean calcBoolean();

    /**
     * Defines the location of the block when near another block
     */
    public enum Location {
        /**
         * The block is above the other block
         */
        ABOVE,
        /**
         * The block is below the other block
         */
        BELOW,
        /**
         * The block is in between the block (used for control/daddy blocks)
         */
        BETWEEN
    };

    /**
     * Defines the type of block the block is
     */
    public enum BlockType {
        /**
         * This block is a normal type of block
         */
        NORMAL,
        /**
         * This block is an operator block
         */
        OPERATOR,
        /**
         * This block is a daddy block (a block that takes in another block)
         */
        DADDY
    }

    /**
     * Defines the type of paramater the block has
     */
    public enum ParamType {
        /**
         * This block takes in a operator block as a parameter
         */
        OPERATOR,
        /**
         * This block takes in a String/User input as the parameter
         */
        STRING,
        /**
         * This block has no parameters
         */
        NONE
    }

    /**
     * Defines the hierarchy status of th of paramater the block has
     */
    public enum SecondaryBlock {
        /**
         * This block is a normal block, also known as a baby block
         */
        BABY,
        /**
         * This block is a If block in Control
         */
        IF,
        /**
         * This block is a Repeat block in Control
         */
        REPEAT,
        /**
         * This block is a Forever block in Control
         */
        FOREVER
    }

    /**
     * Returns the main x-cooridnate
     * 
     * @return the main x-cooridnate of the block
     */
    public float getX() {
        return x;
    }

    /**
     * Returns the main y-cooridnate
     * 
     * @return the main y-cooridnate of the block
     */
    public float getY() {
        return y;
    }

    /**
     * Returns the block's type
     * 
     * @return the block type of the block
     */
    public BlockType getBlockType() {
        return blockType;
    }

    /**
     * Returns the parameter type
     * 
     * @return the type of parameter the block has
     */
    public ParamType getParamType() {
        return paramType;
    }

    /**
     * Returns the block's hierarchy status
     * 
     * @return the hierarchy status of the block
     */
    public SecondaryBlock getSecondaryBlock() {
        return secondary;
    }

    /**
     * Returns the parameters the block contains
     * 
     * @return the parameters of the block
     */
    public String getParams() {
        return params;
    }

    /**
     * Returns whether the block is considered a first block in the program
     * 
     * @return whether the block is a first block
     */
    public boolean getIsFirstBlock() {
        return isFirstBlock;
    }

    /**
     * Returns whether the block is considered a last block in the program
     * 
     * @return whether the block is a last block
     */
    public boolean getIsLastBlock() {
        return isLastBlock;
    }

    /**
     * Sets the main x-cooridnate to the new given x-coordinate
     * 
     * @param newX the new x-coordinate that will be replacing the current
     *             x-coordinate
     */
    public void setX(float newX) {
        this.x = newX;
    }

    /**
     * Sets the main y-cooridnate to the new given y-coordinate
     * 
     * @param newY the new y-coordinate that will be replacing the current
     *             y-coordinate
     */
    public void setY(float newY) {
        this.y = newY;
    }

    /**
     * Sets the parameter to the new parameter passed in
     * 
     * @param params the parameter that will be replacing the current parameter
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     * Determines if the point (x,y) is contained inside a Block object
     * 
     * @param mouseX the x-coordinate tested for being over the block
     * @param mouseY the y-coordinate tested for being over the block
     * @return whether or not the coordinate is inside the block
     */
    public boolean overBlock(float mouseX, float mouseY) {
        if (mouseX >= this.x && mouseX <= this.x + 100 && mouseY >= this.y && mouseY <= this.y + 30) {
            return true;
        }
        return false;
    }

    /**
     * Moves the block to the specified coordinates (x,y)
     * 
     * @param x the new x-coordinate the block will move to
     * @param y the new y-coordinate the block will move to
     */
    public void move(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Moves the block by the specified amount (x,y)
     * 
     * @param x the amount x to move by
     * @param y the amount y to move by
     */
    public void moveBy(float x, float y) {
        this.x += x;
        this.y += y;
    }

    /**
     * Determines if the point (x,y) is contained inside the Parameter circle
     * 
     * @param mouseX the x-coordinate tested for being over the parameter circle
     * @param mouseY the y-coordinate tested for being over the parameter circle
     * @return whether or not the coordinate is inside the parameter circle
     */
    public boolean overParam(float mouseX, float mouseY) {
        if (mouseX >= this.x + 60 && mouseX <= this.x + 80 && mouseY >= this.y + 10 && mouseY <= this.y + 20) {
            return true;
        }
        return false;
    }

    /**
     * Returns the text representing the blocks action
     * 
     * @return the text representing the block
     */
    public String getText() {
        return text;
    }

    /**
     * Returns the color of the block
     * 
     * @return the color representing the block
     */
    public Color getColor() {
        return color;
    }

    /**
     * Gets if the block is being moved for the first time
     * 
     * @return whether it's not the block's first time being moved and that it has
     *         moved before
     */
    public boolean isMovedBefore() {
        return !movedFirstTime;
    }

    /**
     * Used to set if the block if being moved for the first time
     * 
     * @param movedFirstTime states whether or not the block was moved for the first
     *                       time
     */
    public void setMovedFirst(boolean movedFirstTime) {
        this.movedFirstTime = movedFirstTime;
    }

    /**
     * Returns the block's shadow
     * 
     * @return the shadow block of the block
     */
    public ShadowBlock getShadow() {
        return shadow;
    }

    /**
     * Draws a new instance of a ShadowBlock object for a normal block based on its
     * location
     * 
     * @param applet     the PApplet to be used to draw the shadow
     * @param loc        where the shadow will be drawn
     * @param blockWidth the width of the block
     * @param blocktype  the type of block the block is
     */
    public void drawShadow(PApplet applet, Location loc, float blockWidth, BlockType blocktype) {
        float height;
        if (loc.equals((Location.ABOVE))) {
            height = getY() - 30;
        } else if (loc.equals(Location.BETWEEN)) {
            height = getY() + 30;
        } else {
            height = getY() + 90;
        }
        shadow = new ShadowBlock(getX(), height, blockWidth, BlockType.NORMAL);
        shadow.draw(applet);
    }

    /**
     * Draw's a new instance of a ShadowBlock for an operator block based on its
     * location
     * 
     * @param applet     the PApplet to be used to draw the shadow
     * @param blockWidth the width of the block
     */
    public void drawOperatorShadow(PApplet applet, float blockWidth) {
        shadow = new ShadowBlock(getX() + 0.25f * blockWidth, getY(), blockWidth, BlockType.DADDY);
        shadow.draw(applet);
    }

    /**
     * Returns the width of the block
     * 
     * @return the block's width
     */
    public float getWidth() {
        return 100f;
    }

    /**
     * Determines if the Block is an If Block
     * 
     * @return whether the block is an If Block or not
     */
    public boolean isIf() {
        if (secondary.equals(SecondaryBlock.IF)) {
            return true;
        }
        return false;
    }

    /**
     * Determines if the Block is a Repeat Block
     * 
     * @return whether the block is a Repeat Block or not
     */
    public boolean isRepeat() {
        if (secondary.equals(SecondaryBlock.REPEAT)) {
            return true;
        }
        return false;
    }

    /**
     * Determines if the Block is a Forever Block
     * 
     * @return whether the block is a Forever Block or not
     */
    public boolean isForever() {
        if (secondary.equals(SecondaryBlock.FOREVER)) {
            return true;
        }
        return false;
    }

    // public ArrayList<Block> getBabies(ArrayList<Block> blocks) {
    // ArrayList<Block> babies = new ArrayList<Block>();
    // for (Block block : blocks) {
    // if (block.getBlockType().equals(BlockType.DADDY))
    // if (this.getX() + 5 <= block.getX() && this.getX() + 100 >= block.getX()
    // && this.getY() + 30 <= block.getY() && this.getY() + 60 >= block.getY()) {

    // babies.add(block);
    // }
    // }
    // return babies;
    // }

    /**
     * Returns the blocks inside the daddy block
     * 
     * @return the blocks that will be performed/ran inside the daddy block (the
     *         baby blocks inside the daddy block)
     */
    public abstract ArrayList<Block> getBabies();

    /**
     * This class models a ShadowBlock. It can be used in the ProgrammingWindow to
     * portray a shadow of a Block object using Processing PApplet.
     * 
     * @author Pallavi Das
     * @version 5/17/20
     */
    public class ShadowBlock {

        private float x, y, width;
        private BlockType blockType;

        /**
         * Creates a new instance of a ShadowBlock object with a starting x and y
         * coordinate, a the width of the block, and the type of block the shadow is
         * 
         * @param x the x of the block
         * @param y the y of the block
         * @param width     the width of the block
         * @param blockType the type of block the shadow will be representing
         */
        public ShadowBlock(float x, float y, float width, Block.BlockType blockType) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.blockType = blockType;
        }

        /**
         * Draw's a new instance of a ShadowBlock object, based on its block type
         * 
         * @param applet the PApplet to be used to draw the ShadowBlock object
         */
        public void draw(PApplet applet) {
            applet.pushStyle();
            applet.beginShape();
            applet.noStroke();

            if (blockType.equals(BlockType.NORMAL)) {
                applet.vertex(x, y);
                applet.vertex(x, y + 30);
                applet.vertex(x + 15, y + 30);
                applet.vertex(x + 15, y + 40);
                applet.vertex(x + 30, y + 40);
                applet.vertex(x + 30, y + 30);
                applet.vertex(x + 100, y + 30);
                applet.vertex(x + 100, y);
                applet.vertex(x + 30, y);
                applet.vertex(x + 30, y + 10);
                applet.vertex(x + 15, y + 10);
                applet.vertex(x + 15, y);
            } else if (blockType.equals(BlockType.DADDY)) {
                applet.vertex(x, y + 15);
                applet.vertex(x + 15, y + 30);
                applet.vertex(x + 85, y + 30);
                applet.vertex(x + 100, y + 15);
                applet.vertex(x + 85, y);
                applet.vertex(x + 15, y);
            }

            applet.fill(new Color(199, 199, 199).getRGB());
            applet.endShape(applet.CLOSE);
            applet.popStyle();
        }

        /**
         * Returns the main x-cooridnate
         * 
         * @return the main x-cooridnate of the shadowBlock
         */
        public float getX() {
            return x;
        }

        /**
         * Returns the main y-cooridnate
         * 
         * @return the main y-cooridnate of the shadowBlock
         */
        public float getY() {
            return y;
        }
    }

}
