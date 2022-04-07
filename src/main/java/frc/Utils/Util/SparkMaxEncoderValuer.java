// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils.Util;

import com.revrobotics.CANSparkMax;

/** Add your docs here. */
public class SparkMaxEncoderValuer implements EncoderValueInterface{
    CANSparkMax sparkMax;
    SparkMaxEncoderValuer(CANSparkMax sparkMax){
        this.sparkMax = sparkMax;
    }

    @Override
    public double getDistance() {

        return sparkMax.getEncoder().getPosition();
    
    }
    
}
