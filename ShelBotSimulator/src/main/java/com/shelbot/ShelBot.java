package com.shelbot;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;

import com.shelbot.utils.SimulatorMenu;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

//MAIN CLASS
public class ShelBot {

	private static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private static GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
	private static Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

	public static final int width = (int) rect.getMaxX();
	public static final int height = (int) rect.getMaxY();

	public static int leftMargin = width / 20;
	public static int widthRect = (width - ((leftMargin * 2) + 20)) / 3;
	
	public static PSurfaceAWT surf;

	public static void main(String[] args) {

		// // TODO: take out, this is a test for the wav files
		// TextSpeech tts = new TextSpeech();
		// tts.createTTSAudio("this is a test", "dalek");

		// System.load("/lib/linux-arm/libudev.so");

		SimulatorWindow drawing = new SimulatorWindow();
		PApplet.runSketch(new String[] { "" }, drawing);
		surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame) canvas.getFrame();

		window.setJMenuBar(new SimulatorMenu(window));
		// window.setIconImage(new ImageIcon("src/main/resources/icon.png").getImage());

		// Application application = Application.getApplication();
		// Image image =
		// Toolkit.getDefaultToolkit().getImage(SimulatorWindow.class.getResource("/resources/Icon.png"));
		// application.setDockIconImage(image);
		window.setTitle("ShelBot");

		window.setSize(width, height);

		int x = (int) rect.getMaxX() - window.getWidth();
		int y = (int) rect.getMaxY() - window.getHeight();
		window.setLocation(x, y);

		window.setMinimumSize(new Dimension(100, 100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();

		System.out.println("Started");

	}
}
