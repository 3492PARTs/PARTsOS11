// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.teleop;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Auto.PIDDrive;
import frc.robot.subsystems.Shooter;

public class limelightDistanceAllign extends CommandBase {
  double initDist;
  /** Creates a new limelightDistanceAllign. */
  public limelightDistanceAllign() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initDist = Shooter.getballShooter().distFromFrontToTarget();
    new SequentialCommandGroup(new PIDDrive((8 * 12) - initDist), new limelightTurn());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     // 8 ft is around sweet spot and make sure were alligned
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
