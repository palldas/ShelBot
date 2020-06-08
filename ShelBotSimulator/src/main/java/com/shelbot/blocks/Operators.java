package com.shelbot.blocks;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.shelbot.windows.BlocksCategoryWindow;

/**
 * This class models the blocks in an Operators window. It contains each block
 * in the category and the execution method of each block.
 * 
 * @author Pallavi Das
 * @version 5/17/20
 */
public class Operators extends BlocksDrawer {

	private static final Color COLOR = new Color(65, 191, 73);

	/**
	 * The add block adds the 2 integer inputed from the user, returning an integer
	 */
	protected Block add = new Block(BlocksDrawer.leftMargin, 75, BlocksCategoryWindow.operatorsColor, "Add", "", false,
			false, Block.BlockType.OPERATOR, Block.ParamType.STRING, Block.SecondaryBlock.BABY) {
		double num1, num2;

		public void run() {
			// nope
		}

		public void callParams() {
			try {
				num1 = Double.parseDouble(JOptionPane.showInputDialog("What's the first number to be added?"));
				num2 = Double.parseDouble(JOptionPane.showInputDialog("What's the second number to be added?"));
				calc();
				add.setParams(num1 + num2 + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			return num1 + num2;

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
	 * The subtract block subtracts the 2 integer inputed from the user, returning
	 * an integer
	 */
	protected Block subtract = new Block(BlocksDrawer.leftMargin, 150, BlocksCategoryWindow.operatorsColor, "Subtract",
			"", false, false, Block.BlockType.OPERATOR, Block.ParamType.STRING, Block.SecondaryBlock.BABY) {
		double num1, num2;

		public void run() {
			// nope
		}

		public void callParams() {
			try {
				num1 = Double.parseDouble(JOptionPane.showInputDialog("What's the first number?"));
				num2 = Double.parseDouble(JOptionPane.showInputDialog("What's the second number to be subtracted?"));
				calc();
				subtract.setParams(num1 - num2 + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			return num1 - num2;
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
	 * The multiply block multiplies the 2 integer inputed from the user, returning
	 * an integer
	 */
	protected Block multiply = new Block(BlocksDrawer.leftMargin, 225, BlocksCategoryWindow.operatorsColor, "Multiply",
			"", false, false, Block.BlockType.OPERATOR, Block.ParamType.STRING, Block.SecondaryBlock.BABY) {
		double num1, num2;

		public void run() {
			// nope
		}

		public void callParams() {
			try {
				num1 = Double.parseDouble(JOptionPane.showInputDialog("What's the first number to be multiplied?"));
				num2 = Double.parseDouble(JOptionPane.showInputDialog("What's the second number to be multiplied?"));
				calc();
				multiply.setParams(num1 * num2 + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			return num1 * num2;
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
	 * The divde block divides the 2 integer inputed from the user, returning an
	 * integer
	 */
	protected Block divide = new Block(BlocksDrawer.leftMargin, 300, BlocksCategoryWindow.operatorsColor, "Divide", "",
			false, false, Block.BlockType.OPERATOR, Block.ParamType.STRING, Block.SecondaryBlock.BABY) {
		double num1, num2;

		public void run() {
			// nope
		}

		public void callParams() {
			try {
				num1 = Double.parseDouble(JOptionPane.showInputDialog("What's the dividend?"));
				num2 = Double.parseDouble(JOptionPane.showInputDialog("What's the divisor?"));
				calc();
				divide.setParams(num1 / num2 + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			return num1 / num2;
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
	 * The greaterThan block determines if one parameter is greater than the other,
	 * which are both inputed by the user, returning a boolean
	 */
	protected Block greaterThan = new Block(BlocksDrawer.leftMargin, 375, BlocksCategoryWindow.operatorsColor,
			"Greater Than", "", false, false, Block.BlockType.OPERATOR, Block.ParamType.STRING,
			Block.SecondaryBlock.BABY) {
		double num1, num2;

		public void run() {
			// nope
		}

		public void callParams() {
			try {
				num1 = Double.parseDouble(JOptionPane.showInputDialog(
						"What's the 1st number that will be checked if it's greater than the 2nd number?"));
				num2 = Double.parseDouble(JOptionPane
						.showInputDialog("What's 2nd number that will be checked if it's less than the 1st number?"));
				setParams((num1 > num2) + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			return 0;
		}

		public boolean calcBoolean() {
			return num1 > num2;
		}

		@Override
		public ArrayList<Block> getBabies() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	/**
	 * The lessThan block determines if one parameter is less than the other, which
	 * are both inputed by the user, returning a boolean
	 */
	protected Block lessThan = new Block(BlocksDrawer.leftMargin, 450, BlocksCategoryWindow.operatorsColor,
			"Less Than", "", false, false, Block.BlockType.OPERATOR, Block.ParamType.STRING,
			Block.SecondaryBlock.BABY) {
		double num1, num2;

		public void run() {
			// nope
		}

		public void callParams() {
			try {
				num1 = Double.parseDouble(JOptionPane.showInputDialog(
						"What's the 1st number that will be checked if it's less than the 2nd number?"));
				num2 = Double.parseDouble(JOptionPane.showInputDialog(
						"What's 2nd number that will be checked if it's greater than the 1st number?"));
				setParams((num1 < num2) + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			return 0;
		}

		public boolean calcBoolean() {
			return num1 < num2;
		}

		@Override
		public ArrayList<Block> getBabies() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	/**
	 * The equalTo block determines if one parameter is equal to the other, which
	 * are both inputed by the user, returning a boolean
	 */
	protected Block equalTo = new Block(BlocksDrawer.leftMargin, 525, BlocksCategoryWindow.operatorsColor, "Equal To",
			"", false, false, Block.BlockType.OPERATOR, Block.ParamType.STRING, Block.SecondaryBlock.BABY) {
		double num1, num2;

		public void run() {
			// nope
		}

		public void callParams() {
			try {
				num1 = Double.parseDouble(JOptionPane.showInputDialog(
						"What's the 1st number that will be checked if it's equal to the 2nd number?"));
				num2 = Double.parseDouble(JOptionPane.showInputDialog(
						"What's the 2nd number that will be checked if it's equal to the 1st number?"));
				setParams((num1 == num2) + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			return 0;
		}

		public boolean calcBoolean() {
			return num1 == num2;
		}

		@Override
		public ArrayList<Block> getBabies() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	/**
	 * The and block takes in 2 booleans, inputed by the user, and returns true if
	 * both the booleans are true, else false
	 */
	protected Block and = new Block(BlocksDrawer.leftMargin, 600, BlocksCategoryWindow.operatorsColor, "And", "", false,
			false, Block.BlockType.OPERATOR, Block.ParamType.OPERATOR, Block.SecondaryBlock.BABY) {
		boolean val1, val2;

		public void run() {
			// nope
		}

		public void callParams() {
			try {
				val1 = Boolean.parseBoolean(JOptionPane.showInputDialog("What's the 1st boolean value?"));
				val2 = Boolean.parseBoolean(JOptionPane.showInputDialog("What's the 2nd boolean value?"));
				setParams((val1 && val2) + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			return 0;
		}

		public boolean calcBoolean() {
			return val1 && val2;
		}

		@Override
		public ArrayList<Block> getBabies() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	/**
	 * The or block takes in 2 booleans, inputed by the user, and returns true if
	 * one or more of the booleans are true, else false
	 */
	protected Block or = new Block(BlocksDrawer.leftMargin, 675, BlocksCategoryWindow.operatorsColor, "Or", "", false,
			false, Block.BlockType.OPERATOR, Block.ParamType.OPERATOR, Block.SecondaryBlock.BABY) {
		boolean val1, val2;

		public void run() {
			// nope
		}

		public void callParams() {
			try {
				val1 = Boolean.parseBoolean(JOptionPane.showInputDialog("What's the 1st boolean value?"));
				val2 = Boolean.parseBoolean(JOptionPane.showInputDialog("What's the 2nd boolean value?"));
				setParams((val1 || val2) + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			return 0;
		}

		public boolean calcBoolean() {
			return val1 || val2;
		}

		@Override
		public ArrayList<Block> getBabies() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	/**
	 * The not block takes in a boolean, inputed by the user, and returns its
	 * opposite value
	 */
	protected Block not = new Block(BlocksDrawer.leftMargin, 750, BlocksCategoryWindow.operatorsColor, "Not", "", false,
			false, Block.BlockType.OPERATOR, Block.ParamType.OPERATOR, Block.SecondaryBlock.BABY) {
		boolean val1;

		public void run() {
			// nope
		}

		public void callParams() {
			try {
				val1 = Boolean.parseBoolean(JOptionPane.showInputDialog("What's the boolean value?"));
				setParams(!val1 + "");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
			return 0;
		}

		public boolean calcBoolean() {
			return !val1;
		}

		@Override
		public ArrayList<Block> getBabies() {
			// TODO Auto-generated method stub
			return null;
		}
	};

	protected static ArrayList<Block> blocks = new ArrayList<Block>();

	/**
	 * Creates a new instance of the Operators object, adding each of the blocks to
	 * an ArrayList to be drawn
	 */
	public Operators() {
		super("Operators", blocks, BlocksCategoryWindow.operatorsColor);
		blocks.add(add);
		blocks.add(subtract);
		blocks.add(multiply);
		blocks.add(divide);
		blocks.add(greaterThan);
		blocks.add(lessThan);
		blocks.add(equalTo);
		blocks.add(and);
		blocks.add(or);
		blocks.add(not);
	}

	/**
	 * Returns all the blocks from the Operators category
	 * 
	 * @return the blocks from the Operators ArrayList
	 */
	@Override
	public ArrayList<Block> getBlocks() {
		return blocks;
	}
}
