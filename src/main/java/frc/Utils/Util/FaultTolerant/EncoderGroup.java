// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.Utils.Util.FaultTolerant;

import frc.Utils.LinearDistance;

/** Add your docs here. */
public class EncoderGroup {
    LinearDistance[] distances;
    double[] initials;
    double[] totals;
    double mean;

    // only use for groups of at least 3 senseors
    public EncoderGroup(LinearDistance[] distances){
        this.distances = distances;

        for (int i = 0; i < distances.length; i++) {
            initials[i] = distances[i].getDistance();
        }
    }
    
    private double sd(){

        double sum = 0.0, standardDeviation = 0.0;
        int length = totals.length;

        for(double num : totals) {
            sum += num;
        }

        this.mean = sum/length;

        for(double num: totals) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation/length);
        
    }

    public double faultTolerantTotal(){
        double sum = 0;
        double lengthWithoutZeroes = 0;
        double sd = sd();
        for (int i = 0; i < totals.length; i++) {
                if((Math.abs(totals[i]) > (2 * sd * mean)) || (Math.abs(totals[i]) < (2 * sd * mean) )){
                    totals[i] = 0;
                }
                sum += totals[i];
        }

        for (double i : totals) {
            if(i < .001){
                break;
            }
            else{
                lengthWithoutZeroes++;
            }
            
        }

        return sum/lengthWithoutZeroes;

        


    }


}
