package com.shelbot.blocks;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.shelbot.windows.BlocksCategoryWindow;

/**
 * This class models the blocks in a Control window. It contains each block in
 * the category and the execution method of each block.
 * 
 * @author Pallavi Das
 * @version 5/17/20
 */
public class Control extends BlocksDrawer {

	private static final Color COLOR = new Color(255, 171, 26);

	/**
	 * The wait block makes the sprite wait based on the seconds input from user
	 */
	protected Block wait = new Block(BlocksDrawer.leftMargin, 75, BlocksCategoryWindow.controlColor, "Wait", "", false,
			false, Block.BlockType.NORMAL, Block.ParamType.STRING, Block.SecondaryBlock.BABY) {
		long secs;

		public void run() {
			try {
				Thread.sleep(secs * 1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void callParams() {
			try {
				secs = Long.parseLong(JOptionPane.showInputDialog("How many seconds would you like to wait?"));
				wait.setParams(secs + "");
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

		public ArrayList<Block> getBabies() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	/**
	 * The repeat block repeats the action(s) based on the number of times the user
	 * inputs
	 */
	protected Daddy repeat = new Daddy(BlocksDrawer.leftMargin, 150, BlocksCategoryWindow.controlColor, "Repeat", false,
			Block.ParamType.STRING, Block.SecondaryBlock.REPEAT) {
		int times;

		public void run() {
			// TODO figure how to take in block
		}

		public void callParams() {
			try {
				times = Integer.parseInt(JOptionPane.showInputDialog("How many times would you like to repeat?"));
				repeat.setParams(times + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			// nope
			return 0;
		}

		@Override
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
	 * The forever block repeats the action(s) for an indefinite amount of time,
	 * will stop once the stop button is pressed/the program terminates
	 */
	protected Daddy forever = new Daddy(BlocksDrawer.leftMargin, 285, BlocksCategoryWindow.controlColor, "Forever",
			true, Block.ParamType.NONE, Block.SecondaryBlock.FOREVER) {
		public void run() {
			// TODO figure how to take in block
		}

		public void callParams() {
			// none
			// TODO see if it can take in multiple blocks
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
	 * The ifElse block runs the action(s) if the condition is met, else runs the
	 * alternate action
	 */
	protected Daddy ifBlock = new Daddy(BlocksDrawer.leftMargin, 420, BlocksCategoryWindow.controlColor, "If", false,
			Block.ParamType.STRING, Block.SecondaryBlock.IF) {
		boolean val1;

		public void run() {
			// TODO figure how to take in block
			if (getParams() != null) {
				boolean condition = Boolean.parseBoolean(getParams());
				if (condition) {

				}
			}
		}

		public void callParams() {
			try {
				val1 = Boolean.parseBoolean(JOptionPane.showInputDialog("What's the boolean value?"));
				setParams(val1 + "");
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

	protected static ArrayList<Block> blocks = new ArrayList<Block>();

	/**
	 * Creates a new instance of the Control object, adding each of the blocks to an
	 * ArrayList to be drawn
	 */
	public Control() {
		super("Control", blocks, BlocksCategoryWindow.controlColor);
		blocks.add(wait);
		blocks.add(repeat);
		blocks.add(forever);
		blocks.add(ifBlock);
	}

	/**
	 * Returns all the blocks from the Control category
	 * 
	 * @return the blocks from the Control ArrayList
	 */
	@Override
	public ArrayList<Block> getBlocks() {
		return blocks;
	}

}
