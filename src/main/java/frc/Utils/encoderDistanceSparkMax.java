package frc.Utils;

import com.revrobotics.RelativeEncoder;

public class encoderDistanceSparkMax extends encoderDistance {
    RelativeEncoder[] groupOne;
    RelativeEncoder[] groupTwo;
    double[] groupOneTotals;
    double[] groupTwoTotals;
    double[] initialGroupOne;
    double[] initialGroupTwo;
    /**
     * @param groupOne The first set of relative encoders on a spark max
     */
    public encoderDistanceSparkMax(RelativeEncoder[] groupOne, RelativeEncoder[] groupTwo){
        this.groupOne = groupOne;
        this.groupTwo = groupTwo;
        groupOneTotals = new double[groupOne.length];
        groupTwoTotals = new double[groupTwo.length];
        initialGroupOne = new double[groupOne.length];
        initialGroupTwo = new double[groupTwo.length];

        for (int i = 0; i < groupOne.length; i++) {
            initialGroupOne[i] = groupOne[i].getPosition();
        }
    }

    @Override
    public double getGroupOneAverage() {
        return Average(groupOneTotals);
    }
    @Override
    public double getGroupTwoAverage() {
        return Average(groupTwoTotals);
    }



    @Override
    public void update() {

        for (int i = 0; i < groupOne.length; i++) {
            groupOneTotals[i] = (groupOne[i].getPosition()- initialGroupOne[i]);
        }
        for (int i = 0; i < groupTwo.length; i++) {
            groupTwoTotals[i] = (groupTwo[i].getPosition() - initialGroupTwo[i]);
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
