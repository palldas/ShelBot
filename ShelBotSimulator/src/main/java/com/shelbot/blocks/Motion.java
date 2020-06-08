package com.shelbot.blocks;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.shelbot.SimulatorWindow;
import com.shelbot.windows.BlocksCategoryWindow;

/**
 * This class models the blocks in a Motion window. It contains each block in
 * the category and the execution method of each block.
 * 
 * @author Pallavi Das
 * @version 5/17/20
 */
public class Motion extends BlocksDrawer {

	private static final Color COLOR = new Color(93, 188, 210);

	/**
	 * The move block moves the sprite an x number of steps, based on the steps
	 * input from user
	 */
	protected Block move = new Block(BlocksDrawer.leftMargin, 75, BlocksCategoryWindow.motionColor, "Move", "", false,
			false, Block.BlockType.NORMAL, Block.ParamType.STRING, Block.SecondaryBlock.BABY) {
		float steps;

		public void run() {
			SimulatorWindow.spriteWindow.getSprite().moveBy(5 * steps, 0);
		}

		public void callParams() {
			try {
				steps = Float.parseFloat(JOptionPane.showInputDialog("How many steps would you like to move?"));
				move.setParams(steps + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			return 0;
			// nope
		}

		public boolean calcBoolean() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ArrayList<Block> getBabies() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	/**
	 * The turn block turns the sprite the given degrees clockwise, based on the
	 * degree input from user
	 */
	protected Block turn = new Block(BlocksDrawer.leftMargin, 150, BlocksCategoryWindow.motionColor, "Turn", "", false,
			false, Block.BlockType.NORMAL, Block.ParamType.STRING, Block.SecondaryBlock.BABY) {
		float degrees;

		public void run() {
			SimulatorWindow.spriteWindow.getSprite().rotate(degrees);
		}

		public void callParams() {
			try {
				degrees = Float.parseFloat(JOptionPane.showInputDialog("What degree would you like to turn/point to?"));
				turn.setParams(degrees + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			// nope
			return 0;
		}

		public boolean calcBoolean() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ArrayList<Block> getBabies() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	/**
	 * The goTo block makes the sprite goes to the given coordinates (x,y), based on
	 * the coordinate input from user
	 */
	protected Block goTo = new Block(BlocksDrawer.leftMargin, 225, BlocksCategoryWindow.motionColor, "Go To", "", false,
			false, Block.BlockType.NORMAL, Block.ParamType.STRING, Block.SecondaryBlock.BABY) {
		float newX, newY;

		public void run() {
			SimulatorWindow.spriteWindow.getSprite().moveTo(newX, newY);
		}

		public void callParams() {
			try {
				newX = Float.parseFloat(JOptionPane.showInputDialog("What x-coordinate would you like to go to?"));
				newY = Float.parseFloat(JOptionPane.showInputDialog("What y-coordinate would you like to go to?"));
				goTo.setParams("(" + newX + ", " + newY + ")");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			// nope
			return 0;
		}

		public boolean calcBoolean() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ArrayList<Block> getBabies() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	// /**
	// * The point block points the sprite in the given direction, based on the
	// * degrees inputed by the user
	// */
	// protected Block point = new Block(BlocksDrawer.leftMargin, 300,
	// BlocksCategoryWindow.motionColor, "Point", "",
	// false, false, false, true) {
	// public void run() {

	// }

	// public void callParams() {

	// }

	// public void calc() {

	// }
	// };

	/**
	 * The setXto block sets the x-coordinate of the sprite to the inputed
	 * x-coordinate given from user
	 */
	protected Block setXto = new Block(BlocksDrawer.leftMargin, 375, BlocksCategoryWindow.motionColor, "Set X To", "",
			false, false, Block.BlockType.NORMAL, Block.ParamType.STRING, Block.SecondaryBlock.BABY) {
		float newX;

		public void run() {
			SimulatorWindow.spriteWindow.getSprite().moveX(newX);
		}

		public void callParams() {
			try {
				newX = Float.parseFloat(JOptionPane.showInputDialog("What do you want to setas the x-coordinate?"));
				setXto.setParams(newX + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			// nope
			return 0;
		}

		public boolean calcBoolean() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ArrayList<Block> getBabies() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	/**
	 * The setYto block sets the y-coordinate of the sprite to the inputed
	 * y-coordinate given from user
	 */
	protected Block setYto = new Block(BlocksDrawer.leftMargin, 450, BlocksCategoryWindow.motionColor, "Set Y To", "",
			false, false, Block.BlockType.NORMAL, Block.ParamType.STRING, Block.SecondaryBlock.BABY) {
		float newY;

		public void run() {
			SimulatorWindow.spriteWindow.getSprite().moveY(newY);
		}

		public void callParams() {
			try {
				newY = Float.parseFloat(JOptionPane.showInputDialog("What do you want to setas the y-coordinate?"));
				setYto.setParams(newY + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			// nope
			return 0;
		}

		public boolean calcBoolean() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ArrayList<Block> getBabies() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	protected static ArrayList<Block> blocks = new ArrayList<Block>();

	/**
	 * Creates a new instance of the Motion object, adding each of the blocks to an
	 * ArrayList to be drawn
	 */
	public Motion() {
		super("Motion", blocks, BlocksCategoryWindow.motionColor);
		blocks.add(move);
		blocks.add(turn);
		blocks.add(goTo);
		// blocks.add(point);
		blocks.add(setXto);
		blocks.add(setYto);
	}

	/**
	 * Returns all the blocks from the Motion category
	 * 
	 * @return the blocks from the Motion ArrayList
	 */
	@Override
	public ArrayList<Block> getBlocks() {
		return blocks;
	}

}
