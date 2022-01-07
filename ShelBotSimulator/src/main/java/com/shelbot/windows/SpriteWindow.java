package com.shelbot.windows;

import java.awt.Color;

import com.shelbot.sprite.Humanoid;
import com.shelbot.sprite.Sprite;
import com.shelbot.utils.Section;

import processing.core.PApplet;

/**
 * This window contains the sprite
 * 
 * @author  
 * @version 5/15/20
 */
public class SpriteWindow extends Section {

    private float centerX = getWidth() / 2;
    private float centerY = getHeight() / 2;

    private Sprite sprite = new Humanoid(centerX, centerY, 0.5f*getWidth(), 0.8f*getHeight());

    /**
     * Used to make a sprrite window
     */
    public SpriteWindow() {
        super(65, 100, Color.white);
        // TODO Auto-generated constructor stub
    }

    /**
     * Used to setup the SpriteWindow
     * @param applet the PApplet object used to setup
     */
    public void setup(PApplet applet){
        sprite.setup(applet);
    }

    /**
     * Used to draw the spriteWindow
     * @param applet the PApplet object used to drraw
     */
    public void draw(PApplet applet) {
        super.draw(applet);

        centerX = getX() + getWidth() / 2;
        centerY = getY() + getHeight() / 2;

        // bot = new Humanoid(centerX, centerY, 100, 100);
        // cat = new Cat(centerX, centerY, 100, 100);
        if(!sprite.isMoved){
            sprite.updateAttr(centerX, centerY, 0.3f*getWidth(), 0.4f*getHeight());
        }
        sprite.draw(applet);
        // cat = new Cat(centerX, centerY, 100, 100);
        // cat.draw(applet);
    }

    // // change for actual sprite used
    // public Cat getCat() {
    //     return cat;
    // }

    /**
     * Used to get the sprite
     * @return sprite the sprite of the window
     */
    public Sprite getSprite(){
        return sprite;
    }

    /**
     * Used to reset the sprite window back to normal including moving the sprite back to origin
     */
    public void reset(){
        sprite.isMoved = false;
        sprite.rotate(0);
    }

}