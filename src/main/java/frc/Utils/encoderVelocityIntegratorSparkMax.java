package frc.Utils;

import com.revrobotics.RelativeEncoder;

public class encoderVelocityIntegratorSparkMax extends encoderVelocityIntegrator {
    RelativeEncoder[] groupOne;
    RelativeEncoder[] groupTwo;
    int[] groupOneTotals;
    int[] groupTwoTotals;
    /**
     * @param groupOne The first set of relative encoders on a spark max
     */
    public encoderVelocityIntegratorSparkMax(RelativeEncoder[] groupOne, RelativeEncoder[] groupTwo){
        this.groupOne = groupOne;
        this.groupTwo = groupTwo;
        groupOneTotals = new int[groupOne.length];
        groupTwoTotals = new int[groupTwo.length];
    }

    @Override
    public int getGroupOneAverage() {
        return (int) Average(groupOneTotals);
    }
    @Override
    public int getGroupTwoAverage() {
        return (int) Average(groupTwoTotals);
    }



    @Override
    public void update() {
        // TODO Auto-generated method stub
        for (int i = 0; i < groupOne.length; i++) {
            groupOneTotals[i] += groupOne[i].getVelocity();
        }
        for (int i = 0; i < groupTwo.length; i++) {
            groupTwoTotals[i] += groupTwo[i].getVelocity();
        }
    }



    @Override
    protected double Average(int[] totals) {
        int sum = 0;
        for(int i : totals){
            sum += i;
        }
        return sum/totals.length;
    }


    
}
