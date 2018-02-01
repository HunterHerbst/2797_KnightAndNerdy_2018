/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.             
/* McCall
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2797.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor  = 1;
	// public static int rightMotor = 2;
	public static int flMotor	    = 0,
					  blMotor	    = 1,
					  frMotor	    = 2,
					  brMotor       = 3,
					  elevatorMotor = 9;
	
	public static int leftEncChA  	 = 0,
					  leftEncChB  	 = 1,
					  rightEncChA 	 = 2,
					  rightEncChB 	 = 3,
					  elevatorEncChA = 4,
					  elevatorEncChB = 5;
	
	public static boolean leftEncDirection  = false,
						  rightEncDirection = false,
						  elevatorDirection = true;
	
	
	public static Spark frontLeft 		= new Spark(flMotor),
						frontRight		= new Spark(frMotor),
						backLeft   	  	= new Spark(blMotor),
						backRight	    = new Spark(brMotor),
						elevatorSpark   = new Spark(elevatorMotor);
	
	public static Encoder leftEncoder 	  = new Encoder(leftEncChA,     leftEncChB,  	leftEncDirection,  EncodingType.k1X);
	public static Encoder rightEncoder	  = new Encoder(rightEncChA, 	rightEncChB,	rightEncDirection, EncodingType.k1X);
	public static Encoder elevatorEncoder = new Encoder(elevatorEncChA, elevatorEncChB, elevatorDirection);
	
	public static SpeedControllerGroup leftDriveMotors  = new SpeedControllerGroup(frontLeft,  backLeft),
			 			 			   rightDriveMotors = new SpeedControllerGroup(frontRight, backRight);
	
	public static DifferentialDrive drivetrainTankDrive = new DifferentialDrive(leftDriveMotors, rightDriveMotors);
	
	//public static AHRS gyro = new AHRS(SPI.Port.kMXP);
	
	
	
	
	
	
	
	
	public static void init() {
		resetEncoders();
	}
	
	public static void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
		elevatorEncoder.reset();
	}
	
	public static boolean driveEncStopped() {
		return leftEncoder.getStopped() && rightEncoder.getStopped();
	}
	

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
