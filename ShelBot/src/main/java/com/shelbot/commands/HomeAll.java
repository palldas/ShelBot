
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.shelbot.commands;

import com.shelbot.Robot;
import com.shelbot.subsystems.Foot;
import com.shelbot.subsystems.Hip;
import com.shelbot.subsystems.Knee;

import edu.wpi.first.wpilibj.command.Command;

/**
 * An example command. You can replace me with your own command.
 */
public class HomeAll extends Command {

	public HomeAll() {
		requires(Robot.body);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		setTimeout(1);
		
		for(Hip hip : Robot.body.getHips()){
			hip.home();
		}
		for(Knee knee : Robot.body.getKnees()){
			knee.home();
		}
		for(Foot foot : Robot.body.getFeet()){
			foot.home();
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
