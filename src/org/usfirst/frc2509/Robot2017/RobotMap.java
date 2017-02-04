/**
 * @author Tigerbots
 */
package org.usfirst.frc2509.Robot2017;

import com.ctre.CANTalon;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static CANTalon DT_LEFTFRONT;
    public static CANTalon DT_RIGHTFRONT;
    public static CANTalon DT_LEFTREAR;
    public static CANTalon DT_RIGHTREAR;
    public static RobotDrive DRIVETRAIN;
    public static CANTalon SWEEP_MOTOR;
    public static CANTalon SHOOT_MOTOR;
    public static Encoder SHOOT_ENCODER;
    public static CANTalon SHOOT_KICKER;
    public static CANTalon CLIMB_MOTOR;

    public static UsbCamera FRONT_CAM;

    public static void init() {
        DT_LEFTFRONT = new CANTalon(0);
        LiveWindow.addActuator("DriveTrain", "DT_LEFTFRONT", DT_LEFTFRONT);
        
        DT_RIGHTFRONT = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "DT_RIGHTFRONT", DT_RIGHTFRONT);
        
        DT_LEFTREAR = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "DT_LEFTREAR", DT_LEFTREAR);
        
        DT_RIGHTREAR = new CANTalon(3);
        LiveWindow.addActuator("DriveTrain", "DT_RIGHTREAER", DT_RIGHTREAR);
        
        DRIVETRAIN = new RobotDrive(DT_LEFTFRONT, DT_LEFTREAR,
              DT_RIGHTFRONT, DT_RIGHTREAR);
        
        DRIVETRAIN.setSafetyEnabled(false);
        DRIVETRAIN.setExpiration(1.0);
        DRIVETRAIN.setSensitivity(1.0);
        DRIVETRAIN.setMaxOutput(1.0);

        DRIVETRAIN.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        DRIVETRAIN.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
        SWEEP_MOTOR = new CANTalon(5);
        LiveWindow.addActuator("Sweeper", "Motor", (CANTalon) SWEEP_MOTOR);
        
        SHOOT_MOTOR = new CANTalon(7);
        LiveWindow.addActuator("Shooter", "Motor", (CANTalon) SHOOT_MOTOR);
        
        SHOOT_ENCODER = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("Shooter", "Encoder", SHOOT_ENCODER);
        SHOOT_ENCODER.setDistancePerPulse(1.0);
        SHOOT_ENCODER.setPIDSourceType(PIDSourceType.kRate);
        
        SHOOT_KICKER = new CANTalon(8);
        LiveWindow.addActuator("Shooter", "Kicker", SHOOT_KICKER);
        
        CLIMB_MOTOR = new CANTalon(6);
        LiveWindow.addActuator("Climb", "Motor", CLIMB_MOTOR);

        FRONT_CAM = CameraServer.getInstance().startAutomaticCapture();
    }
}
