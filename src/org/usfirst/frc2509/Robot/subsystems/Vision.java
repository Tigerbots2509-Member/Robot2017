// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2509.Robot.subsystems;

import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.usfirst.frc2509.Robot.RobotMap;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Vision extends Subsystem {
	
	
	private final ArrayList<MatOfPoint> 
		contours = new ArrayList<MatOfPoint>();
	private final boolean 
		isINIT = true;
	protected final double
		CAMERA_ANGLE = 15,
		CAMERA_OFFSET_FRONT = 0,
		CAMERA_OFFSET_CENTER = 0,
		VERTICAL_FOV = 30.25,
		HORIZANTAL_FOV = 53.75;
	protected final int
		CAMERA_HEIGHT = 0,
		BOILER_HEIGHT = 88,
		BOILER_WIDTH = 15,
		FRAME_RATE = 0,
		GEAR_PEG_HEIGHT =16;
	private final CvSink
		CVSINK = CameraServer.getInstance().getVideo();
	private final CvSource 
		OUTPUT_STREAM = CameraServer.getInstance().putVideo("ALT-Cam", 640, 480);
	private final UsbCamera 
		FRONT_CAM = RobotMap.FRONT_CAM;
	public final Mat 
		BINARY = new Mat(),
		CLUSTERS = new Mat(),		
		HEIRARCHY = new Mat(),
		HSV = new Mat(),
		OUTPUT = new Mat(),
		SOURCE = new Mat(),
		THRESH = new Mat();
	protected final Scalar 
		//COLOR VALUES
		BLACK = new Scalar(0,0,0),
		BLUE = new Scalar(255, 0, 0),
		GREEN = new Scalar(0, 255, 0),
		RED = new Scalar(0, 0, 255),
		YELLOW = new Scalar(0, 255, 255),
		//Thresholds values
		LOWER_BOUNDS = new Scalar(180,190,40),
		UPPER_BOUNDS = new Scalar(200,210,60);
	protected final Size 
		RESIZE = new Size(320,240);
	
    public void initDefaultCommand() {
    }
    
}
