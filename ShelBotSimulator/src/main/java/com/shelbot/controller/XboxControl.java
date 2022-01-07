package com.shelbot.controller;

import com.studiohartman.jamepad.*;

/**
 * A class for making Jamepad more easier
 * 
 * @author  
 * @version 5/16/20
 */
public class XboxControl {

	public static ControllerManager controllers;
	public static ControllerIndex currController;

	// public static void main(String[] args) throws ControllerUnpluggedException {
	// //Print a message when the "A" button is pressed. Exit if the "B" button is
	// pressed
	// //or the controller disconnects.
	//
	//
	// while(true) {
	// controllers.update(); //If using ControllerIndex, you should call update() to
	// check if a new controller
	// //was plugged in or unplugged at this index.
	// }
	// }

	/**
	 * Creates a new instance of XboxControl, Constructor for XboxControl from jamePad
	 */
	public XboxControl() {
		controllers = new ControllerManager();
		controllers.initSDLGamepad();
		currController = controllers.getControllerIndex(0);
	}

	/**
	 * Used to get leftX Value
	 * 
	 * @return leftX value of controller
	 * @throws ControllerUnpluggedException exception
	 */
	public double getLeftX() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.LEFTX);
	}

	/**
	 * Used to get leftY value
	 * 
	 * @return leftY value of controller
	 * @throws ControllerUnpluggedException exception
	 */
	public double getLeftY() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.LEFTY);
	}

	/**
	 * Used to get right x value
	 * 
	 * @return rightX value of controller
	 * @throws ControllerUnpluggedException exception
	 */
	public double getRightX() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.RIGHTX);
	}

	/**
	 * used to get right y value
	 * 
	 * @return rightY value of controller
	 * @throws ControllerUnpluggedException exception
	 */
	public double getRightY() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.RIGHTY);
	}

	/**
	 * used to get left trigger value
	 * 
	 * @return left trigger value of controller
	 * @throws ControllerUnpluggedException exception
	 */
	public double getLeftTrigger() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.TRIGGERLEFT);
	}

	/**
	 * used to get right trigger value
	 * 
	 * @return right trigger value of controller
	 * @throws ControllerUnpluggedException exception
	 */
	public double getRightTrigger() throws ControllerUnpluggedException {
		return currController.getAxisState(ControllerAxis.TRIGGERRIGHT);
	}

	/**
	 * used to know if 'a' is pressed
	 * 
	 * @return whethere 'a' has been pressed or not
	 * @throws ControllerUnpluggedException exception
	 */
	public boolean aPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.A);
	}

	/**
	 * used to know if 'b' is pressed
	 * 
	 * @return whether 'b' has been pressed or not
	 * @throws ControllerUnpluggedException exception
	 */
	public boolean bPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.B);
	}

	/**
	 * used to know if 'x' is pressed
	 * 
	 * @return whether 'x' has been pressed or not
	 * @throws ControllerUnpluggedException exception
	 */
	public boolean xPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.X);
	}

	/**
	 * used to know if 'y' is pressed
	 * 
	 * @return whether 'y' has been pressed or not
	 * @throws ControllerUnpluggedException exception
	 */
	public boolean yPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.Y);
	}

	/**
	 * used to know if left bumper is pressed
	 * 
	 * @return whether the left bumper has been pressed or not
	 * @throws ControllerUnpluggedException exception
	 */
	public boolean leftBumperPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.LEFTBUMPER);
	}

	/**
	 * Used to know if right bumper is pressed
	 * 
	 * @return whether the right bumper has been pressed or not
	 * @throws ControllerUnpluggedException exception
	 */
	public boolean rightBumperPressed() throws ControllerUnpluggedException {
		return currController.isButtonPressed(ControllerButton.RIGHTBUMPER);
	}

	/**
	 * used to get dpadX value
	 * 
	 * @return the dpadX value of the controller
	 * @throws ControllerUnpluggedException exception
	 */
	public int getDpadX() throws ControllerUnpluggedException {
		if (currController.isButtonPressed(ControllerButton.DPAD_UP)) {
			return 1;
		}
		if (currController.isButtonPressed(ControllerButton.DPAD_DOWN)) {
			return -1;
		}
		return 0;
	}

	/**
	 * used to get dpadY value
	 * 
	 * @return the dpadY value of the controller
	 * @throws ControllerUnpluggedException exception
	 */
	public int getDpadY() throws ControllerUnpluggedException {
		if (currController.isButtonPressed(ControllerButton.DPAD_RIGHT)) {
			return 1;
		}
		if (currController.isButtonPressed(ControllerButton.DPAD_LEFT)) {
			return -1;
		}
		return 0;
	}

}
