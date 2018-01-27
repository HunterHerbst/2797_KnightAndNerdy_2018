package org.usfirst.frc.team2797.robot.commands;

import org.usfirst.frc.team2797.robot.Robot;
import org.usfirst.frc.team2797.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/*
	Each wheel rotation drives the robot forward about 18.84955592 inches.
	That is about 1.570796327 feet.
	5 feet is about 3.183098862 rotations.
	Each rotation is 360 ticks on the encoder.
	5 feet is about 1145.91559 encoder ticks.
*/
public class AutoDrive extends Command{
	
	
	
	
	public AutoDrive() {
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {
		RobotMap.leftEncoder.reset();
		RobotMap.rightEncoder.reset();
	}
	
	protected void execute() {
		RobotMap.resetEncoders();
		Robot.drivetrain.driveForwardDistance(10.0, 0.5);
		Robot.kExampleSubsystem.printLeftEnc();
		RobotMap.resetEncoders();
		Robot.drivetrain.driveBackwardDistance(2.0, 0.5);
		Robot.kExampleSubsystem.printLeftEnc();
		cancel();
		
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
	}
	
	protected void interrupted() {
	}

}
