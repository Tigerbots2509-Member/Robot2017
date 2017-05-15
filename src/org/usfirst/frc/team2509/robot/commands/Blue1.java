package org.usfirst.frc.team2509.robot.commands;

import org.opencv.core.Rect;
import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Blue1 extends Command {
	private DriveTrain DT = Robot.driveTrain;
	private Thread GearVision = Robot.vision.Gear;
	private Thread BoilerVision = Robot.vision.Boiler;
	private Rect GearTarget = Robot.vision.getGearTarget();
	private Rect ShooterTarget = Robot.vision.getBoilerTarget();
    public Blue1() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	GearVision.start();
    	if(Timer.getMatchTime()<=15&&Timer.getMatchTime()>0){
    		DT.LeftAutoForward_1();
    		DT.TurnRobot(45);
    		DT.LeftAutoForward_2();
    	}
    	while(GearTarget == null&&Timer.getMatchTime()<=15&&Timer.getMatchTime()>0)Timer.delay(0.05);
    	if(GearTarget!=null&&Timer.getMatchTime()<=15&&Timer.getMatchTime()>0){
    		DT.DropGear(GearTarget);
    		if(Timer.getMatchTime()<=5){
    			while(Timer.getMatchTime()<=5)Timer.delay(0.05);
    			DT.AutoGearBackOff();
    		}else{
    			Timer.delay(5);
    			DT.AutoGearBackOff();
    		}
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !(Timer.getMatchTime()>0&&Timer.getMatchTime()<15);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
