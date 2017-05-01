package org.usfirst.frc.team2509.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

/**
 * 
 * @author Tigerbots
 * 
 * Robot Layout
 * CAN Motors
 * 0- Left Rear
 * 1- Right Front
 * 2- Left Front
 * 3- Right Rear
 * 4- Climber
 * 5- Sweeper
 * 6- Shooter
 * 7- Climber
 * PWM Motors
 * 0- Gate
 * 1- Kicker
 *
 */

public class RobotMap {
	//Drive Train
	public static ADXRS450_Gyro DT_GYRO;
	public static CANTalon DT_LEFTFRONT;
	public static CANTalon DT_LEFTREAR;
	public static CANTalon DT_RIGHTFRONT;
	public static CANTalon DT_RIGHTREAR;
	public static RobotDrive DRIVETRAIN;
	//Climber
	public static CANTalon C_TOP;
	public static CANTalon C_BOTTOM;
	//Shooter
	public static CANTalon ST_MOTOR;
	public static Talon ST_AUGER;
	public static Talon ST_GATE;
	//Sweeper
	public static CANTalon SW_MOTOR;
	//Vision
	public static UsbCamera GEAR_CAM;
	public static UsbCamera SHOOTER_CAM;
	      
	public static void init() {
		DT_GYRO = new ADXRS450_Gyro();
		DT_GYRO.reset();
		DT_GYRO.calibrate();
		LiveWindow.addSensor("Drive Train", "Gyro", DT_GYRO);
		
		DT_LEFTFRONT = new CANTalon(2);
        LiveWindow.addActuator("Drive Train", "Left Front", DT_LEFTFRONT);
        
        DT_RIGHTFRONT = new CANTalon(1);
        LiveWindow.addActuator("Drive Train", "Right Front", DT_RIGHTFRONT);
        
        DT_LEFTREAR = new CANTalon(0);
        LiveWindow.addActuator("Drive Train", "Left Rear", DT_LEFTREAR);
        
        DT_RIGHTREAR = new CANTalon(3);
        LiveWindow.addActuator("Drive Train", "Right Rear", DT_RIGHTREAR);
        
        DRIVETRAIN = new RobotDrive(DT_LEFTFRONT,DT_LEFTREAR,DT_RIGHTFRONT,DT_RIGHTREAR);
        DRIVETRAIN.setMaxOutput(1.0);
        DRIVETRAIN.setSafetyEnabled(false);
        DRIVETRAIN.setSensitivity(1.0);
        
        C_TOP = new CANTalon(4);
        C_TOP.setInverted(true);
        LiveWindow.addActuator("Climber", "Top", C_TOP);
        
        C_BOTTOM = new CANTalon(7);
        C_BOTTOM.setInverted(true);
        LiveWindow.addActuator("Climber", "Bottom", C_BOTTOM);
        
        ST_MOTOR = new CANTalon(6);
        ST_MOTOR.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        ST_MOTOR.reverseSensor(false);
        ST_MOTOR.configNominalOutputVoltage(+0.0f, -0.0f);
        ST_MOTOR.configPeakOutputVoltage(+12.0f, -12.0f);
        ST_MOTOR.setProfile(0);
        ST_MOTOR.setF(0);
        ST_MOTOR.setP(0.04);
        ST_MOTOR.setI(0.0002);
        ST_MOTOR.setD(0.0001);
        ST_MOTOR.changeControlMode(TalonControlMode.Speed);
        LiveWindow.addActuator("Shooter", "Motor", ST_MOTOR);
        
        ST_GATE = new Talon(0);
        LiveWindow.addActuator("Shooter", "Gate", ST_GATE);
        
        ST_AUGER = new Talon(1);
        LiveWindow.addActuator("Shooter", "Auger", ST_AUGER);
        
        SW_MOTOR = new CANTalon(5);
        LiveWindow.addActuator("Sweeper", "Motor", SW_MOTOR);
        
        GEAR_CAM = CameraServer.getInstance().startAutomaticCapture("Gear", 0);
        GEAR_CAM.setBrightness(0);
        GEAR_CAM.setResolution(160,120);
        
        SHOOTER_CAM = CameraServer.getInstance().startAutomaticCapture("Shooter", 1);
        SHOOTER_CAM.setBrightness(0);
        SHOOTER_CAM.setResolution(160, 120);
	}
}
