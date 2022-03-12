// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/** Add your docs here. */
public class TalonSRXLinearDistance {


    TalonSRX distanceReader;
    double distancePerTick;
    double initial;
    double total;
    public TalonSRXLinearDistance(TalonSRX distanceReader, double distancePerTick){
        this.distanceReader = distanceReader;
        initial = distanceReader.getSelectedSensorPosition();
        this.distancePerTick = distancePerTick;
        total = 0;
    }

    public double currentDistance(){
        total = (distanceReader.getSelectedSensorPosition() - initial) * distancePerTick ;
        return total;
    }


}
