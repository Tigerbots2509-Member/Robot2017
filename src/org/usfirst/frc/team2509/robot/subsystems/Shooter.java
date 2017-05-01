package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;

/**
 *
 */
public class Shooter extends Subsystem {
	private final CANTalon SHOOTER = RobotMap.ST_MOTOR;
	private final Talon GATE = RobotMap.ST_GATE;
	private final Talon AUGER = RobotMap.ST_AUGER;

    public void initDefaultCommand() {
    }
    
}

