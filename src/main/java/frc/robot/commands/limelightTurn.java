// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class limelightTurn extends CommandBase {
  /** Creates a new limelightTurn. */ 
  frc.robot.subsystems.Shooter Shooter; // make a shooter object
  driveTrain dTrain = driveTrain.getM_DriveTrain(); // get the driveTrain
  PIDController pidTurn = new PIDController(Constants.PIDTurnConstants[0], Constants.PIDTurnConstants[1], Constants.PIDTurnConstants[2]);
  public limelightTurn() {
    // Use addRequirements() here to declare subsystem dependencies.
  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Shooter = frc.robot.subsystems.Shooter.getballShooter(); // get the shooter



    pidTurn.setSetpoint(Shooter.getTX());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

   double Output = pidTurn.calculate(Shooter.getTX());
   MathUtil.clamp(Output, -.6, .6);
    driveTrain.getM_DriveTrain().move(Output, -Output);
  

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


}
