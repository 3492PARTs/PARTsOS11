// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils.controls;

/** Add your docs here. */
public enum Rumbler {
    max(1.0d),
    half(.5),
    stop(0);

    private double value;

    private Rumbler(double value){
        this.value = value;
    }

    public double getRumbler(){
        return value;
    }

}
