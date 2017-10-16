package org.usfirst.frc.team670.robot.subsystems;

import org.usfirst.frc.team670.robot.RobotMap;
import org.usfirst.frc.team670.robot.commands.DriveWithJoystick;

import com.ctre.*;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem {

	//Ratio of left motor rotations / right motor rotations
	private double motorRatio = 1.15;
	
	//Motor controllers
	public CANTalon leftTalon1;
	public CANTalon leftTalon2;
	public CANTalon rightTalon1;
	public CANTalon rightTalon2;

	//Converts ticks distance to a number the talon can read (It needs it multiplied for some reason)
	private final int talonConversion = 2520;

	//Wheel/PID Variables
	public static final double radiusInInches = 3;
	public static final double diameterInInches = radiusInInches * 2;
	public static final double circumferenceInInches = diameterInInches * Math.PI;
	public static final double inchesPerTick = circumferenceInInches / 360;
	public static final double P = 0.8, I = 0.05, D = 0;
	public static final double pivotRadius = Math.sqrt(277);
	
	
	public DriveBase() {
		leftTalon1 = new CANTalon(RobotMap.leftMotor1);
		leftTalon2 = new CANTalon(RobotMap.leftMotor2);
		rightTalon1 = new CANTalon(RobotMap.rightMotor1);
		rightTalon2 = new CANTalon(RobotMap.rightMotor2);
		
		leftTalon1.set(RobotMap.leftMotor1);
		leftTalon2.changeControlMode(CANTalon.TalonControlMode.Follower);
		leftTalon2.set(leftTalon1.getDeviceID());

		rightTalon1.set(RobotMap.rightMotor1);
		rightTalon2.changeControlMode(CANTalon.TalonControlMode.Follower);
		rightTalon2.set(rightTalon1.getDeviceID());


		leftTalon1.setEncPosition(0);
		rightTalon1.setEncPosition(0);

	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());
	}

	public void drive(double left, double right) {
		leftTalon1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rightTalon1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		leftTalon1.set(((left)));
		rightTalon1.set((-right));
	}
	
	public void driveAuto(double left, double right) {
		leftTalon1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rightTalon1.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		leftTalon1.set(((left)));
		rightTalon1.set((-right));
	}

	public void resetRightEncoder() {
		rightTalon1.setEncPosition(0);
	}

	public void resetLeftEncoder() {
		leftTalon1.setEncPosition(0);
	}

	public void driveDistance(double inches) 
	{
		//		encLeft.reset();
		//		encRight.reset();
		//double numTicks = ((inches / inchesPerTick) / 360) * talonConversion;
		rightTalon1.setControlMode(CANTalon.TalonControlMode.Position.value);
		//This should be setting the set point to move encoder ticks
		rightTalon1.set(0);
		rightTalon1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rightTalon1.configEncoderCodesPerRev(1440);
		rightTalon1.configNominalOutputVoltage(+0.0f, -0.0f);
		rightTalon1.configPeakOutputVoltage(+6.0f, -6.0f);
		rightTalon1.setAllowableClosedLoopErr(0);
		rightTalon1.setPID(P,I,D); //Set the PID constants (p, i, d)
		rightTalon1.setPosition(0);
		rightTalon1.enableControl();
		
		leftTalon1.setControlMode(CANTalon.TalonControlMode.Position.value);
		//This should be setting the set point to move encoder ticks
		leftTalon1.set(0);
		leftTalon1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		leftTalon1.configEncoderCodesPerRev(1440);
		leftTalon1.configNominalOutputVoltage(+0.0f, -0.0f);
		leftTalon1.configPeakOutputVoltage(+6.0f, -6.0f);
		leftTalon1.setAllowableClosedLoopErr(0);
		leftTalon1.setPID(P,I,D); //Set the PID constants (p, i, d)
		leftTalon1.setPosition(0);
		leftTalon1.enableControl();
		
		leftTalon1.set(-numTicks);
		rightTalon1.set(numTicks);
	}

	public void pivot(double degrees) 
	{
		double pivotCircumference = 2 * Math.PI * pivotRadius;
		double pivotArcLength = (degrees / 360) * pivotCircumference;
		double numTicks = ((pivotArcLength / inchesPerTick) / 360) * talonConversion;

		leftTalon1.changeControlMode(CANTalon.TalonControlMode.Position);
		leftTalon1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		leftTalon1.setEncPosition(0);

		rightTalon1.changeControlMode(CANTalon.TalonControlMode.Position);
		rightTalon1.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rightTalon1.setEncPosition(0);

		leftTalon1.setPID(P,I,D);
		rightTalon1.setPID(P,I,D);

		leftTalon1.set(-numTicks);
		rightTalon1.set(-numTicks);
	}
	
}