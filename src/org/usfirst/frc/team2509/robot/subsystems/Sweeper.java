package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;

/**
 *
 */
public class Sweeper extends Subsystem {
	private final CANTalon MOTOR = RobotMap.SW_MOTOR;

    public void initDefaultCommand() {
    }
    public void Forward(){
    	MOTOR.set(1);
    }
    public void Reverse(){
    	MOTOR.set(-1);
    }
    public void Stop(){
    	MOTOR.set(0);
    }
}

