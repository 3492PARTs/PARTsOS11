// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils;

import com.revrobotics.RelativeEncoder;

/** Add your docs here. */
public class sparkMaxLinearDistance {
    RelativeEncoder distanceReader;
    double distancePerTick;
    double initial;
    double total;
    public sparkMaxLinearDistance(RelativeEncoder distanceReader, double distancePerTick){
        this.distanceReader = distanceReader;
        initial = distanceReader.getPosition();
        this.distancePerTick = distancePerTick;
        total = 0;
    }

    double currentDistance(){
        total = (distanceReader.getPosition() - initial) * distancePerTick ;
        return total;
    }





}
