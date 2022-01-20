package frc.Utils;
// a class that has the required methods and variables to be applied to all motor controllers on the robot
public abstract class encoderDistance {
    private int groupOneAverage, groupTwoAverage;
    private double[] initialGroupOne, initialGroupTwo;


    public void update(){}

    public double getGroupOneAverage(){
        return groupOneAverage;
    }

    public double getGroupTwoAverage(){
        return groupTwoAverage;
    }
    // apparently Java doesnt have a built in array average method
    protected double Average(double[] totals){
        return groupOneAverage; //not what it really should return
    }
    


}
