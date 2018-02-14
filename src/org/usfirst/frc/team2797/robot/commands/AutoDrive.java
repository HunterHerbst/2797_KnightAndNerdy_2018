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
public class AutoDrive extends Command {

	private boolean done = false;

	public AutoDrive() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		RobotMap.resetEncoders();
		done = false;
		Robot.drivetrain.enableDrivetrainPID();
	}

	protected void execute() {
		
		if(!Robot.drivetrain.isPIDEnabled()) 
			Robot.drivetrain.enableDrivetrainPID();
		
		do {
			Robot.drivetrain.driveForwardDistance(10.0, 0.25);
		} while (!(Robot.drivetrain.getPIDController().onTarget()));
		
		do {
			Robot.drivetrain.driveForwardDistance(-5.0, 0.25);
		} while (!Robot.drivetrain.getPIDController().onTarget());
		
		done = true;

	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
		Robot.drivetrain.stop();
	}

	protected void interrupted() {
	}

}
