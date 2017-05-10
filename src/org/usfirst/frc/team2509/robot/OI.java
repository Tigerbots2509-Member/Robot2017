package org.usfirst.frc.team2509.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	public Joystick DRIVER;
	public Joystick CODRIVER;
	public OI(){
		DRIVER = new Joystick(0);
		CODRIVER = new Joystick(1);
	}
	public Joystick getDriver(){
		return DRIVER;
	}
	public Joystick getCoDriver(){
		return CODRIVER;
	}
	public double getScaledX(Joystick stick){
		return (stick.getX()*((stick.getRawAxis(3)+3)*0.25));
	}
	public double getScaledY(Joystick stick){
		return (stick.getY()*((stick.getRawAxis(3)+3)*0.25));
	}
	public double getScaledZ(Joystick stick){
		return (stick.getZ()*((stick.getRawAxis(3)+3)*0.25));
	}
}