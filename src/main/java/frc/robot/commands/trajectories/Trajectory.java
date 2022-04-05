// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.trajectories;

import java.util.List;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Trajectory extends SequentialCommandGroup {
  /** Creates a new Trajectory. */
  public Trajectory() {
        DifferentialDriveVoltageConstraint voltageConstraint;

    voltageConstraint = 
      new DifferentialDriveVoltageConstraint(new SimpleMotorFeedforward(Constants.ksVolts, Constants.kvVoltSecondsPerMeter, Constants.kMaxAccelerationMetersPerSecondSquared),
      Constants.kDriveKinematics
      , 11);

      TrajectoryConfig config = new TrajectoryConfig(
        Constants.kMaxSpeedMetersPerSecond, 
        Constants.kMaxAccelerationMetersPerSecondSquared)
        .setKinematics(Constants.kDriveKinematics)
        .addConstraint(voltageConstraint);

      edu.wpi.first.math.trajectory.Trajectory testTrajectory = TrajectoryGenerator.generateTrajectory(
        new Pose2d(0,0, new Rotation2d(0)),
        List.of(new Translation2d(1,1), new Translation2d(2 ,-1)),
         new Pose2d(3 ,0 , new Rotation2d(0)),
          config);

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
       



    );
  }
}
