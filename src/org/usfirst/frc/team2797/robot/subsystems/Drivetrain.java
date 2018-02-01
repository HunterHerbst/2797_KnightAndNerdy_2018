package org.usfirst.frc.team2797.robot.subsystems;

import org.usfirst.frc.team2797.robot.RobotMap;
import org.usfirst.frc.team2797.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem implements PIDOutput {

	// The circumference of the wheel in feet
	private final double WheelCircumference = .5 * Math.PI;
	private PIDController wheelControl;

	// private static Encoder rightEnc = RobotMap.rightEncoder;


	public Drivetrain() {
		wheelControl = new PIDController(0.0075, 0.0, 0.0, RobotMap.leftEncoder, this);
		//System.out.println("Setting AbsTolerance");
		wheelControl.setAbsoluteTolerance(1.0);
		
		//System.out.println("Setting PercTolerance");
		wheelControl.setPercentTolerance(10.0);
		
		//System.out.println("Setting Output Range");
		wheelControl.setOutputRange(-0.75, 0.75);
		
		//System.out.println("Setting Continuous to false");
		wheelControl.setContinuous(false);
		
		//System.out.println("Disabling wheelController PIDController");
		wheelControl.disable();
	}

	public PIDController getPIDController() {
		return wheelControl;
	}

	public void enableDrivetrainPID() {
		wheelControl.enable();
	}
	
	public void disableDrivetrainPID() {
		wheelControl.disable();
	}
	
	
	
	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}

	
	
	
	public void driveRobot(double leftSpeed, double rightSpeed) {
		RobotMap.drivetrainTankDrive.tankDrive(leftSpeed * -1, rightSpeed * -1);
	}

	public void stop() {
		RobotMap.drivetrainTankDrive.tankDrive(0, 0);
		wheelControl.disable();
	}

	
	
	
	
	public void driveForwardDistance(double distance, double speed) {
		//System.out.println((int) (distance * (360 / WheelCircumference)));
		wheelControl.setSetpoint((int) (distance * (360 / WheelCircumference)));
		// wheelControl.setOutputRange(-speed, speed);
		
		//System.out.println("Enabling wheelController");
		//wheelControl.enable();

	}

	public void driveBackwardDistance(double distance, double speed) {
		double encCount = distance * (360 / WheelCircumference);
		while (RobotMap.leftEncoder.get() >= -encCount) {
			driveRobot(-speed, -speed);
		}
	}

	
	
	
	
	public void pidWrite(double output) {
		RobotMap.drivetrainTankDrive.tankDrive(output, output);
	}
}
