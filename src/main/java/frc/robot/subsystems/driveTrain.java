// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveTrain extends SubsystemBase {
  CANSparkMax left1 = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax left2 = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax left3 = new CANSparkMax(1, MotorType.kBrushless);

  CANSparkMax right1 = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax right2 = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax right3 = new CANSparkMax(1, MotorType.kBrushless);

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(left1, left2, left3);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(right1, right2, right3);
  DifferentialDrive m_Drive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

  AnalogGyro gyro = new AnalogGyro();

  public double getAngle(){
    return gyro.getAngle();
  }

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

  public void moveArcade(double speed, double angle){
    m_Drive.turn
  }


  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
