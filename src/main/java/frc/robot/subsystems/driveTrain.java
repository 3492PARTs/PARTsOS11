// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

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

  AHRS gyro = new AHRS();

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
    double angVel = (gyro.getAngle() - prevAngle) / (System.currentTimeMillis() - prevTime);
    prevTime = System.currentTimeMillis();
    prevAngle = gyro.getAngle();
    return angVel;

  }

  private static driveTrain m_DriveTrain = new driveTrain();
  
  /** Creates a new driveTrain. */
  private driveTrain() {
    leftControllerGroup.setInverted(true);

  }
  // Singleton Pattern use this, DO NOT make a new instance of a subsystem
  public static driveTrain getM_DriveTrain() {
      return m_DriveTrain;
  }

  public void move(double left , double right){
    m_Drive.tankDrive(left, right);

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
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
