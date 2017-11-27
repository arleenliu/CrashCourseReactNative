package org.usfirst.frc.team670.robot.commands;

import org.usfirst.frc.team670.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Red_Follower extends Command {

	private double angle = 0, speed, tolerance;
	
    public Red_Follower(double speed, double tolerance) {
    	this.speed = speed;
    	this.tolerance = tolerance;
    	requires(Robot.driveBase);
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	String data = Robot.GaffCV.getString("data", "Angle: 0");
    	angle = Double.parseDouble(data.substring(data.indexOf("Angle: ")+"Angle: ".length()));
    	if(angle > tolerance)
    		Robot.driveBase.drive(speed, -speed);
    	else if(angle < -tolerance)
    		Robot.driveBase.drive(-speed, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveBase.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}