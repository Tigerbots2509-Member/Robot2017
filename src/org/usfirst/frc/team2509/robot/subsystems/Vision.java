package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
	private final UsbCamera GEAR = RobotMap.GEAR_CAM;
	private final UsbCamera SHOOTER = RobotMap.SHOOTER_CAM;   
    public Thread Gear = new Thread(()->{
    	
    });
    public Thread Boiler = new Thread(()->{
    	
    });
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

