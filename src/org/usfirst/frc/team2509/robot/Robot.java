package org.usfirst.frc.team2509.robot;


import org.usfirst.frc.team2509.robot.subsystems.Climber;
import org.usfirst.frc.team2509.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2509.robot.subsystems.Shooter;
import org.usfirst.frc.team2509.robot.subsystems.Sweeper;
import org.usfirst.frc.team2509.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {
	public static OI oi;
    public static Climber climber;
    public static DriveTrain driveTrain;
    public static Shooter shooter;
    public static Sweeper sweeper;
    public static Vision vision;
    
	public void robotInit() {
		RobotMap.init();
		climber = new Climber();
        driveTrain = new DriveTrain();
        shooter = new Shooter();
        sweeper = new Sweeper();
        vision = new Vision();
		oi = new OI();
	}

	public void disabledInit() {

	}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
