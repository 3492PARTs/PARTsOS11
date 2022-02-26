// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/** Add your docs here. */
public class encoderDistanceTalonSRX extends encoderDistance{
    TalonSRX[] groupOne;
  
    double[] groupOneTotals;

    double[] initialGroupOne;

    double gearRatio;
    double wheelCircumference;

    public encoderDistanceTalonSRX(TalonSRX[] groupOne, double gearRatio, double wheelCircumference) {
        this.groupOne = groupOne;
        groupOneTotals = new double[groupOne.length];

        initialGroupOne = new double[groupOne.length];

        this.gearRatio = gearRatio;
        this.wheelCircumference = wheelCircumference;

        for (int i = 0; i < groupOne.length; i++) {
            initialGroupOne[i] = groupOne[i].getSelectedSensorPosition();
        }
    }
    
    @Override
    public double getGroupOneAverage() {
        return Average(groupOneTotals);
    }




    @Override
    public void update() {

        for (int i = 0; i < groupOne.length; i++) {
            groupOneTotals[i] = ((groupOne[i].getSelectedSensorPosition()- initialGroupOne[i]) * wheelCircumference ) / gearRatio;
        }
       
    }



    @Override
    protected double Average(double[] totals) {
        int sum = 0;
        for(double i : totals){
            sum += i;
        }
        return sum/totals.length;
    }



}
