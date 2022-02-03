// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Utils.encoderDistance;
import frc.Utils.encoderDistanceSparkMax;

public class PIDDrive extends CommandBase {
  PIDController drivePidController;
  encoderDistanceSparkMax distanceDriven;
  double goalDistance;
  
  /** Creates a new PIDDrive. */
  public PIDDrive(double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    // makes a PID controller object
    drivePidController = new PIDController(kp, ki, kd);
    //makes 
    distanceDriven = new encoderDistanceSparkMax(groupOne, groupTwo);
      this.goalDistance = distance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //tells the PID loop how far we want to go
    drivePidController.setSetpoint(goalDistance);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //tells the PID loop how far we have moved so it can stop us
    drivePidController.calculate((distanceDriven.getGroupOneAverage() + distanceDriven.getGroupTwoAverage())/2, drivePidController.getSetpoint());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return drivePidController.atSetpoint();
  }
}
