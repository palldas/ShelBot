package com.shelbot.controller;

import java.io.IOException;

import javax.swing.JEditorPane;

import com.shelbot.comms.NetworkTables;
import com.studiohartman.jamepad.ControllerUnpluggedException;

/**
 * Transmits data to server over JEditorPane after inputs from xbox
 * 
 * @author  
 * @version 5/16/120
 */
public class XboxListener {

	XboxControl controller = new XboxControl();
	JEditorPane web = new JEditorPane();

	int i = 0;

	/**
	 * Listens to xbox
	 * 
	 * @throws ControllerUnpluggedException exception
	 * @throws IOException exception
	 * @throws InterruptedException exception
	 */
	public void Listen() throws ControllerUnpluggedException, IOException, InterruptedException {
		NetworkTables.XboxNetworkTableEntries.rightBumper.forceSetBoolean(controller.rightBumperPressed());
		NetworkTables.XboxNetworkTableEntries.leftBumper.forceSetBoolean(controller.leftBumperPressed());
		NetworkTables.XboxNetworkTableEntries.x.forceSetBoolean(controller.xPressed());
		NetworkTables.XboxNetworkTableEntries.a.forceSetBoolean(controller.aPressed());
		NetworkTables.XboxNetworkTableEntries.b.forceSetBoolean(controller.bPressed());
		NetworkTables.XboxNetworkTableEntries.y.forceSetBoolean(controller.yPressed());

		NetworkTables.XboxNetworkTableEntries.rightTriggerState.forceSetDouble(controller.getRightTrigger());
		NetworkTables.XboxNetworkTableEntries.leftTriggerState.forceSetDouble(controller.getLeftTrigger());
		NetworkTables.XboxNetworkTableEntries.leftJoystickXState.forceSetDouble(controller.getLeftX());
		NetworkTables.XboxNetworkTableEntries.rightJoystickXState.forceSetDouble(controller.getRightX());
		NetworkTables.XboxNetworkTableEntries.leftJoystickYState.forceSetDouble(controller.getLeftY());
		NetworkTables.XboxNetworkTableEntries.rightJoystickYState.forceSetDouble(controller.getRightY());
	}

	/**
	 * used to exit listener
	 * 
	 * @return whether exited or not
	 * @throws ControllerUnpluggedException conotrller might be unplugged
	 */
	public boolean exit() throws ControllerUnpluggedException {
		if (controller.bPressed()) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * returns true if the stop button is pressed
	 * 
	 * @return whether the stop button has been pressed or not
	 * @throws ControllerUnpluggedException controller might be unplugged
	 */
	public boolean stopButtonPressed() throws ControllerUnpluggedException {
		if (controller.aPressed()) {
			return false;
		} else {
			return true;
		}
	}
}