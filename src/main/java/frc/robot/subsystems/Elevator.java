// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Utils.TalonSRXLinearDistance;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {

    TalonSRX elevatorMotor = new TalonSRX(Constants.elevatorMotorPin);
    TalonSRX elevatorMotor2 = new TalonSRX(Constants.elevatorMotorPin2);
    TalonSRXLinearDistance persistentDistanceMeasure = new TalonSRXLinearDistance(elevatorMotor, 1.0) ; // TODO: set values properly
    public Elevator(){
        elevatorMotor.setNeutralMode(NeutralMode.Brake);
        elevatorMotor2.setNeutralMode(NeutralMode.Brake);
    }


  
    private static Elevator elevator = new Elevator();
    public static Elevator getElevator () {
        return elevator;
    }

    public void setElevatorSpeed(double speed){

        elevatorMotor.set(ControlMode.PercentOutput,speed);
        elevatorMotor2.set(ControlMode.PercentOutput,speed);


    }

    public TalonSRXLinearDistance getPersistentDistanceMeasure(){
        return persistentDistanceMeasure;
  }
}

