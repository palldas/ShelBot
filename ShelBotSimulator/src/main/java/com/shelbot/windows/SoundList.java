package com.shelbot.windows;

import java.awt.Color;
import java.util.ArrayList;

import com.shelbot.sound.Player;
import com.shelbot.sound.Sound;
import com.shelbot.utils.Section;
import com.shelbot.utils.TabbedPane;

import processing.core.PApplet;

/**
 * Represents the Sound List which contains all the sounds
 * 
 * @author Pallavi Das and  
 * @version 5/17/20
 */
public class SoundList extends Section {

    public static ArrayList<Sound> sounds; 

    private float leftMargin;
    private float topMargin;
    private float size;

    /**
     * Used to create a sound list
     */
    public SoundList(){
        super(10, 65, Color.white);
    }

    /**
     * Used to setup a sound list
     * @param applet The PApplet object used to setup the Sound List
     */
    public void setup(PApplet applet){
        sounds = new ArrayList<Sound>();

        sounds.add(new Sound(700, 100, 100, new Player(applet, "Shelby -\nHey There", "audio/simulator/heythere.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Shelby -\nWeek's Goals", "audio/simulator/shelby_week_goals.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Taylor -\nBack in the\nOld Days", "audio/simulator/taylor_old_days.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Bruh", "audio/simulator/bruh.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Wow", "audio/simulator/wow.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Boi", "audio/simulator/boi.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "It eez\nwhat it\neez", "audio/simulator/itis.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Screaming\nSheep", "audio/simulator/screamingsheep.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "FBI", "audio/simulator/fbi.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Mario\nJump", "audio/simulator/mariojump.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Microsoft\nShut Down", "audio/simulator/microsoft.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Nani!?", "audio/simulator/nani.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Hannah\nMontana", "audio/simulator/hannah_montana.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "I like\nthe View", "audio/simulator/view.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "You may say\nI'm a\ndreamer", "audio/simulator/dreamer.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Talented\nBrilliant\nShow\nStopping", "audio/simulator/talented.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Hey Queen", "audio/simulator/hey_queen.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Yankee\nWith No\nBrim", "audio/simulator/yankee.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Boom Boom\nBoom", "audio/simulator/boomboomboom.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Call of\nDuty", "audio/simulator/callofduty.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Kombucha\nGirl", "audio/simulator/kombucha.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Roman\nHoliday", "audio/simulator/roman_holiday.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Jason\nDeruloo", "audio/simulator/jason_derulo.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Noah\nCentineo", "audio/simulator/noah.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "The Volume\nInside of\nthis Bus", "audio/simulator/astronomical.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Titanic\nFlute", "audio/simulator/titanic_flute.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "2020\nPresident\nCandidate", "audio/simulator/2020prez.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Cardi B\nCorona Virus", "audio/simulator/cardi_corona.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "You Did\nThis For\nWhat", "audio/simulator/forwhat.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Kahoot", "audio/simulator/kahoot.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "Baby Shark", "audio/simulator/shark.mp3")));
        sounds.add(new Sound(700, 100, 100, new Player(applet, "We Got\nHim", "audio/simulator/got_him.mp3")));
    }

    /**
     * Used to draw the SoundList
     * @param applet the papplet object used to draw the soundList
     */
    public void draw(PApplet applet){
        super.draw(applet);
        leftMargin = getX() + (0.02f * getWidth());
        topMargin = TabbedPane.tabHeight + 0.025f * getHeight();
        size = 0.1f * getWidth();
        float nextX = leftMargin;
        float nextY = topMargin;
        for(Sound sound : sounds){
            sound.setX(nextX);
            sound.setY(nextY);
            sound.setSize(size);
            sound.draw(applet);
            if((nextX+2*sound.getWidth()+(leftMargin-getX())) >= getX()+getWidth()){
                nextX = leftMargin;
                nextY += sound.getWidth()+(topMargin-TabbedPane.tabHeight);
            }
            else{
                nextX += sound.getWidth() + (leftMargin-getX());
            }
            if(sound.overButton){
                sound.highlight(true);
            }
            else{
                sound.highlight(false);
            }
        }
    }

    /**
     * Deals with mousePressed events
     * @param mouseX the x of the mouse
     * @param mouseY the y of the mouse
     */
    public void mousePressed(int mouseX, int mouseY){
        for(Sound sound: sounds){
            if(sound.overButton(mouseX, mouseY)){
                if(sound.getPlayer().isPlaying()){
                    sound.getPlayer().pause();
                }
                else{
                    sound.getPlayer().replay();
                    sound.highlight(true);
                }
            }
        }
    }

    /**
     * Deals with mouseReleased events
     */
    public void mouseReleased(){
        for(Sound sound : sounds){
            if(!sound.getPlayer().isPlaying()){
                sound.highlight(false);
            }
        }
    }

    /**
     * Deals with mouseMoved events
     * @param mouseX the x of the mouse
     * @param mouseY the y of the mouse
     */
    public void mouseMoved(int mouseX, int mouseY){
        for(Sound sound : sounds){
            if(sound.overButton(mouseX, mouseY)){
                sound.overButton = true;
            }
            else{
                sound.overButton = false;
            }
        }
    }
    
}
