// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.Utils.encoderDistanceTalonSRX;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
    TalonSRX elevatorMotor = new TalonSRX(Constants.elevatorMotorPin);
    encoderDistanceTalonSRX persistentDistanceMeasure = new encoderDistanceTalonSRX(new TalonSRX[] {elevatorMotor}, 10 ,1  ) ; // TODO: set values properly
    private static Elevator elevator = new Elevator();
    public Elevator getElevator () {
        return elevator;
    }

    public void setIntakeSpeed(double speed){
        elevatorMotor.set(ControlMode.PercentOutput,speed);

    }
  }

