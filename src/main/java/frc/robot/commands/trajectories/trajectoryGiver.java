// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.trajectories;

import java.util.List;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.*;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.math.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.math.util.Units;
import frc.robot.Constants;

/** Add your docs here. */
public class trajectoryGiver {

    static DifferentialDriveVoltageConstraint voltageConstraint = 
      new DifferentialDriveVoltageConstraint(new SimpleMotorFeedforward(Constants.ksVolts, Constants.kvVoltSecondsPerMeter, Constants.kMaxAccelerationMetersPerSecondSquared),
      Constants.kDriveKinematics
      , 11);

    static TrajectoryConfig config = new TrajectoryConfig(
        Constants.kMaxSpeedMetersPerSecond, 
        Constants.kMaxAccelerationMetersPerSecondSquared)
        .setKinematics(Constants.kDriveKinematics)
        .addConstraint(voltageConstraint);

      

    public static Trajectory backUp3Ft(){
        edu.wpi.first.math.trajectory.Trajectory backUp3ft = TrajectoryGenerator.generateTrajectory(
        new Pose2d(0,0, new Rotation2d(0)),
        List.of(),
         new Pose2d(Units.feetToMeters(3) , 0 , new Rotation2d(0)),
          config);
        return backUp3ft;
    }

}
