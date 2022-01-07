package com.shelbot.controller;

import java.io.IOException;

import com.studiohartman.jamepad.ControllerUnpluggedException;

/**
 * Another runnable class for multithreading. Uses and starts xbox listener
 * 
 * @author  
 * @version 5/16/20
 */
public class Xbox implements Runnable {

	/**
	 * Creates a new instance of Xbox. Constructor to listen to xbox until user
	 * click exit
	 */
	public Xbox() {
		XboxListener xbox = new XboxListener();

		try {
			while (xbox.exit()) {
				xbox.Listen();
			}
		} catch (ControllerUnpluggedException | IOException | InterruptedException e1) {
			System.out.println("Controller not connected");
		}

		// ControlPanelJframe.close();
	}

	@Override
	/**
	 * Run method as it's a runnable class
	 */
	public void run() {
		new Xbox();
		System.out.println("Xbox thread is running");
	}
}
