// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;

import com.ctre.phoenix.Util;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Utils.encoderDistanceSparkMax;
import frc.robot.Constants;
import frc.robot.subsystems.driveTrain;

public class PIDDrive extends CommandBase {
  PIDController drivePidController;
  encoderDistanceSparkMax distanceDriven;
  double goalDistance;
  double[] pidConstants = Constants.PIDDriveConstants;
  double maxSpeed = 1;
  
  driveTrain mdDriveTrain = driveTrain.getM_DriveTrain();
  /** Creates a new PIDDrive. */
  public PIDDrive(double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    // makes a PID controller object
    drivePidController = new PIDController(pidConstants[0], pidConstants[1], pidConstants[2]);
    //makes 
  
    
      this.goalDistance = distance;
  }
  public PIDDrive(double distance , double maxSpeed) {
    this.maxSpeed = maxSpeed;
    // Use addRequirements() here to declare subsystem dependencies.
    // makes a PID controller object
    drivePidController = new PIDController(pidConstants[0], pidConstants[1], pidConstants[2]);
    //makes 
  
    
      this.goalDistance = distance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //tells the PID loop how far we want to go
    this.distanceDriven = mdDriveTrain.getDriveTrainDistanceMeasure();
    drivePidController.setSetpoint(goalDistance);
    drivePidController.setTolerance(.6);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //tells the PID loop how far we have moved so it can stop us
    double Output = drivePidController.calculate((distanceDriven.getGroupOneAverage() + distanceDriven.getGroupTwoAverage())/2, drivePidController.getSetpoint());
    Output = MathUtil.clamp(Output, -maxSpeed, maxSpeed);
 
    System.out.println(distanceDriven.getGroupOneAverage());
    System.out.println(distanceDriven.getGroupTwoAverage());

    mdDriveTrain.move(.5 * Output, .5 *Output);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("done");
    mdDriveTrain.move(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return drivePidController.atSetpoint() && (Math.abs(mdDriveTrain.getLeftVelocity())< .30) && (Math.abs(mdDriveTrain.getRightVelocity()) < 0.3);
  }
}
