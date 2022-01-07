package com.shelbot.windows;

import java.awt.Color;

import javax.swing.JOptionPane;

import com.shelbot.sound.Player;
import com.shelbot.sound.Sound;
import com.shelbot.tts.TextSpeech;
import com.shelbot.utils.Button;
import com.shelbot.utils.Section;
import com.shelbot.utils.TabbedPane;

import marytts.exceptions.MaryConfigurationException;
import processing.core.PApplet;

/**
 * Contains option to upload or convert text to speech
 * 
 * @author  
 * @version 5/11/20
 */
public class Sounds extends Section {

    private Button upload = new Button();
    private Button tts = new Button();

    private float leftMargin, bottomMargin;

    private boolean overUpload;
    private boolean overTTS;

    private int recordingNum = 1;

    PApplet applet;

    private TextSpeech textToSpeech;

    /**
     * Used to create Sound side bar
     */
    public Sounds() {
        super(0, 10, Color.white);
        try {
            textToSpeech = new TextSpeech();
        } catch (MaryConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated constructor stub
    }

    /**
     * Used to draw the Sound barr
     * @param applet the PApplet object used to draw
     */
    public void draw(PApplet applet){
        this.applet = applet;
        super.draw(applet);

        leftMargin = 0.08f*getWidth();
        bottomMargin = 0.08f*getWidth();

        float width = (getWidth()-(2*leftMargin));
        float height = (getWidth()-(3*leftMargin))/2;

        upload = new Button((int)leftMargin, (int) (TabbedPane.tabHeight+bottomMargin), width, height, "Upload", false, null);
        tts = new Button((int)leftMargin, (int) (upload.getY()+upload.getHeight()+bottomMargin), width, height, "TextToSpeech", false, null);

        if(overUpload){
            upload.highlight(true);
        }
        else{
            upload.highlight(false);
        }
        applet.pushStyle();
        
        if(overTTS){
            tts.highlight(true);
        }
        else{
            tts.highlight(false);
        }
        tts.draw(applet);
        applet.popStyle();

        upload.draw(applet);

    }

    /**
     * Deals with mousePressed events
     * @param mouseX the x of the mouse
     * @param mouseY the y of the mouse
     */
    public void mousePressed(int mouseX, int mouseY){
        if(upload.overButton(mouseX, mouseY)){
            applet.selectInput("Select a audio file to upload", "fileSelected");
        }
        if(tts.overButton(mouseX, mouseY)){
            String text = JOptionPane.showInputDialog("What text would you like to convert to speech?");
            try{
                textToSpeech.createTTSAudio(text, "recording" + recordingNum);
                SoundList.sounds.add(new Sound(700, 100, 100, new Player(applet, ("recording"+recordingNum).substring(0, 5)+"\n...", ("audio/simulator/recording"+recordingNum+".wav"))));
                recordingNum++;
            } catch (Exception e){
                e.printStackTrace();
            }
            
        }
    }

    /**
     * Deals with mouseReleased events
     */
    public void mouseReleased(){
        
    }

    /**
     * Deals with mouseMoved movements
     * @param mouseX the x of the mouse
     * @param mouseY the y of the mouse
     */
    public void mouseMoved(float mouseX, float mouseY){
        try{
            if(upload.overButton((int)mouseX, (int)mouseY)){
                overUpload = true;
            }
            else{
                overUpload = false;
            }
            if(tts.overButton((int)mouseX, (int)mouseY)){
                overTTS = true;
            }
            else{
                overTTS = false;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }
    
}