// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Utils.sparkMaxLinearDistance;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {

    TalonSRX elevatorMotor = new TalonSRX(Constants.elevatorMotorPin);
    TalonSRX elevatorMotor2 = new TalonSRX(Constants.elevatorMotorPin2);
    sparkMaxLinearDistance persistentDistanceMeasure = new sparkMaxLinearDistance(elevatorMotor.getEncoder(), 1) ; // TODO: set values properly

  
    private static Elevator elevator = new Elevator();
    public static Elevator getElevator () {
        return elevator;
    }

    public void setElevatorSpeed(double speed){
 main-dev-jh-auto
        elevatorMotor.set(ControlMode.PercentOutput,speed);
        elevatorMotor2.set(ControlMode.PercentOutput,speed);


    }

    public sparkMaxLinearDistance getPersistentDistanceMeasure(){
        return persistentDistanceMeasure;
  }
}

