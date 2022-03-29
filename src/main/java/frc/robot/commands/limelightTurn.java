// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.swing.text.html.parser.DTD;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.*;

public class limelightTurn extends CommandBase {
  /** Creates a new limelightTurn. */ 
  frc.robot.subsystems.Shooter Shooter; // make a shooter object
  driveTrain dTrain = driveTrain.getM_DriveTrain(); // get the driveTrain
  long initTime;
  PIDController pidTurn = new PIDController(Constants.PIDLimelightConstants[0], Constants.PIDLimelightConstants[1], Constants.PIDLimelightConstants[2]);
  public limelightTurn() {
    // Use addRequirements() here to declare subsystem dependencies.
  
  }
  double gyroOffset;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Shooter = frc.robot.subsystems.Shooter.getballShooter(); // get the shooter
     gyroOffset = dTrain.getAngle();
    initTime = System.currentTimeMillis();





    pidTurn.setSetpoint(Shooter.getTX());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
   double Output = pidTurn.calculate(dTrain.getAngle() - gyroOffset);
   MathUtil.clamp(Output, -.35, .35);
    driveTrain.getM_DriveTrain().move(-Output, Output);
  

  }



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dTrain.move(0, 0); // stop the motors
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (pidTurn.atSetpoint() && (dTrain.gyroVelocity() > 10)) || (System.currentTimeMillis() - initTime )> 3000; // returns true or false based on whether the tX value is less than or greater than 20
  }


}
