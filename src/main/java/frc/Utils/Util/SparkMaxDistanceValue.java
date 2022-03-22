// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils.Util;

import com.revrobotics.CANSparkMax;

/** Add your docs here. */
public class SparkMaxDistanceValue implements EncoderValueInterface<CANSparkMax> {

    CANSparkMax sparkMax;
    SparkMaxDistanceValue(CANSparkMax sparkMax){
        this.sparkMax = sparkMax;

    }

    @Override
    public double getDistance() {
        // TODO Auto-generated method stub
        return sparkMax.getEncoder().getPosition();
    }



}
