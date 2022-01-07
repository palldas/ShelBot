package com.shelbot.sound;

import ddf.minim.AudioInput;
import ddf.minim.AudioRecorder;
import ddf.minim.Minim;
import processing.core.PApplet;

/**
 * Used to record audio files
 * 
 * @author  
 * @version 5/13/20
 */
public class Recorder {

    private static Minim minim;
    private static AudioInput in;
    private static AudioRecorder recorder;

    private static int numRecordings = 1;

    /**
     * used to make a recorder
     * 
     * @param applet the PApplet object
     */
    public Recorder(PApplet applet) {
        this.minim = new Minim(applet);

        // get a stereo line-in: sample buffer length of 2048
        // default sample rate is 44100, default bit depth is 16
        in = minim.getLineIn();
        System.out.println("in: " + in);

        // create an AudioRecorder that will record from in to the filename specified.
        // the file will be located in the sketch's main folder.
        recorder = minim.createRecorder(in, "recording" + numRecordings + ".mp3");
        System.out.println("REcorder: " + recorder);
    }

    /**
     * Used to start recording
     */
    public static void startRecording() {
        try {
            recorder.beginRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * used to end recording
     */
    public static void stopRecording() {
        try {
            recorder.endRecord();
            numRecordings++;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}