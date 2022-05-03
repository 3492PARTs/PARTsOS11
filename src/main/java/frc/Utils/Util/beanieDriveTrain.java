// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils.Util;

import edu.wpi.first.math.geometry.Pose2d;

/** Add your docs here. */
public interface beanieDriveTrain {

    public void move();

    public void moveVolts();

    public void moveArcade();

    public Pose2d currentPose();

    public double getAngle();

}
