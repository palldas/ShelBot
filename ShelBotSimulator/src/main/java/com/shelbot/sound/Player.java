package com.shelbot.sound;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

/**
 * Represents a player that can play and stop sounds
 * 
 * @author  
 * @version 5/13/20
 */
public class Player {

    Minim minim;
    AudioPlayer player;

    String nameFile;

    /**
     * Used to make a player
     * 
     * @param applet PApplet object
     * @param nameFile the name of the file to play
     * @param fileDir the complete dir of the file
     */
    public Player(PApplet applet, String nameFile, String fileDir) {
        minim = new Minim(applet);
        player = minim.loadFile(fileDir);
        this.nameFile = nameFile;
    }

    /**
     * Used to play the sound
     */
    public void play() {
        try {
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to pause the sound
     */
    public void pause() {
        try {
            player.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to rewind the sound
     */
    public void rewind() {
        try {
            player.rewind();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to replay the sound
     */
    public void replay() {
        try {
            player.rewind();
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Used to mute the sound
     */
    public void mute() {
        try {
            player.mute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to loop the sound num times
     * 
     * @param num the num of times to loop
     */
    public void loop(int num) {
        try {
            player.loop(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to set the volume of the sound
     * 
     * @param volume the new volume of the sound
     */
    public void setVolume(float volume) {
        try {
            player.setVolume(volume);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to get the filename of the sound
     * 
     * @return fileName the name of the file
     */
    public String getFileName() {
        return nameFile;
    }

    /**
     * Used to check if the sound is playing
     * 
     * @return isPlaying true if the sound is playing
     */
    public boolean isPlaying() {
        try {
            return player.isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}