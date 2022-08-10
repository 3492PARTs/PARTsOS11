// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.teleop;


import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Utils.controls.beanieController;
import frc.robot.subsystems.driveTrain;

public class driveControllerCom extends CommandBase {
  beanieController controller;
  SlewRateLimiter turnSensitivity = new SlewRateLimiter(.6, .4);
  /** Creates a new driveControllerCom. */
  public driveControllerCom(beanieController controller) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.controller = controller;
    addRequirements(driveTrain.getM_DriveTrain());
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    driveTrain.getM_DriveTrain().arcadeDrive(controller.getLeftYAxis(), turnSensitivity.calculate( controller.getRightXAxis()));
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
