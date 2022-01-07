package com.shelbot.utils;

import java.awt.Color;

import com.shelbot.Analyzer;
import com.shelbot.SimulatorWindow;
import com.shelbot.windows.ProgrammingWindow;

import processing.core.PApplet;
import processing.core.PShape;

/**
 * The tabbed pane on the top the shelbot simulator
 * 
 * @author  
 * @version 5/17/20
 */
public class TabbedPane {

    /**
     * The currentView of the tabbed pane. 
     * CODE - If the view of the shelbot sim is set to Code window
     * SOUND - if the view of the shekbot sim is set to Sound window
     * CONTROL - if the view of the shelbot sim is set to the Control Window
     * TUTORIAL - if the view of the shelbot sim is set to the tutorial window
     */
    public static enum CurrentView {
        CODE, 
        SOUND, CONTROL, TUTORIAL
    }

    public static float tabHeight;
    private Color highlightColor = new Color(217, 228, 243);

    Tab code = new Tab("Code", 0);
    Tab sounds = new Tab("Sounds", code.getWidth());
    Tab control = new Tab("Control", sounds.getWidth());
    Tab tutorials = new Tab("Tutorials", control.getWidth());

    ImageButton run = new ImageButton("run.png",
            SimulatorWindow.spriteWindow.getX() + 0.01f * SimulatorWindow.spriteWindow.getWidth(), 0.1f * tabHeight,
            0.8f * tabHeight, 0.8f * tabHeight);
    ImageButton stop = new ImageButton("stop.png",
            run.getX() + run.getWidth() + 0.01f * SimulatorWindow.spriteWindow.getWidth(), 0.1f * tabHeight,
            0.8f * tabHeight, 0.8f * tabHeight);

    private boolean isCode = true;
    private boolean isSound = false;
    private boolean isControl = false;
    private boolean isTutorial = false;

    private boolean overRun;
    private boolean overStop;

    /**
     * Used to draw the tabbed Pane
     * @param applet the PApplet object used to draw the drawer
     */
    public void draw(PApplet applet) {
        sounds.setX(code.getWidth());
        control.setX(sounds.getWidth());
        tutorials.setX(control.getWidth());
        tabHeight = applet.height * 0.06f;
        applet.line(0, tabHeight, applet.width, tabHeight);

        run = new ImageButton("run.png",
                SimulatorWindow.spriteWindow.getX() + 0.01f * SimulatorWindow.spriteWindow.getWidth(), 0.1f * tabHeight,
                0.8f * tabHeight, 0.8f * tabHeight);
        stop = new ImageButton("stop.png",
                run.getX() + run.getWidth() + 0.01f * SimulatorWindow.spriteWindow.getWidth(), 0.1f * tabHeight,
                0.8f * tabHeight, 0.8f * tabHeight);

        if (overRun) {
            run.highlight(true);
        } else {
            run.highlight(false);
        }

        if (overStop) {
            stop.highlight(true);
        } else {
            stop.highlight(false);
        }

        if (getCurrentView().equals(CurrentView.CODE) || getCurrentView().equals(CurrentView.SOUND)) {
            run.draw(applet);
            stop.draw(applet);
        }

        if (isCode) {
            applet.pushStyle();
            applet.fill(highlightColor.getRGB());
            code.draw(applet);
            applet.popStyle();
            sounds.draw(applet);
            control.draw(applet);
            tutorials.draw(applet);
        }
        if (isSound) {
            applet.pushStyle();
            applet.fill(highlightColor.getRGB());
            sounds.draw(applet);
            applet.popStyle();
            code.draw(applet);
            control.draw(applet);
            tutorials.draw(applet);
        }
        if (isControl) {
            applet.pushStyle();
            applet.fill(highlightColor.getRGB());
            control.draw(applet);
            applet.popStyle();
            sounds.draw(applet);
            code.draw(applet);
            tutorials.draw(applet);
        }
        if (isTutorial) {
            applet.pushStyle();
            applet.fill(highlightColor.getRGB());
            tutorials.draw(applet);
            applet.popStyle();
            sounds.draw(applet);
            control.draw(applet);
            code.draw(applet);
        }
    }

    /**
     * Used to deal with the mouseMoved events
     * @param mouseX the x coorrd of the mouse
     * @param mouseY the y coord of the mouse
     */
    public void mouseMoved(int mouseX, int mouseY) {
        if (run.overButton(mouseX, mouseY)) {
            overRun = true;
        } else {
            overRun = false;
        }
        if (stop.overButton(mouseX, mouseY)) {
            overStop = true;
        } else {
            overStop = false;
        }
    }

    /**
     * Used to deal with the mousePressed events
     * @param mouseX the x coorrd of the moouse
     * @param mouseY the y coord of the mouse
     */
    public void mousePressed(int mouseX, int mouseY) {
        if (run.overButton(mouseX, mouseY)) {
            run();
        }
        if (stop.overButton(mouseX, mouseY)) {
            stop();
        }

        if (code.overTab(mouseX, mouseY)) {
            isCode = true;
            isSound = false;
            isControl = false;
            isTutorial = false;
            // System.out.println("code");
        } else if (sounds.overTab(mouseX, mouseY)) {
            isCode = false;
            isSound = true;
            isControl = false;
            isTutorial = false;
            // System.out.println("sound");
        } else if (control.overTab(mouseX, mouseY)) {
            isCode = false;
            isSound = false;
            isControl = true;
            isTutorial = false;
            // System.out.println("control");
        } else if (tutorials.overTab(mouseX, mouseY)) {
            isCode = false;
            isSound = false;
            isControl = false;
            isTutorial = true;
            // System.out.println("tutorials");
        }
    }

    /**
     * Used to get the currentView
     * @return view The currentView of the shelbot sim
     */
    public CurrentView getCurrentView() {
        if (isCode) {
            return CurrentView.CODE;
        } else if (isControl) {
            return CurrentView.CONTROL;
        } else if (isSound) {
            return CurrentView.SOUND;
        } else {
            return CurrentView.TUTORIAL;
        }
    }

    /**
     * Used to set the current view of the simulator window
     * @param view The new view of the simulator window
     */
    public void setCurrentView(CurrentView view) {
        if (view.equals(CurrentView.CODE)) {
            isCode = true;
            isControl = false;
            isSound = false;
            isTutorial = false;
        } else if (view.equals(CurrentView.CONTROL)) {
            isControl = true;
            isCode = false;
            isSound = false;
            isTutorial = false;
        } else if (view.equals(CurrentView.SOUND)) {
            isSound = true;
            isControl = false;
            isCode = false;
            isTutorial = false;
        } else {
            isTutorial = true;
            isControl = false;
            isSound = false;
            isCode = false;
        }
    }

    private class Tab {

        private String title;
        private PShape s;

        private float height = 0.7f * tabHeight;
        private float width;
        private float x;

        public Tab(String title, float x) {
            this.title = title;
            this.x = x;
        }

        public void draw(PApplet applet) {
            applet.pushStyle();
            height = 0.7f * tabHeight;
            // applet.textSize(0.01f*applet.width);
            float textWidth = applet.textWidth(title) + 0.8f * applet.textWidth(title);
            width = x + textWidth;
            applet.beginShape();
            applet.vertex(x, tabHeight);
            applet.vertex((x), (float) tabHeight - (height * 0.8f));
            applet.vertex((x + 0.05f * textWidth), (float) tabHeight - height);
            applet.vertex((x + textWidth), (float) tabHeight - height);
            applet.vertex((x + textWidth), tabHeight);
            applet.endShape(applet.CLOSE);
            applet.textAlign(applet.CENTER, applet.CENTER);
            applet.textSize(SimulatorWindow.textSize);
            applet.fill(Color.black.getRGB());
            applet.text(title, x + (textWidth / 2), (tabHeight / 1.65f));
            applet.popStyle();
        }

        public boolean overTab(int mouseX, int mouseY) {
            if (mouseX >= x && mouseX <= width && mouseY >= tabHeight - height && mouseY <= tabHeight) {
                return true;
            } else {
                return false;
            }
        }

        public float getWidth() {
            return width;
        }

        public void setX(float x) {
            this.x = x;
        }
    }

    private static Thread runner;

    /**
     * Used to run the code written by the user
     */
    public static void run(){
        runner = new Thread(){
        public void run(){
            Analyzer.runBlocks(ProgrammingWindow.getBlocks());
        }
    };
        runner.start();
    }

    /**
     * Used to stop the code written by the user
     */
    public static void stop() {
        try{
            runner.stop();
            SimulatorWindow.spriteWindow.reset();
        } catch (Exception e){
            e.printStackTrace();
        }
        
    }

}