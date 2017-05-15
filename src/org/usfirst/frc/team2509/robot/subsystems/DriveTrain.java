package org.usfirst.frc.team2509.robot.subsystems;

import org.opencv.core.Rect;
import org.usfirst.frc.team2509.robot.OI;
import org.usfirst.frc.team2509.robot.Robot;
import org.usfirst.frc.team2509.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

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
    public void AutoGearBackOff(){
    	DRIVE.mecanumDrive_Cartesian(0, -0.75, 0, 0);
    	Timer.delay(0.75);
    	DRIVE.drive(0, 0);
    }
    public void CenterAutoForward(){
    	DRIVE.mecanumDrive_Cartesian(0, 0.5, 0, 0);
    	Timer.delay(1.15);
    	DRIVE.drive(0, 0);
    }
    public void CenterAutoMoveBlueBoiler(){
    	DRIVE.mecanumDrive_Cartesian(0, -0.75, 0, 0);
    	Timer.delay(0.25);
    	DRIVE.drive(0,0);
    	TurnRobot(-50);
    }
    public void CenterAutoMoveRedBoiler(){
    	
    }
    public void DropGear(Rect Target){
    	while(/*SWITCH.get()==false&&*/Target.width<26){
  			if(Target.x<60){
  				System.out.println("TO THE LEFT");
  				DRIVE.mecanumDrive_Cartesian(0.35, 0, 0, 0);
  				Timer.delay(0.04);
  				DRIVE.mecanumDrive_Cartesian(0, 0, 0, 0);
  			}
  			else if(Target.x>70){
  				System.out.println("TO THE RIGHT");
  				DRIVE.mecanumDrive_Cartesian(-0.35,0, 0, 0);
  				Timer.delay(0.04);
  				DRIVE.mecanumDrive_Cartesian(0, 0, 0, 0);
  			}
  			else if(Target.x>=60&&Target.x<=70){
  				System.out.println("FORWARD");
  				DRIVE.mecanumDrive_Cartesian(0, 0.3, 0, 0);	
  				Timer.delay(0.25);
  				DRIVE.mecanumDrive_Cartesian(0, 0.0, 0, 0);
  				Timer.delay(0.25);
  			}
  		}
    	DRIVE.mecanumDrive_Cartesian(0, 0.5, 0, 0);
		Timer.delay(0.4);
		DRIVE.drive(0, 0);
    }
    public void LeftAutoForward_1(){
    	DRIVE.mecanumDrive_Cartesian(0, 0.75, 0, 0);
    	Timer.delay(1);
    	DRIVE.drive(0, 0);
    }
    public void LeftAutoForward_2(){
    	DRIVE.mecanumDrive_Cartesian(0, 0.5, 0, 0);
        Timer.delay(.3);
        DRIVE.drive(0, 0);
    }
    public void LeftAutoMoveBoiler(){
    	
    }
    public void RightAutoForward_1(){
    	DRIVE.mecanumDrive_Cartesian(0, 0.75, 0, 0);
    	Timer.delay(1.2);
    	DRIVE.drive(0, 0);
    }
    public void RightAutoForward_2(){
    	DRIVE.mecanumDrive_Cartesian(0, 0.5, 0, 0);
    	Timer.delay(.3);
    	DRIVE.drive(0, 0);
    }
    public void RightAutoMoveBoiler(){
    	
    }
    public void TurnRobot(double Degree){
    	if(GYRO.getAngle()<Degree){
    		while(GYRO.getAngle()<Degree){
    			DRIVE.mecanumDrive_Cartesian(0, 0, 0.4, 0);
    			Timer.delay(0.05);
    			DRIVE.drive(0, 0);
    		}
    	}else if(GYRO.getAngle()>Degree){
    		while(GYRO.getAngle()>Degree){
    			DRIVE.mecanumDrive_Cartesian(0, 0, -0.4, 0);
    			Timer.delay(0.05);
    			DRIVE.drive(0, 0);
    		}
    	}
    }
    public RobotDrive getDriveTrain(){
    	return DRIVE;
    }
    public ADXRS450_Gyro getGyro(){
    	return GYRO;
    }
}

