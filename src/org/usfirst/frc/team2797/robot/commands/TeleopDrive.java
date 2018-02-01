package org.usfirst.frc.team2797.robot.commands;

import org.usfirst.frc.team2797.robot.OI;
import org.usfirst.frc.team2797.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TeleopDrive extends Command{

	
	public TeleopDrive() {
		requires(Robot.drivetrain);
		//requires(Robot.elevator);
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void execute() {
		Robot.drivetrain.driveRobot(OI.gamepad.getRawAxis(1), OI.gamepad.getRawAxis(5));
		//Robot.elevator.moveElevator(OI.gamepad.getRawAxis(2), OI.gamepad.getRawAxis(3));
		OI.aButton.whenPressed(new ExampleCommand());
	}
	
	protected void end() {
		Robot.drivetrain.stop();
	}
	
	protected void interrupted() {
		end();
	}
}
