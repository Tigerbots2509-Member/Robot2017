package org.usfirst.frc2509.Robot2017.subsystems;

import org.usfirst.frc2509.Robot2017.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	private final CANTalon SHOOT = RobotMap.SHOOT_MOTOR;
	private final CANTalon KICKER = RobotMap.SHOOT_KICKER;
	private final Encoder ENCODER = RobotMap.SHOOT_ENCODER;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
