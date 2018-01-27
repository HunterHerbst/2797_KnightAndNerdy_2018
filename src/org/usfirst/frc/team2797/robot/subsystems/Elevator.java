package org.usfirst.frc.team2797.robot.subsystems;

import org.usfirst.frc.team2797.robot.OI;
import org.usfirst.frc.team2797.robot.RobotMap;
import org.usfirst.frc.team2797.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Elevator extends PIDSubsystem {
	
	private Spark elevMotor = RobotMap.elevatorSpark;
	
	
	
	public Elevator() {
		super("Elevator", 1.0, 0.0, 0.0);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
	}
	
	protected void usePIDOutput(double output) {
		
	}
	
	protected double returnPIDInput() {
		return 0.0;
	}

	
	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}
	
	public void moveElevator(double down, double up) {
		double moveVal = up - down;
		elevMotor.set(moveVal);
		OI.gamepad.setRumble(RumbleType.kRightRumble, Math.abs(moveVal)/3);
	}
}
