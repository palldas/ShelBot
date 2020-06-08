package com.shelbot.blocks;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.shelbot.sound.Sound;
import com.shelbot.windows.AboutWindow;
import com.shelbot.windows.BlocksCategoryWindow;
import com.shelbot.windows.SoundList;

/**
 * This class models the blocks in a Sound window. It contains each block in the
 * category and the execution method of each block.
 * 
 * @author Pallavi Das
 * @version 5/17/20
 */
public class SoundBlocks extends BlocksDrawer {
	private static final Color COLOR = new Color(214, 92, 214);
	Sound chosenSound;
	/**
	 * The playSound block plays the audio file inputed by the user
	 */
	protected Block playSound = new Block(BlocksDrawer.leftMargin, 75, BlocksCategoryWindow.soundColor, "Play Sound",
			null, false, false, Block.BlockType.NORMAL, Block.ParamType.STRING, Block.SecondaryBlock.BABY) {

		//Sound chosenSound;

		public void run() {
			chosenSound.getPlayer().replay();
		}

		public void callParams() {
			try {
				chosenSound = (Sound) JOptionPane.showInputDialog(null, "Choose a sound to play", "Sounds",
						JOptionPane.PLAIN_MESSAGE, AboutWindow.globalIcon, SoundList.sounds.toArray(),
						SoundList.sounds.get(0));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error - Recheck Code or Report a Bug");
				e.printStackTrace();
			}
		}

		public double calc() {
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
	 * The stopSound block stops audio currently playing
	 */
	protected Block stopSound = new Block(BlocksDrawer.leftMargin, 150, BlocksCategoryWindow.soundColor, "Stop Sound",
			null, false, false, Block.BlockType.NORMAL, Block.ParamType.NONE, Block.SecondaryBlock.BABY) {
		public void run() {
			chosenSound.getPlayer().pause();
		}

		public void callParams() {

		}

		public double calc() {
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

	protected static ArrayList<Block> blocks = new ArrayList<Block>();

	/**
	 * Creates a new instance of the Sound object, adding each of the blocks to an
	 * ArrayList to be drawn
	 */
	public SoundBlocks() {
		super("Sound", blocks, BlocksCategoryWindow.soundColor);
		blocks.add(playSound);
		blocks.add(stopSound);
	}

	/**
	 * Returns all the blocks from the Sound category
	 * 
	 * @return the blocks from the Sound ArrayList
	 */
	@Override
	public ArrayList<Block> getBlocks() {
		return blocks;
	}

}
