package org.usfirst.frc.team4571.robot.commands;

import org.usfirst.frc.team4571.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnDegreesCommand extends Command {

    private double angle;

	public TurnDegreesCommand(double angle) {
    	requires(Robot.TANK_DRIVE_SUBSYSTEM);
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.TANK_DRIVE_SUBSYSTEM.initialize();
    	Robot.TANK_DRIVE_SUBSYSTEM.setAnglePIDParameter(angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("NavX Angle", Robot.TANK_DRIVE_SUBSYSTEM.getNavXAngle());
    	SmartDashboard.putNumber("Angle SetPoint", Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getSetpoint());
    	SmartDashboard.putNumber("Angle Average Error", Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getAvgError());
    	SmartDashboard.putNumber("Angle Error", Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().getError());

    	SmartDashboard.putNumber("Turn Controller Get", Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().get());
    	SmartDashboard.putNumber("Distance Controller Get", (Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().get()));
    	SmartDashboard.putNumber("Left Speed ( Distance - Turn )", (Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().get() - Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().get()));
    	SmartDashboard.putNumber("Right Speed ( Distance + Turn )", (Robot.TANK_DRIVE_SUBSYSTEM.getDistanceController().get() + Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().get()));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.TANK_DRIVE_SUBSYSTEM.isAngleFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.TANK_DRIVE_SUBSYSTEM.getTurnController().disable();
    }
}
