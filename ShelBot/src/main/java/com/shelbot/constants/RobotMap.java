package com.shelbot.constants;

import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.gpio.Pin;

public class RobotMap {
	
	public static final Pin LEFT_FOOT = PCA9685Pin.PWM_04;
	public static final Pin RIGHT_FOOT = PCA9685Pin.PWM_08;
	public static final Pin LEFT_KNEE = PCA9685Pin.PWM_05;
	public static final Pin RIGHT_KNEE = PCA9685Pin.PWM_09;
	public static final Pin LEFT_HIP = PCA9685Pin.PWM_06;
	public static final Pin RIGHT_HIP = PCA9685Pin.PWM_10;

}
