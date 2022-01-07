
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.shelbot.commands;

import com.shelbot.Robot;
import com.shelbot.subsystems.ServoSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command. You can replace me with your own command.
 */
public class WalkForward extends Command {

	public WalkForward() {
		requires(Robot.body);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		setTimeout(5);
		for (ServoSubsystem s : Robot.body.getLeftLeg()) {
			s.home();
		}
		for (ServoSubsystem s : Robot.body.getRightLeg()) {
			s.home();
		}
	}

	protected void execute() {
		
		Robot.body.getLeftFoot().setPosition(80);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Robot.body.getRightKnee().setPosition(70);
		Robot.body.getRightHip().setPosition(80);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Robot.body.getLeftKnee().setPosition(110);
		Robot.body.getLeftHip().setPosition(125);
		Robot.body.getRightKnee().home();
		Robot.body.getRightHip().home();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ServoSubsystem s : Robot.body.getLeftLeg()) {
			s.home();
		}
		for (ServoSubsystem s : Robot.body.getRightLeg()) {
			s.home();
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	// Called once after isFinished returns true
	  @Override
	  protected void end() {
		  Robot.body.logAllServoPositions();
	  }

}
