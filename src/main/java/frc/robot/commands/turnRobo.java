// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain;

public class turnRobo extends CommandBase {
  double angle;
  driveTrain m_DriveTrain = driveTrain.getM_DriveTrain();
  PIDController pidTurn = new PIDController(kp, ki, kd);
  /** Creates a new turnRobo. */
  public turnRobo(double angle){
    this.angle = angle;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pidTurn.setSetpoint(angle);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  
  double Output = pidTurn.calculate(m_DriveTrain.getAngle());

  m_DriveTrain.move(Output,-Output);

  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pidTurn.atSetpoint();
  }
}
