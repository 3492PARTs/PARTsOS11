// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** Add your docs here. */
public class sDashBoard {

    sDashBoard(){}



    public void robotInitUpdate(){
        SmartDashboard.putNumber(Constants.SD_AUTO_DELAY, 0.0);
    }

    // =====================================================================================
    // Define Singleton Pattern
    // =====================================================================================
    private static sDashBoard _staticSmartDashboard = new sDashBoard();






    
}
