// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.Utils.encoderDistanceTalonSRX;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

public class Index extends CommandBase {
  Indexer indexer = Indexer.getIndexer();
  encoderDistanceTalonSRX distanceMeasure = indexer.getNonPersistantDistanceMeasure();
  double shooterWheelSpeed = -60;
  long initTime;
  boolean check;
  
  /** Creates a new Index. */
  public Index() {
    // Use addRequirements() here to declare subsystem dependencies.
    
  }

  public Index(boolean check){
    this.check = check;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      initTime = System.currentTimeMillis();


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {  
    System.out.println(Shooter.getballShooter().getRPM());  
   
    if(Shooter.getballShooter().getRPM() < shooterWheelSpeed){
      indexer.setIndexerSpeed(-1);
    
    }
    if(!check){
      indexer.setIndexerSpeed(-1);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    indexer.setIndexerSpeed(0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - initTime) > 2500;
  }
}
