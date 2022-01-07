package com.shelbot.blocks;

import java.awt.Color;
import java.util.ArrayList;

/**
 * This class models a Daddy (daddy block). It can be used in the
 * ProgrammingWindow to have drag and drop programming with Processing PApplet.
 * These type of blocks require a block within them in order to be perform its
 * operations.
 * 
 * @author Pallavi Das
 * @version 5/17/20
 */
public abstract class Daddy extends Block { // should i not make it abstract?

	ArrayList<Block> babies = new ArrayList<Block>();

	/**
	 * Creates a new instance of a Daddy object with a starting x and y coordinate, a
	 * Color for the block, the text representing the block, whether the block is
	 * for ending, the parameter type it will take in, and the block's heirarchy.
	 * 
	 * @param x           main x-coordinate of the block
	 * @param y           main y-coordinate of the block
	 * @param color       the color the block will be filled with
	 * @param text        states what the block does
	 * @param isLastBlock defines whether the block is the last block in script
	 * @param paramType   the parameter type of the block
	 * @param secondary   the hierarchy stance of the block (includes control
	 *                    blocks)
	 */
	public Daddy(float x, float y, Color color, String text, boolean isLastBlock, Block.ParamType paramType,
			SecondaryBlock secondary) {
		super(x, y, color, text, "", false, isLastBlock, Block.BlockType.DADDY, paramType, secondary);
	}

	// public enum DaddyType {
	// IF, REPEAT, FOREVER
	// }

	public abstract void run();

	public abstract void callParams();

	public abstract double calc();

	public abstract boolean calcBoolean();

	// public boolean isIf() {
	// if (daddyType.equals(DaddyType.IF)) {
	// return true;
	// }
	// return false;
	// }

	// public boolean isRepeat() {
	// if (daddyType.equals(DaddyType.REPEAT)) {
	// return true;
	// }
	// return false;
	// }

	// public boolean isForever() {
	// if (daddyType.equals(DaddyType.FOREVER)) {
	// return true;
	// }
	// return false;
	// }

	// public float getTopY() {
	// return getY() + 30; // prob change constants
	// }

	// public float getBottomY() {
	// return getY() + 60; // prob change constants
	// }

	// public float getLeftX() {
	// return getX() + 5; // prob change constants
	// }

	// public float getRightX() {
	// return getX() + 100; // prob change constants
	// }

	// public ArrayList<Block> getBabies(ArrayList<Block> blocks) {
	// for (Block block : blocks) {
	// if (this.getLeftX() <= block.getX() && this.getRightX() >= block.getX() &&
	// this.getTopY() <= block.getY()
	// && this.getBottomY() >= block.getY()) {

	// babies.add(block);
	// }
	// }
	// return babies;
	// }
}