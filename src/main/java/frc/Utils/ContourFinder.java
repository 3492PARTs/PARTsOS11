// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils;

import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.MjpegServer;
import edu.wpi.first.cscore.VideoMode.PixelFormat;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/** Add your docs here. */
public class ContourFinder {
    NetworkTable table;
    String xString  = "vision";
    NetworkTableEntry xTableEntry;
    NetworkTableInstance inst = NetworkTableInstance.getDefault();

    public ContourFinder(NetworkTableInstance table){
        this.table = inst.getTable(xString);
        
        xTableEntry = table.getEntry(xString);
        
    }


    public double[] getBallXCords(){
        return xTableEntry.getDoubleArray( new double[] {0.0});
    }
    
    public void publishImage(){
        CvSource cvSource = new CvSource("name", PixelFormat.kGray, 60, 120, 20);
        MjpegServer mjpegServer2 = new MjpegServer("serve_Blur", 1182);
        mjpegServer2.setSource(cvSource);
    }
    
}
