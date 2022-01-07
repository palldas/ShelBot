package com.shelbot.tts;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;

import marytts.LocalMaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.MaryAudioUtils;

/**
 * Represents an interface that converts text to audio files
 * 
 * @author 
 * @version 5/17/20
 */
public class TextSpeech {

    LocalMaryInterface mary;

    /**
     * Constructor for TextSpeech
     * 
     * @throws MaryConfigurationException exception
     */
    public TextSpeech() throws MaryConfigurationException {
        mary = new LocalMaryInterface();
    }

    /**
     * writes a .wav file into the program containing audio
     * 
     * @param toSpeak script for the tts to speak
     * @param name    the name of the .wav file to be made
     */
    public void createTTSAudio(String toSpeak, String name) {

        AudioInputStream audio = null;
        try {
            audio = mary.generateAudio(toSpeak);
        } catch (SynthesisException e) {
            e.printStackTrace();
        }
        // return audio;

        double[] samples = MaryAudioUtils.getSamplesAsDoubleArray(audio);
        try {
            MaryAudioUtils.writeWavFile(samples, "audio/simulator/" + name + ".wav", audio.getFormat());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}