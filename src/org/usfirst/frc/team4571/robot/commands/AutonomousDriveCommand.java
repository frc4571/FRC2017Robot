package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousDriveCommand extends Command {
	public int time = 0;
    public AutonomousDriveCommand() {
    	requires(Robot.TANK_DRIVE_SUBSYSTEM);
    	        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	time = 0;
    	 }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	time++;
    	if (time >= 0 && time <= 10){
    		Robot.TANK_DRIVE_SUBSYSTEM.setMotors(1);
    	}
    	if (time >= 10 && time <= 15){
    		Robot.TANK_DRIVE_SUBSYSTEM.setMotors(-1);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.TANK_DRIVE_SUBSYSTEM.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
