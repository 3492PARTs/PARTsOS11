// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.HttpCamera;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Shooter;

/** Add your docs here. */
public class sDashBoard {

    sDashBoard(){
        CameraServer.startAutomaticCapture(0);
    }


    public void alwaysUpdate(){
        
        
   
    
    }

    public void robotInitUpdate(){
        SmartDashboard.putNumber(Constants.SD_AUTO_DELAY, 0.0);
    }

    public void TeleopUpdate(){
        SmartDashboard.putNumber("distance to target", Shooter.getballShooter().distFromFrontToTarget());
        SmartDashboard.putBoolean("Distance to Target", (Shooter.getballShooter().distFromFrontToTarget() > 3 && Shooter.getballShooter().distFromFrontToTarget()< 5));
    }


    public static sDashBoard getsDashBoard(){
        return _staticSmartDashboard;
    }
    // =====================================================================================
    // Define Singleton Pattern
    // =====================================================================================
    private static sDashBoard _staticSmartDashboard = new sDashBoard();






    
}
