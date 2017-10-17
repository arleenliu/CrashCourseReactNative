package org.usfirst.frc.team670.robot.utils;

public class Movement 
{
	/**
	 * @param input Live value from joystick
	 * @param a Gradient value for sensitivity (between 0 and 1)
	 **/
	public static double sensitivity(double input, double a)
	{
		return a*(Math.pow(input, 3)) + (1-a)*input;
	}
	
	
}
