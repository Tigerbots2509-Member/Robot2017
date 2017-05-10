package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

/**
 *
 */
public class Shooter extends Subsystem {
	private final CANTalon SHOOTER = RobotMap.ST_MOTOR;
	private final Talon GATE = RobotMap.ST_GATE;
	private final Talon AUGER = RobotMap.ST_AUGER;

    public void initDefaultCommand() {
    }
    public void Run(int TargetSpeed){
    	SHOOTER.set(TargetSpeed);
    	System.out.println("SHOOTER STARTING");
    	Timer.delay(0.5);
    	GATE.set(0.6);
    	System.out.println("GATE OPENING");
    	Timer.delay(0.125);
    	GATE.set(0);
    	AUGER.set(0.5);
    	System.out.println("AUGER STARTING");
    }
    public void Stop(){
    	SHOOTER.changeControlMode(TalonControlMode.PercentVbus);
    	SHOOTER.set(0);
    	SHOOTER.changeControlMode(TalonControlMode.Speed);
    	AUGER.set(0);
    	GATE.set(-0.6);
    	Timer.delay(0.125);
    	GATE.set(0.0);
    }
}

