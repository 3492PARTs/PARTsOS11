package frc.Utils;

import java.util.Arrays;

import com.revrobotics.RelativeEncoder;

public class encoderDistanceSparkMax extends encoderDistance {
    RelativeEncoder[] groupOne;
    RelativeEncoder[] groupTwo;
    double[] groupOneTotals;
    double[] groupTwoTotals;
    double[] initialGroupOne;
    double[] initialGroupTwo;
    double gearRatio;
    double wheelCircumference;
    /**
     * @param groupOne The first set of relative encoders on a spark max
     */
    public encoderDistanceSparkMax(RelativeEncoder[] groupOne, RelativeEncoder[] groupTwo, double gearRatio, double wheelCircumference){
        this.groupOne = groupOne;
        this.groupTwo = groupTwo;
        groupOneTotals = new double[groupOne.length];
        groupTwoTotals = new double[groupTwo.length];
        initialGroupOne = new double[groupOne.length];
        initialGroupTwo = new double[groupTwo.length];
        this.gearRatio = gearRatio;
        this.wheelCircumference = wheelCircumference;

        for (int i = 0; i < groupOne.length; i++) {
            initialGroupOne[i] = groupOne[i].getPosition();
        }
        for(int j =0; j < groupTwo.length; j++){
            initialGroupTwo[j] = groupTwo[j].getPosition();
        }
    }

    @Override
    public double getGroupOneAverage() {
        update();
        return -Average(groupOneTotals);// use onlt for left side drive train
    }
    @Override
    public double getGroupTwoAverage() {
        update();
        return Average(groupTwoTotals);
    }



    @Override
    public void update() {

        for (int i = 0; i < groupOne.length; i++) {
            groupOneTotals[i] = ((groupOne[i].getPosition()- initialGroupOne[i]) * wheelCircumference ) / gearRatio;
        }
        for (int i = 0; i < groupTwo.length; i++) {
            groupTwoTotals[i] = ((groupTwo[i].getPosition() - initialGroupTwo[i]) * wheelCircumference) / gearRatio;
        }
    }


// Average of two highest
    @Override
    protected double Average(double[] totals) { 
        int sum = 0;
        double[] tempTotal = totals.clone();
        Arrays.sort(tempTotal);
        for(int i = totals.length-1; i>0; i--){
            sum += tempTotal[i];
        }
        
        return sum/(totals.length-1);
    }


    
}
