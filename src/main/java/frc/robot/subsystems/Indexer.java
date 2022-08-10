// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Utils.encoderDistanceTalonSRX;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
  /** Creates a new Indexer. */
  private Indexer() {}

  private TalonSRX indexerMotor = new TalonSRX(Constants.indexerMotor);

  private static Indexer _indexer = new Indexer();

  public static Indexer getIndexer(){
    return _indexer;
  }

  public void setIndexerSpeed(double speed){
    indexerMotor.set(ControlMode.PercentOutput, speed);
  }

  public encoderDistanceTalonSRX getNonPersistantDistanceMeasure(){
    return new encoderDistanceTalonSRX(new TalonSRX[] {indexerMotor} , 1 , 1); // TODO: set accurate values 
  } 


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
