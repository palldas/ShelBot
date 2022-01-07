package com.shelbot;

import java.util.ArrayList;

import com.shelbot.blocks.Block;

/**
 * Represents a compiler - converts the blocks put together by the user into executable code
 * 
 * @author 
 * @version 5/16/20
 */
public class Analyzer {
    
    /**
     * Compiles the blocks in the program as runnable code and executes the code. 
     * 
     * @param blocks list of the blocks put together by the user
     */
    public static void runBlocks(ArrayList<Block> blocks) {
        // for (int i = 0; i < blocks.size(); i++) {
		// 		System.out.print(blocks.get(i).getText() + " ");
        // 	}
        if(blocks.get(0).getText().equals("When Flag Clicked")){
            for(int i = 0; i < blocks.size(); i++) {
                Block block = blocks.get(i);
                if (block.getBlockType() == Block.BlockType.NORMAL) {
                    block.run();
                }
                if (block.getBlockType() == Block.BlockType.OPERATOR) {
                    block.calc();
                }
                if (block.getBlockType() == Block.BlockType.DADDY && i < blocks.size() - 1) {
                    // if else
                    if (block.isIf()){
                        if (block.calcBoolean()) {
                            Block baby = blocks.get(i+1);
                            baby.run();
                        }
                    }
    
                    // repeat
                    if (block.isRepeat()) {
                        while(block.calcBoolean()) {
                            Block baby = blocks.get(i+1);
                            baby.run();
                        }
                    }
    
                    // forever
                    if (block.isForever()) {
                        while (true) {
                            Block baby = blocks.get(i+1);
                            baby.run();
                        }
                    }
                    i++;
                }
            }

            // for (Block block : blocks) {
                
            //     }
            // }
        }
       
    }
}