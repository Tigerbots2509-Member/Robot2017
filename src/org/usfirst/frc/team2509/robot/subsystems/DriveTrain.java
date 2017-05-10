package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.OI;
import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.CANTalon;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private final CANTalon LEFTFRONT = RobotMap.DT_LEFTFRONT;
	private final CANTalon LEFTREAR = RobotMap.DT_LEFTREAR;
	private final CANTalon RIGHTFRONT = RobotMap.DT_RIGHTFRONT;
	private final CANTalon RIGHTREAR = RobotMap.DT_RIGHTREAR;
	private final ADXRS450_Gyro GYRO = RobotMap.DT_GYRO;
	private final RobotDrive DRIVE = RobotMap.DRIVETRAIN;
	private final OI oi = Robot.oi;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void MecaDrive(){
    	DRIVE.mecanumDrive_Cartesian(oi.getScaledX(oi.getDriver()), 
    			oi.getScaledY(oi.getDriver()), oi.getScaledZ(oi.getDriver()), 0);
    }
}

