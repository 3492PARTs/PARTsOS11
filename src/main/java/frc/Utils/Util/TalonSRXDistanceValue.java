// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils.Util;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

/** Add your docs here. */
public class TalonSRXDistanceValue implements EncoderValueInterface<TalonSRX>{
    TalonSRX talonSRX;
    TalonSRXDistanceValue(CANSparkMax sparkMax){
        this.talonSRX = talonSRX;
    }

    @Override
    public double getDistance() {

        return talonSRX.getSelectedSensorPosition();
    
    }
    
}
