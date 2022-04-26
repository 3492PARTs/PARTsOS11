// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.teleop;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Auto.PIDDrive;
import frc.robot.subsystems.Shooter;

public class limelightDistanceAllign extends SequentialCommandGroup {
  double initDist;
  /** Creates a new limelightDistanceAllign. */
  public limelightDistanceAllign() {
    // Use addRequirements() here to declare subsystem dependencies.
    initDist = Shooter.getballShooter().distFromFrontToTarget();

    addCommands(new PIDDrive((8 * 12) - initDist), new limelightTurn());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initDist = Shooter.getballShooter().distFromFrontToTarget();
    new SequentialCommandGroup(new PIDDrive((8 * 12) - initDist), new limelightTurn());
  }

  
}
