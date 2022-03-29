// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils;

import frc.Utils.Util.EncoderValueInterface;

/** Add your docs here. */
public class LinearDistance{
    EncoderValueInterface distanceT;
    LinearDistance(EncoderValueInterface distanceGiver){
        this.distanceT = distanceGiver;
    }

    public double getDistance(){
        return distanceT.getDistance();
    }

}

