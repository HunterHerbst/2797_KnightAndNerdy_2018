/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2797.robot.subsystems;

import org.usfirst.frc.team2797.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ExampleSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	
	public void initDefaultCommand() {
		//setDefaultCommand(new ExampleCommand());
	}
	
	public void printLeftEnc() {
		System.out.println("L Rotations: " + (RobotMap.leftEncoder.get()/360));
		System.out.println("L Distance: " + RobotMap.leftEncoder.getDistance());
		System.out.println("L Direction: " + RobotMap.leftEncoder.getDirection());
		System.out.println("R Rotations: " + (RobotMap.rightEncoder.get()/360));
		System.out.println("R Distance: " + RobotMap.rightEncoder.getDistance());
		System.out.println("R Direction: " + RobotMap.rightEncoder.getDirection());
		System.out.println("Elevator count: " + RobotMap.elevatorEncoder.get());
	}
}
