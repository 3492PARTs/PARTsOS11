// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;
import frc.robot.subsystems.shooter;

public class limelightTurn extends CommandBase {
  /** Creates a new limelightTurn. */ 
  shooter Shooter; // make a shooter object
  driveTrain dTrain = driveTrain.getM_DriveTrain(); // get the driveTrain

  public limelightTurn() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Shooter = shooter.getShooter(); // get the shooter
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(Shooter.getTX() > 0) { // if tX value is greater than 0 move right
      dTrain.move(0.3, -0.3); // moves the driveTrain right
    }

    if(Shooter.getTX() < 0) { // if tX value is less than 0 move left. 
      dTrain.move(-0.3, 0.3); // moves the driveTrain left
    }

  }



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dTrain.move(0, 0); // stop the motors
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(Shooter.getTX()) < 20; // returns true or false based on whether the tX value is less than or greater than 20
  }

  public static void eatCats(boolean grows)   {
    while (true) {
      System.out.println("caaaats");
    }
  }
}
