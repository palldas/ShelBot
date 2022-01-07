package com.shelbot.blocks;

import java.awt.Color;
import java.util.ArrayList;

import com.shelbot.blocks.Block.BlockType;
import com.shelbot.utils.Section;
import com.shelbot.windows.BlocksWindow;
import com.shelbot.windows.ProgrammingWindow;

import processing.core.PApplet;

/**
 * This class models a BlocksDrawer. It will draw all the blocks in a certain
 * category using Processing PApplet.
 * 
 * @author   and Pallavi Das
 * @version 5/17/20
 */
public abstract class BlocksDrawer {

    String categoryName;
    ArrayList<Block> blocks;

    Color categoryColor;

    private Block newBlock = null;

    int newBlocksMade = 0;

    public static float leftMargin;
    public static float topMargin;
    public static float firstBlockMargin;

    /**
     * Creates a new instance of a BlocksDrawer object with the category's name, the
     * blocks that will be drawn, and the color of the category
     * 
     * @param categoryName  the name of the cateogry
     * @param blocks        the ArrayList of blocks from the category that will be
     *                      drawn
     * @param categoryColor the color the blocks in the category will be drawn with
     */
    public BlocksDrawer(String categoryName, ArrayList<Block> blocks, Color categoryColor) {
        this.categoryName = categoryName;
        this.blocks = blocks;
        this.categoryColor = categoryColor;
    }

    /**
     * Draws a new instance of a BlocksDrawer object. Will draw all the blocks from
     * the blocks ArrayList
     * 
     * @param applet the PApplet to be used to draw the button
     * @param x      the x-coordinate for section's starting point
     */
    public void draw(PApplet applet, float x) {
        applet.pushStyle();
        applet.fill(Color.black.getRGB());
        leftMargin = x + (0.006f * applet.width);
        topMargin = 0.025f * applet.height;
        float textHeight = 0.015f * applet.height;
        firstBlockMargin = topMargin + textHeight + Section.zero;
        applet.textSize(textHeight);
        applet.text(categoryName, leftMargin, topMargin + Section.zero);
        applet.fill(categoryColor.getRGB());
        drawBlocks(applet);
        applet.popStyle();
    }

    /**
     * Returns all the blocks from the category
     * 
     * @return the blocks from the category's ArrayList
     */
    public abstract ArrayList<Block> getBlocks();

    public void drawBlocks(PApplet applet) {
        float blockY = firstBlockMargin;
        for (Block block : getBlocks()) {
            block.setX(leftMargin);
            block.setY(blockY);
            block.draw(applet);
            if (block.getBlockType().equals(BlockType.DADDY))
                blockY += Block.daddyWidth + topMargin;
            else
                blockY += Block.blockWidth + topMargin;
        }
    }

    /**
     * The actions that will be performed when the mouse / (x,y) coordinate has been
     * dragged
     * 
     * @param x the x-coordinate of the mouse dragging movement
     * @param y the y-coordinate of the mouse
     */
    public void mouseDragged(float x, float y) {
        try {
            for (Block block : getBlocks()) {
                if (BlocksWindow.getView() == BlocksWindow.motion) {
                    if (this instanceof Motion) {
                        if (block.overBlock(x, y)) {
                            if (newBlock == null && newBlocksMade == 0) {
                                Block newBlock = new Block(x, y, block.getColor(), block.getText(), block.getParams(),
                                        block.getIsFirstBlock(), block.getIsLastBlock(), block.getBlockType(),
                                        block.getParamType(), block.getSecondaryBlock()) {
                                    public void run() {
                                        block.run();
                                    }

                                    public void callParams() {
                                        block.callParams();
                                        setParams(block.getParams());
                                    }

                                    public double calc() {
                                        return block.calc();
                                    }

                                    @Override
                                    public boolean calcBoolean() {
                                        // TODO Auto-generated method stub
                                        return block.calcBoolean();
                                    }

                                    @Override
                                    public ArrayList<Block> getBabies() {
                                        // TODO Auto-generated method stub
                                        return block.getBabies();
                                    }
                                };
                                ProgrammingWindow.add(newBlock);
                                newBlocksMade++;
                            }
                        }
                    }
                }
                if (BlocksWindow.getView() == BlocksWindow.control) {
                    if (this instanceof Control) {
                        if (block.overBlock(x, y)) {
                            if (newBlock == null && newBlocksMade == 0) {
                                Block newBlock = new Block(x, y, block.getColor(), block.getText(), block.getParams(),
                                        block.getIsFirstBlock(), block.getIsLastBlock(), block.getBlockType(),
                                        block.getParamType(), block.getSecondaryBlock()) {
                                    public void run() {
                                        block.run();
                                    }

                                    public void callParams() {
                                        block.callParams();
                                        setParams(block.getParams());
                                    }

                                    public double calc() {
                                        return block.calc();
                                    }

                                    @Override
                                    public boolean calcBoolean() {
                                        // TODO Auto-generated method stub
                                        return block.calcBoolean();
                                    }

                                    @Override
                                    public ArrayList<Block> getBabies() {
                                        // TODO Auto-generated method stub
                                        return block.getBabies();
                                    }
                                };
                                ProgrammingWindow.add(newBlock);
                                newBlocksMade++;
                            }
                        }
                    }
                }
                if (BlocksWindow.getView() == BlocksWindow.events) {
                    if (this instanceof Events) {
                        if (block.overBlock(x, y)) {
                            if (newBlock == null && newBlocksMade == 0) {
                                Block newBlock = new Block(x, y, block.getColor(), block.getText(), block.getParams(),
                                        block.getIsFirstBlock(), block.getIsLastBlock(), block.getBlockType(),
                                        block.getParamType(), block.getSecondaryBlock()) {
                                    public void run() {
                                        block.run();
                                    }

                                    public void callParams() {
                                        block.callParams();
                                        setParams(block.getParams());
                                    }

                                    public double calc() {
                                        return block.calc();
                                    }

                                    @Override
                                    public boolean calcBoolean() {
                                        // TODO Auto-generated method stub
                                        return block.calcBoolean();
                                    }

                                    @Override
                                    public ArrayList<Block> getBabies() {
                                        // TODO Auto-generated method stub
                                        return block.getBabies();
                                    }
                                };
                                ProgrammingWindow.add(newBlock);
                                newBlocksMade++;
                            }
                        }
                    }
                }
                if (BlocksWindow.getView() == BlocksWindow.operators) {
                    if (this instanceof Operators) {
                        if (block.overBlock(x, y)) {
                            if (newBlock == null && newBlocksMade == 0) {
                                Block newBlock = new Block(x, y, block.getColor(), block.getText(), block.getParams(),
                                        block.getIsFirstBlock(), block.getIsLastBlock(), block.getBlockType(),
                                        block.getParamType(), block.getSecondaryBlock()) {
                                    public void run() {
                                        block.run();
                                    }

                                    public void callParams() {
                                        block.callParams();
                                        setParams(block.getParams());
                                    }

                                    public double calc() {
                                        return block.calc();
                                    }

                                    @Override
                                    public boolean calcBoolean() {
                                        // TODO Auto-generated method stub
                                        return block.calcBoolean();
                                    }

                                    @Override
                                    public ArrayList<Block> getBabies() {
                                        // TODO Auto-generated method stub
                                        return block.getBabies();
                                    }
                                };
                                ProgrammingWindow.add(newBlock);
                                newBlocksMade++;
                            }
                        }
                    }
                }
                if (BlocksWindow.getView() == BlocksWindow.sound) {
                    if (this instanceof SoundBlocks) {
                        if (block.overBlock(x, y)) {
                            if (newBlock == null && newBlocksMade == 0) {
                                Block newBlock = new Block(x, y, block.getColor(), block.getText(), block.getParams(),
                                        block.getIsFirstBlock(), block.getIsLastBlock(), block.getBlockType(),
                                        block.getParamType(), block.getSecondaryBlock()) {
                                    public void run() {
                                        block.run();
                                    }

                                    public void callParams() {
                                        block.callParams();
                                        setParams(block.getParams());
                                    }

                                    public double calc() {
                                        return block.calc();
                                    }

                                    @Override
                                    public boolean calcBoolean() {
                                        // TODO Auto-generated method stub
                                        return block.calcBoolean();
                                    }

                                    @Override
                                    public ArrayList<Block> getBabies() {
                                        // TODO Auto-generated method stub
                                        return block.getBabies();
                                    }
                                };
                                ProgrammingWindow.add(newBlock);
                                newBlocksMade++;
                            }
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * The actions that will be performed when the mouse has been released
     */
    public void mouseReleased() {
        try {
            newBlock.setMovedFirst(false);
        } catch (Exception e) {
            // e.printStackTrace();
        }
        newBlock = null;
        newBlocksMade = 0;
    }
}
