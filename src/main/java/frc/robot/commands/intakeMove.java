// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Utils.TalonSRXLinearDistance;
import frc.robot.Constants.intakePivot;

public class intakeMove extends CommandBase {
  frc.robot.subsystems.Intake intake;
  TalonSRXLinearDistance distance;

  /** Creates a new intakeMove. */
  public intakeMove() {
    this.distance = intake.getPersistantDistanceMeasure();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    intake = frc.robot.subsystems.Intake.getballIntake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    intake.setPivotDirection(intakePivot.down);
    System.out.println(distance.currentDistance());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
