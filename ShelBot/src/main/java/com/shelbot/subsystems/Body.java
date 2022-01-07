/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.shelbot.subsystems;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pi4j.component.servo.impl.PCA9685GpioServoDriver;
import com.pi4j.gpio.extension.pca.PCA9685GpioProvider;
import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinPwmOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CFactory;
import com.pi4j.io.i2c.I2CFactory.UnsupportedBusNumberException;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.shelbot.constants.RobotConstants;
import com.shelbot.constants.RobotMap;
import com.shelbot.utils.Logger;

/**
 * Represents a shelbot's body
 * 
 */
public class Body extends Subsystem {

	private static PCA9685GpioProvider gpioProvider;
	
	private static Hip rightHip;
	private static Hip leftHip;

	private static Knee rightKnee;
	private static Knee leftKnee;
	
	private static Foot rightFoot;
	private static Foot leftFoot; 

	public Body() {
		
		final GpioController gpio = GpioFactory.getInstance();
		
		try {
			gpioProvider = createProvider();
		} catch (UnsupportedBusNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rightHip = new Hip(RobotMap.RIGHT_HIP, false, "frontLeftHip", RobotConstants.rightHipHomePos, 0, 180);
		leftHip = new Hip(RobotMap.LEFT_HIP, false, "frontRightHip", RobotConstants.leftHipHomePos, 0, 180);
		rightKnee = new Knee(RobotMap.RIGHT_KNEE, false, "midLeftHip", RobotConstants.rightKneeHomePos, 0, 180);
		leftKnee = new Knee(RobotMap.LEFT_KNEE, false, "midRightHip", RobotConstants.leftKneeHomePos, 0, 180);
		rightFoot = new Foot(RobotMap.RIGHT_FOOT, false, "backLeftHip", RobotConstants.rightFootHomePos, 0, 180);
		leftFoot = new Foot(RobotMap.LEFT_FOOT, false, "backRightHip", RobotConstants.leftFootHomePos, 0, 180);

        // Define outputs in use for this example
        provisionPwmOutputs(gpioProvider);
    
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(null);
	}
	
	private PCA9685GpioProvider createProvider() throws UnsupportedBusNumberException, IOException {
        BigDecimal frequency = PCA9685GpioProvider.ANALOG_SERVO_FREQUENCY;
        BigDecimal frequencyCorrectionFactor = new BigDecimal("1.0578");

        I2CBus bus = I2CFactory.getInstance(I2CBus.BUS_1);
        return new PCA9685GpioProvider(bus, 0x40, frequency, frequencyCorrectionFactor);
    }
	
	private GpioPinPwmOutput[] provisionPwmOutputs(final PCA9685GpioProvider gpioProvider) {
        GpioController gpio = GpioFactory.getInstance();
        GpioPinPwmOutput myOutputs[] = {
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_00, "Servo 00"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_01, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_02, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_03, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_04, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_05, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_06, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_07, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_08, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_09, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_10, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_11, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_12, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_13, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_14, "not used"),
                gpio.provisionPwmOutputPin(gpioProvider, PCA9685Pin.PWM_15, "not used")};
        return myOutputs;
    }
	
	public static PCA9685GpioProvider getGpioProvider() {
		return gpioProvider;
	}
	
	public Hip getRightHip() {
		return rightHip;
	}
	
	public Hip getLeftHip() {
		return leftHip;
	}
	
	public Knee getRightKnee() {
		return rightKnee;
	}
	
	public Knee getLeftKnee() {
		return leftKnee;
	}
	
	public Foot getRightFoot() {
		return rightFoot;
	}
	
	public Foot getLeftFoot() {
		return leftFoot;
	}
	
	public Hip[] getHips() {
		return new Hip[] {getRightHip(), getLeftHip()};
	}
	
	public Foot[] getFeet() {
		return new Foot[] {getRightFoot(), getLeftFoot()};
	}

	public Knee[] getKnees(){
		return new Knee[] {getRightKnee(), getLeftKnee()};
	}

	public ServoSubsystem[] getRightLeg(){
		return new ServoSubsystem[] {getRightHip(), getRightKnee(), getRightFoot()};
	}

	public ServoSubsystem[] getLeftLeg(){
		return new ServoSubsystem[] {getLeftHip(), getLeftKnee(), getLeftFoot()};
	}
	
	public void logAllServoPositions() {
		Logger.consoleLog("RightHip %s", getRightHip().getServo().getPosition());
		Logger.consoleLog("LeftHip %s", getLeftHip().getServo().getPosition());
		Logger.consoleLog("RightKnee %s", getRightKnee().getServo().getPosition());
		Logger.consoleLog("LeftKnee %s", getLeftKnee().getServo().getPosition());
		Logger.consoleLog("RightFoot %s", getRightFoot().getServo().getPosition());
		Logger.consoleLog("LeftFoot %s", getLeftFoot().getServo().getPosition());
	}
	
}
