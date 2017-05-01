package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;

/**
 *
 */
public class Climber extends Subsystem {
	private final CANTalon TOPMOTOR = RobotMap.C_TOP;
	private final CANTalon BOTTOMMOTOR = RobotMap.C_BOTTOM;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Up(){
    	TOPMOTOR.set(1);
    	BOTTOMMOTOR.set(1);
    }
    public void Down(){
    	TOPMOTOR.set(-1);
    	BOTTOMMOTOR.set(-1);
    }
    public void Stop(){
    	TOPMOTOR.set(0);
    	BOTTOMMOTOR.set(0);    	
    }
}

