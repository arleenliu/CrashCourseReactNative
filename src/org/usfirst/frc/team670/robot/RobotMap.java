package org.usfirst.frc.team670.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static String tableName = "GaffCV";
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	public static int leftMotor1 = 1;
	public static int leftMotor2 = 2;
	public static int rightMotor1 = 3;
	public static int rightMotor2 = 4;

	public static int leftStick = 1;
	public static int rightStick = 2;
	public static int operatorStick = 0;
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
