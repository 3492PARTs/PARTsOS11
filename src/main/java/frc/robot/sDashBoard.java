// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.HttpCamera;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** Add your docs here. */
public class sDashBoard {

    sDashBoard(){}


    public void alwaysUpdate(){
        CameraServer.startAutomaticCapture(0);
        HttpCamera limeLight = new HttpCamera("LimeLight", "http://10.34.92.103:5800/stream.mpeg"); 
   
    
    }

    public void robotInitUpdate(){
        SmartDashboard.putNumber(Constants.SD_AUTO_DELAY, 0.0);
    }


    public static sDashBoard getsDashBoard(){
        return _staticSmartDashboard;
    }
    // =====================================================================================
    // Define Singleton Pattern
    // =====================================================================================
    private static sDashBoard _staticSmartDashboard = new sDashBoard();






    
}
