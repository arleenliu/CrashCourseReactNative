package org.usfirst.frc.team670.robot.subsystems;

import org.usfirst.frc.team670.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveBase extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public CANTalon leftTalon1;
	public CANTalon leftTalon2;
	public CANTalon rightTalon1;
	public CANTalon rightTalon2;

	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());
	}
}
