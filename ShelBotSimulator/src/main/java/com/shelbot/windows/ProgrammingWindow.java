package com.shelbot.windows;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;

import com.shelbot.SimulatorWindow;
import com.shelbot.blocks.Block;
import com.shelbot.utils.Button;
import com.shelbot.utils.MathUtils;
import com.shelbot.utils.Popup;
import com.shelbot.utils.Section;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class models a Programming Window. In this window, the user can drag and
 * drop blocks, which will then be executed. It is constructed/drawn using
 * Processing PApplet.
 * 
 * @author  , Pallavi Das, 
 * @version 5/10/20
 */
public class ProgrammingWindow extends Section {

	private static ArrayList<Block> blocks = new ArrayList<Block>();

	private float x, width;

	private boolean holdingBlocks = false;
	private boolean removeBlock = false;

	private Block holdingBlock;

	private Block blockWithShadow;
	private Block blockCloseToBlock;
	private boolean displayShadow;

	private boolean displayOperatorShadow;
	private Block daddyWithShadow;
	private Block operatorOnShadow;

	private PImage trash;
	private Button clearAll = new Button();

	Minim minim;
	AudioPlayer player;

	public Popup popup = new Popup((int) (getX() + 0.08 * getWidth()),
			(int) (getY() + getHeight() - 0.3 * getHeight() - 0.08 * getHeight()), 0.5f * getWidth(),
			0.3f * getHeight());

	/**
	 * Creates a new instance of a ProgrammingWindow using the constructor from the
	 * Section class. The starting percent of the window is 22% and the ending
	 * percent of the window is 65%. The color of the window will be white.
	 */
	public ProgrammingWindow() {
		super(22, 65, Color.white);

	}

	/**
	 * Used to setup the programming window where the user programs ShelBot
	 * @param applet The PApplet object used to setup
	 */
	public void setup(PApplet applet) {
		minim = new Minim(applet);
		player = minim.loadFile("audio/simulator/snap.mp3");
		trash = applet.loadImage("src/main/resources/trash.png");
		popup.setup(applet);
		clearAll = new Button((int) (1.5*applet.width/20), (int) (3*applet.height/4.0), (float) (applet.width/9.0), (float) (applet.width/9.0), "Clear All");
	}

	/**
	 * Used to draw the programming window where the user programs ShelBot
	 * @param applet The PApplet object used to draw
	 */
	public void draw(PApplet applet) {
		super.draw(applet);
		// test.draw(applet);

		applet.image(trash, (float) (1.5*applet.width/20), (float) (3*applet.height/4.0), (float) (applet.width/9.0), (float) (applet.width/9.0));

		clearAll.setX((int) (1.5*applet.width/20));
		clearAll.setY((int) (3*applet.height/4.0));
		clearAll.setWidth((float) (applet.width/9.0));
		clearAll.setHeight((float) (applet.width/9.0));
		clearAll.setText("Clear All");

		if (!popup.isClosed()) {
			popup.updateAttr((int) (getX() + 0.01 * getWidth()),
					(int) (getY() + getHeight() - 0.4 * getHeight() - 0.1 * getHeight()), 0.7f * getWidth(),
					0.4f * getHeight());
			popup.draw(applet);
		}
		for (Block block : blocks) {
			block.draw(applet);
		}
		x = getX();
		width = getWidth();

		try {
			if (!isBlockNearAnotherBlock(blockCloseToBlock, blockWithShadow)) {
				displayShadow = false;
				blockWithShadow = null;
				blockCloseToBlock = null;
				displayOperatorShadow = false;
				daddyWithShadow = null;
				operatorOnShadow = null;
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}

		if (displayShadow) {
			Block.Location shadowLoc;
			if (blockWithShadow.getY() > blockCloseToBlock.getY()) {
				shadowLoc = Block.Location.ABOVE;
			} else if (blockWithShadow.getY() + 45 > blockCloseToBlock.getY()) {
				shadowLoc = Block.Location.BETWEEN;
			} else {
				shadowLoc = Block.Location.BELOW;

			}
			blockWithShadow.drawShadow(applet, shadowLoc, blockCloseToBlock.getWidth(),
					blockCloseToBlock.getBlockType());
		}
		if (displayOperatorShadow) {
			daddyWithShadow.drawOperatorShadow(applet, operatorOnShadow.getWidth());
		}
		organizeBlocks();
	}

	/**
	 * Used to organize the blocks in order so that the analyzer can run them in order
	 */
	public void organizeBlocks() {
		try {
			// System.out.println("STARTING: " + blocks.get(0).getText());
			// for (int i = 0; i < blocks.size(); i++) {
			// System.out.print(blocks.get(i).getText() + " ");
			// }
			Comparator<Block> c = (s1, s2) -> Float.compare(s1.getY(), s2.getY());
			blocks.sort(c);
			// System.out.println("ENDING: " + blocks.get(blocks.size()-1).getText());
		} catch (Exception e) {

		}

	}

	/**
	 * Used to get the blocks currently in the programming window
	 * @return list the list of blocks
	 */
	public static ArrayList<Block> getBlocks() {
		return blocks;
	}

	/**
	 * Used to add blocks to the blockList in programming window
	 * @param block the block to be added to the list
	 */
	public static void add(Block block) {
		blocks.add(block);
	}

	/**
	 * Deals with mouseDragged events
	 * @param x the x of the mouse
	 * @param y the y of the mouse
	 */
	public void mouseDragged(float x, float y) {
		try {
			for (Block block : blocks) {
				if (!holdingBlocks) {
					if (block.overBlock(x, y)) {
						holdingBlock = block;
						holdingBlocks = true;
					}
				}
			}
			if (!SimulatorWindow.blockBank.contains(x, y) || !holdingBlock.isMovedBefore()) {
				holdingBlock.move(x - 50, y - 15);
				for (Block block : blocks) {
					if (!holdingBlock.equals(block)) {
						if (isBlockNearAnotherBlock(holdingBlock, block)) {
							if (holdingBlock.getBlockType().equals(Block.BlockType.OPERATOR)
									&& block.getBlockType().equals(Block.BlockType.DADDY)) {
								displayOperatorShadow = true;
								daddyWithShadow = block;
								operatorOnShadow = holdingBlock;
							} else if (!(holdingBlock.getBlockType().equals(Block.BlockType.OPERATOR)
									&& block.getBlockType().equals(Block.BlockType.NORMAL))) {
								if (!(block.getBlockType().equals(Block.BlockType.OPERATOR)
										&& holdingBlock.getBlockType().equals(Block.BlockType.NORMAL))) {
									displayShadow = true;
									blockWithShadow = block;
									blockCloseToBlock = holdingBlock;
								}

							}

							// for(Block tempBlock : blocks){
							// if(tempBlock.getX() == (blockWithShadow.getShadow().getX()) &&
							// tempBlock.getY() == (blockWithShadow.getShadow().getY())){
							// tempBlock.moveBy(0, Block.blockWidth);
							// break;
							// }
							// } // CODE FOR ADDING BLOCKS TO IN THE MIDDLE. DOESNT WORK EXACTLY
						}
					}
				}
			} else {
				removeBlock = true;
				holdingBlock.move(x - 50, y - 15);
				// blocks.remove(holdingBlock);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deals with mouseReleased events
	 */
	public void mouseReleased() {
		try {
			holdingBlock.setMovedFirst(false);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		if (removeBlock) {
			blocks.remove(holdingBlock);
			removeBlock = false;
		}
		holdingBlocks = false;
		holdingBlock = null;

		if (displayShadow) {
			blockCloseToBlock.move(blockWithShadow.getShadow().getX(), blockWithShadow.getShadow().getY());
			playSnap();
		}

		if (displayOperatorShadow) {
			operatorOnShadow.move(daddyWithShadow.getShadow().getX(), daddyWithShadow.getShadow().getY());
			daddyWithShadow.setParams(operatorOnShadow.getParams());
			playSnap();
		}

		displayShadow = false;
		blockWithShadow = null;
		blockCloseToBlock = null;

		displayOperatorShadow = false;
		daddyWithShadow = null;
		operatorOnShadow = null;
	}

	/**
	 * Deals with mouseClicked events
	 * @param x the x of the mouse
	 * @param y the y of the mouse
	 */
	public void mouseClicked(float x, float y) {
		System.out.println("CLICKED");
		if (clearAll.overButton((int)x, (int)y))
			blocks = new ArrayList<Block>();

		try {
			for (Block block : blocks) {
				if (block.overParam(x, y)) {
					block.callParams();
					System.out.println(block.getText());
					System.out.println("CALLED");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!popup.isClosed()) {
			popup.mouseClicked((int) x, (int) y);
		}
	}

	/**
	 * Deals with mouseMoved  events
	 * @param mouseX the x of the mouse
	 * @param mouseY the y of the mouse
	 */
	public void mouseMoved(float mouseX, float mouseY) {
		if (clearAll.overButton((int) mouseX, (int) mouseY))
			clearAll.highlight(true);

		if (!popup.isClosed()) {
			popup.mouseMoved((int) mouseX, (int) mouseY);
		}
	}

	private boolean isBlockNearAnotherBlock(Block block1, Block block2) {
		if (MathUtils.calcDistance(block1.getX(), block1.getY(), block2.getX(), block2.getY()) < 0.08 * width) {
			return true;
		}
		if (block1.getBlockType().equals(Block.BlockType.DADDY)) {
			if (MathUtils.calcDistance(block1.getX(), block1.getY(), block2.getX(),
					block2.getY() + 60) < (0.08 * width)) {
				return true;
			}
		}
		return false;
	}

	private void playSnap() {
		player.rewind();
		player.play();
	}
}
