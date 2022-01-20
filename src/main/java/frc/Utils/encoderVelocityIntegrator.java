package frc.Utils;
// a class that has the required methods and variables to be applied to all motor controllers on the robot
public abstract class encoderVelocityIntegrator {
    private int groupOneAverage, groupTwoAverage;



    public void update(){}

    public int getGroupOneAverage(){
        return groupOneAverage;
    }

    public int getGroupTwoAverage(){
        return groupTwoAverage;
    }
    // apparently Java doesnt have a built in array average method
    protected double Average(int[] totals){
        return groupOneAverage; //not what it really should return
    }
    


}
