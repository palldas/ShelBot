package com.shelbot.subsystems;

import com.pi4j.component.servo.ServoBase;
import com.pi4j.component.servo.impl.GenericServo;
import com.pi4j.component.servo.impl.PCA9685GpioServoDriver;
import com.pi4j.component.servo.impl.Servo;
import com.pi4j.gpio.extension.pca.PCA9685Pin;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.exception.ValidationException;


public class Hip extends ServoSubsystem{
	
	
	public Hip(Pin pin, int homePos) {
        super(pin, false, "Leg", homePos, 0, 180);
	}
	
	public Hip(Pin pin, boolean isReversed, String name, int homePos) {
        super(pin, isReversed, name, homePos, 0, 180);
	}
	
	public Hip(Pin pin, boolean isReversed, String name, int homePos, int maxLimit, int minLimit) {
        super(pin, isReversed, name, homePos, maxLimit, minLimit);

	}

}
