// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


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

  RelativeEncoder left = left1.getEncoder();
  RelativeEncoder right = right1.getEncoder();
  RelativeEncoder[] leftEncoders = {left};
  RelativeEncoder[] rightEncoders = {right};



  

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(left1, left2, left3);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(right1, right2, right3);
  DifferentialDrive m_Drive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);
  
  private static driveTrain m_DriveTrain = new driveTrain();
  
  /** Creates a new driveTrain. */
  private driveTrain() {

  }
  // Singleton Pattern use this, DO NOT make a new instance of a subsystem
  public static driveTrain getM_DriveTrain() {
      return m_DriveTrain;
  }

  public void move(double left , double right){
    m_Drive.tankDrive(left, right);

  } 

  public encoderDistanceSparkMax getDriveTrainDistanceMeasure(){
    
    return new encoderDistanceSparkMax(leftEncoders, rightEncoders);
    
  }


  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
