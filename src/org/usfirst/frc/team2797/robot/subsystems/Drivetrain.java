package org.usfirst.frc.team2797.robot.subsystems;

import org.usfirst.frc.team2797.robot.RobotMap;
import org.usfirst.frc.team2797.robot.commands.TeleopDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends PIDSubsystem {
	
	//The circumference of the wheel in feet
	private final double WheelCircumference = .5*Math.PI;
	
	private SpeedControllerGroup leftMotors  = RobotMap.leftDriveMotors,
								 rightMotors = RobotMap.rightDriveMotors;
	
	
	private Encoder leftEnc  = RobotMap.leftEncoder;
	private Encoder rightEnc = RobotMap.rightEncoder;
	
	
	private final DifferentialDrive robotDrivetrain = RobotMap.drivetrainTankDrive;
	
	public Drivetrain() {
		super("Drivetrain", 1.0, 0.0, 0.0, 0.5);
		setAbsoluteTolerance(0.2);
		getPIDController().setContinuous(false);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new TeleopDrive());
	}
	
	protected double returnPIDInput() {
		return leftEnc.pidGet();
	}
	
	protected double returnPIDInput(boolean leftSide) {
		if(leftSide)
			return leftEnc.pidGet();
		else
			return rightEnc.pidGet();
	}
	
	protected void usePIDOutput(double output) {
		leftMotors.pidWrite(output);
	}
	
	protected void usePIDOutput(double output, boolean leftSide) {
		if(leftSide)
			leftMotors.pidWrite(output);
		else
			rightMotors.pidWrite(output);
	}
	
	public void driveRobot(double leftSpeed, double rightSpeed) {
		robotDrivetrain.tankDrive(leftSpeed*-1, rightSpeed*-1);
	}
	
	public void stop() {
		robotDrivetrain.tankDrive(0, 0);
	}
	
	public void driveForwardDistance(double distance, double speed) {
		
		double encCount = distance*(360/WheelCircumference);
		while(RobotMap.leftEncoder.get() <= encCount) {
			driveRobot(speed, speed);
		}
		
	}
	public void driveBackwardDistance(double distance, double speed) {
		double encCount = distance*(360/WheelCircumference);
		while(RobotMap.leftEncoder.get() >= -encCount) {
			driveRobot(-speed, -speed);
		}
	}
}
