// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Utils.sparkMaxLinearDistance;
import frc.robot.subsystems.Elevator;

public class Elevate extends CommandBase {
  Elevator elevator = Elevator.getElevator();
  sparkMaxLinearDistance distance;
  double goalDistance = 0; //TODO: SET DISTANCE
  /** Creates a new Elevate. */
  public Elevate() {
    this.distance = elevator.getPersistentDistanceMeasure();
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if((distance.currentDistance() - goalDistance) > 0){
      elevator.getElevator().setElevatorSpeed(.5);
    }
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elevator.setElevatorSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (distance.currentDistance() - goalDistance) > 0;
  }
}
