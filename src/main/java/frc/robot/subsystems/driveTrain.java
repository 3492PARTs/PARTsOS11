// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.hal.SimDouble;
import edu.wpi.first.hal.simulation.SimDeviceDataJNI;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Utils.encoderDistanceSparkMax;
import frc.robot.Constants;

public class driveTrain extends SubsystemBase {

  int[] CANLeft = Constants.driveTrainLeftSideCANIds;
  int[] CANRight = Constants.driveTrainRightSideCANIds;

  CANSparkMax left1 = new CANSparkMax(CANLeft[0], MotorType.kBrushless);
  CANSparkMax left2 = new CANSparkMax(CANLeft[1], MotorType.kBrushless);
  CANSparkMax left3 = new CANSparkMax(CANLeft[2], MotorType.kBrushless);

  

  CANSparkMax right1 = new CANSparkMax(CANRight[0], MotorType.kBrushless);
  CANSparkMax right2 = new CANSparkMax(CANRight[1], MotorType.kBrushless);
  CANSparkMax right3 = new CANSparkMax(CANRight[2], MotorType.kBrushless);

  RelativeEncoder[] leftEncoders = {left1.getEncoder(), left2.getEncoder(), left3.getEncoder()};
  RelativeEncoder[] rightEncoders = {right1.getEncoder(), right2.getEncoder(), right3.getEncoder()};

  


  

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(left1, left2, left3);
  
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(right1, right2, right3);
  DifferentialDrive m_Drive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);
// right positive and continous
//left negative and continous
  AHRS gyro = new AHRS();
  int dev = SimDeviceDataJNI.getSimDeviceHandle("navX-Sensor[0]");
  SimDouble angle = new SimDouble(SimDeviceDataJNI.getSimValueHandle(dev, "Yaw"));
/**
 * 
 * @return right positive and to infinity, left negative to negative infinity.
 */
  public double getAngle(){
    return gyro.getAngle();
  }

  private double prevAngle = 0;
  private long prevTime = 0;
  /**
   * @see make sure you discard first run each time
   * @return the angular velocity of the robot
   */
  public double gyroVelocity(){
    double angVel = 1000* ((gyro.getAngle() - prevAngle) / ((System.currentTimeMillis() - prevTime)));
    prevTime = System.currentTimeMillis();
    prevAngle = gyro.getAngle();
    return angVel;

  }

  private static driveTrain m_DriveTrain = new driveTrain();
  
  /** Creates a new driveTrain. */
  private driveTrain() {
    leftControllerGroup.setInverted(true);

    double rampRate = .75;
    left1.setOpenLoopRampRate(rampRate);
    left2.setOpenLoopRampRate(rampRate);
    left3.setOpenLoopRampRate(rampRate);

    right1.setOpenLoopRampRate(rampRate);
    right2.setOpenLoopRampRate(rampRate);
    right3.setOpenLoopRampRate(rampRate);

  }
  // Singleton Pattern use this, DO NOT make a new instance of a subsystem
  public static driveTrain getM_DriveTrain() {
      return m_DriveTrain;
  }

  public void move(double left , double right){
    m_Drive.tankDrive(left, right);

  } 

  public void arcadeDrive(double speed, double rotation){
    m_Drive.arcadeDrive(speed, rotation);
  }

  public encoderDistanceSparkMax getDriveTrainDistanceMeasure(){
    encoderDistanceSparkMax encoders = new encoderDistanceSparkMax(leftEncoders, rightEncoders,8.01 ,6*Math.PI);
    return encoders;
    
  }

  public double getLeftVelocity(){
    double VelocityAccumulator = 0;
    for (int i = 0; i < leftEncoders.length; i++) {
      VelocityAccumulator += leftEncoders[i].getVelocity();
    }
    return VelocityAccumulator/3;
  }

  public double getRightVelocity(){
    double VelocityAccumulator = 0;
    for (int i = 0; i < rightEncoders.length; i++) {
      VelocityAccumulator += rightEncoders[i].getVelocity();
    }
    return VelocityAccumulator/3;
  }

  public void calibrateGyro(){
    gyro.calibrate();
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
